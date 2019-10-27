package com.jagt.employ.common.tools;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 
 * 继承commons-io包的FileUtils
 * 
 * @version  1.0
 * @author   gotanks
 * @since     2019-04-08
 * 
 */
public class File_ extends FileUtils{
	
	public static File createFile(String filePath) {
		File file = new File(filePath);
		return createFile(file);
	}
	
	public static File createFile(File file) {
		File parentFile = file.getParentFile();
		if(!parentFile.exists()) {
			parentFile.mkdirs();
		}
		return file;
	}
}
