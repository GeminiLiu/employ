package com.jagt.employ.common.tools.ftp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * SFTP上传下载工具类
 *
 * @version  1.1
 * @author   gotanks
 * @since     2019-04-19
 *
 */
@Slf4j
public class SFtpUtils extends BaseFtp implements IFtpUtils{

    private ChannelSftp channel = null;
    private Session sshSession = null;

    public SFtpUtils(String host, int port, String username, String password) {
    	super(host, port, username, password);
    }

    @Override
    public IFtpUtils connect() {
    	try {
	        JSch jsch = new JSch();
	        if (port <= 0) {
	        	// 连接服务器，采用默认端口
				sshSession = jsch.getSession(username, host);
	       	} else {
	        	// 采用指定的端口连接服务器
	        	sshSession = jsch.getSession(username, host, port);
	        }
	        // 如果服务器连接不上，则抛出异常
	        if (sshSession == null) {
				log.info("未连接到FTP，用户名或密码错误。");
	        	throw new JSchException("服务器异常");
	        }
	        sshSession.setPassword(password);
	        Properties sshConfig = new Properties();
	        sshConfig.put("StrictHostKeyChecking", "no");
	        sshSession.setConfig(sshConfig);
	        sshSession.connect();
	        Channel channel = sshSession.openChannel("sftp");
	        if (channel != null) {
	            channel.connect();
				log.info("FTP连接成功。");
	        } else {
	            throw new JSchException("channel connecting failed.");
	        }
	        this.channel = (ChannelSftp) channel;

		} catch (JSchException e) {
			log.info("SFTP参数可能错误，请正确配置。" + e);
			e.printStackTrace();
		}
        return this;
    }

    @Override
    public void disconnect() {
    	try {
			if (this.channel != null) {
				if (this.channel.isConnected()) {
					this.channel.disconnect();
				}
			}
			if (this.sshSession != null) {
				if (this.sshSession.isConnected()) {
					this.sshSession.disconnect();
				}
			}
		}catch (Exception e){
			log.info("FTP service close exception：", e);
		}
    }

    @Override
    public boolean deleteFile(String directory, String deleteFile) throws Exception {
        if(channel != null) {
            channel.cd(directory);
            channel.rm(deleteFile);
            return true;
        }else {
            return false;
        }
    }
    
    protected boolean changeDir(String createPath) {
        try {
            if (!isDirExist(createPath)) {
            	String pathArry[] = createPath.split("/");
            	StringBuffer filePath = new StringBuffer("/");
            	for (String path : pathArry) {
            		if (path.equals("")) {
            			continue;
            		}
            		filePath.append(path + "/");
            		String dir = filePath.toString();
            		if (!isDirExist(dir)) {
            			channel.mkdir(dir);
            		}
            		channel.cd(dir);
            	}
            }
            this.channel.cd(createPath);
            return true;
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean isDirExist(String directory) {
        boolean isDirExistFlag = false;
        try {
            SftpATTRS sftpATTRS = channel.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        } catch (Exception e) {
            if (e.getMessage().toLowerCase().equals("no such file")) {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }

	@Override
	protected boolean uploadToFtp(String remotePath, String remoteFileName, InputStream input) {
		try {
			if(this.changeDir(remotePath)) {
				channel.put(input, remoteFileName);
				return true;
			}
		} catch (SftpException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected boolean downloadFromFtp(String remotePath, String remoteFileName, OutputStream output) {
		try {
			channel.cd(remotePath);
			channel.get(remoteFileName, output);
			return true;
		} catch (SftpException e) {
			e.printStackTrace();
		}
		return false;
	}

}