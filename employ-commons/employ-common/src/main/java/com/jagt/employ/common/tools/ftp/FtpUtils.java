package com.jagt.employ.common.tools.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import lombok.extern.slf4j.Slf4j;
/**
 *
 * FTP上传下载工具类
 *
 * @version  1.0
 * @author   gotanks
 * @since     2019-04-02
 *
 */
@Slf4j
public class FtpUtils extends BaseFtp implements IFtpUtils{

    public FTPClient ftpClient;

    public FtpUtils(String host, int port, String username, String password) {
    	super(host, port, username, password);
    }

    @Override
    public IFtpUtils connect() {
    	try {
            ftpClient = new FTPClient();
            // 连接FTP服务器
            ftpClient.connect(host, port);
            // 登陆FTP服务器
            ftpClient.login(username, password);
            
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                log.info("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
            	log.info("FTP连接成功。");
            }
        } catch (SocketException e) {
        	log.info("FTP的IP地址可能错误，请正确配置。" + e);
        } catch (IOException e) {
        	log.info("FTP的端口错误,请正确配置。" + e);
        }
        return this;
    }

    @Override
    public void disconnect() {
    	try {
			if (ftpClient != null) {
				ftpClient.logout();
				ftpClient.disconnect();
			}
		} catch (IOException e) {
			log.info("FTP service close exception：", e);
			e.printStackTrace();
        }
    }

    @Override
    public boolean deleteFile(String directory, String deleteFile) throws IOException {
    	boolean flag = false;
        if (ftpClient != null) {
            flag = ftpClient.deleteFile(directory + deleteFile);
        }
        return flag;
    }

    protected boolean changeDir(String createpath) {
        try {
            if (!isDirExist(createpath)) {
            	String pathArry[] = createpath.split("/");
            	StringBuffer filePath = new StringBuffer("/");
            	for (String path : pathArry) {
            		if (path.equals("")) {
            			continue;
            		}
            		filePath.append(path + "/");
            		String dir = filePath.toString();
            		if (!isDirExist(dir)) {
            			ftpClient.makeDirectory(createpath);
            		}
            		ftpClient.changeWorkingDirectory(dir);
            	}
            }
            ftpClient.changeWorkingDirectory(createpath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean isDirExist(String directory) {
        boolean isDirExistFlag = false;
        try {
        	isDirExistFlag = ftpClient.changeWorkingDirectory(directory);
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
			if(changeDir(remotePath)) {
				return ftpClient.storeFile(remoteFileName, input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected boolean downloadFromFtp(String remotePath, String remoteFileName, OutputStream output) {
		try {
			ftpClient.changeWorkingDirectory(remotePath);
			return ftpClient.retrieveFile(remoteFileName, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}