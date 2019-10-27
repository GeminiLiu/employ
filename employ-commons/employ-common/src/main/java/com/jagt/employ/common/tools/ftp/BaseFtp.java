package com.jagt.employ.common.tools.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseFtp implements IFtpUtils{

    protected String host;
    protected int port ;
    protected String username;
    protected String password;

    protected boolean autoClose;

	public BaseFtp(String host, int port, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
        //默认自动关闭连接
        this.autoClose = true;
    }

    @Override
    public abstract IFtpUtils connect();

    @Override
    public abstract void disconnect();

    @Override
    public boolean upload(String remotePath, String remoteFileName, String localPath, String localFileName) {
    	boolean result = false;
    	File file = new File(localPath, localFileName);
		try (FileInputStream input = new FileInputStream(file)){
            result = this.upload(remotePath, remoteFileName, input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
    }

    @Override
    public boolean upload(String remotePath, String remoteFileName, InputStream input) {
    	boolean result = false;
    	try {
    		if(changeDir(remotePath)) {
    			result = uploadToFtp(remotePath, remoteFileName, input);
    		}
		} finally {
			if(autoClose) {
				this.disconnect();
			}
		}
		return result;
    }

    @Override
    public boolean download(String remotePath, String remoteFileName, String localPath, String localFileName) {
    	File localFile = new File(localPath , localFileName);
    	try (OutputStream output = new FileOutputStream(localFile)){
            mkdirs(localPath + localFileName);
            return downloadFromFtp(remotePath, remoteFileName, output);
        } catch (FileNotFoundException e) {
            log.error("没有找到" + remotePath + "文件，" + e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
			if(autoClose) {
				this.disconnect();
			}
        }
        return false;
    }

    @Override
    public boolean delete(String directory, String deleteFile) {
        boolean flag = false;
        try {
            flag = deleteFile(directory, deleteFile);
        } catch (Exception e) {
            log.error("删除文件失败", e);
        }finally {
            if(autoClose) {
                this.disconnect();
            }
        }
        return flag;
    }

    public abstract boolean deleteFile(String directory, String deleteFile) throws Exception;
    
    protected abstract boolean uploadToFtp(String remotePath, String remoteFileName, InputStream input);
    
    protected abstract boolean downloadFromFtp(String remotePath, String remoteFileName, OutputStream output);

    protected abstract boolean changeDir(String createpath);
    
    protected abstract boolean isDirExist(String directory);

    protected void mkdirs(String path) {
        File f = new File(path);
        String fs = f.getParent();
        f = new File(fs);
        if (!f.exists()) {
            f.mkdirs();
        }
    }
    
    protected boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		}
		if (!file.isFile()) {
			return false;
		}
		return file.delete();
	}

    @Override
    public BaseFtp autoClose(boolean autoClose) {
		this.autoClose = autoClose;
		return this;
	}

}