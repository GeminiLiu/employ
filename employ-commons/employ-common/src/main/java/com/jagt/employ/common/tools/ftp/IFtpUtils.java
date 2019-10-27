package com.jagt.employ.common.tools.ftp;

import java.io.InputStream;

public interface IFtpUtils {
	/**
	 * 连接ftp服务器
	 * @return
	 * @throws Exception
	 */
	IFtpUtils connect();
	
	/**
	 * 断开ftp服务器
	 */
	void disconnect();
	
	/**
	 * 上传文件
	 * @param remotePath
	 * @param remoteFileName
	 * @param localPath
	 * @param localFileName
	 * @return
	 */
	boolean upload(String remotePath, String remoteFileName, String localPath, String localFileName);

	/**
	 * 上传文件
	 * @param remotePath
	 * @param remoteFileName
	 * @param input
	 * @return
	 */
	boolean upload(String remotePath, String remoteFileName, InputStream input);
	
	/**
	 * 下载文件
	 * @param remotePath
	 * @param remoteFileName
	 * @param localPath
	 * @param localFileName
	 * @return
	 */
	boolean download(String remotePath, String remoteFileName,
            String localPath, String localFileName);
	
	
	/**
	 * 删除文件
	 * @param directory
	 * @param deleteFile
	 * @return
	 */
	boolean delete(String directory, String deleteFile);
	
	/**
	 * 是否自动断开连接 (默认为true，即自动断开)
	 * @param autoClose
	 * @return
	 */
	IFtpUtils autoClose(boolean autoClose);
}
