package com.jagt.employ.common.tools;

import com.jagt.employ.common.tools.ftp.FtpUtils;
import com.jagt.employ.common.tools.ftp.IFtpUtils;
import com.jagt.employ.common.tools.ftp.SFtpUtils;

/**
 * 
 * FTP上传下载工具类
 * 
 * @version  1.0
 * @author   gotanks
 * @since     2019-04-02
 * 
 */
public class Ftp_ {
	private Ftp_() {
	}

	/**
	 * 连接ftp
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 */
	public static IFtpUtils connectFTP(String host, int port, String username, String password) {
		IFtpUtils ftpUtils = new FtpUtils(host, port, username, password);
		ftpUtils.connect();
		return ftpUtils;
	}
	
	/**
	 * 连接sftp
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 */
	public static IFtpUtils connectSFTP(String host, int port, String username, String password) {
		IFtpUtils ftpUtils = new SFtpUtils(host, port, username, password);
		ftpUtils.connect();
		return ftpUtils;
	}
}
