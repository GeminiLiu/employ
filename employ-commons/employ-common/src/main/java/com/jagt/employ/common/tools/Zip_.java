package com.jagt.employ.common.tools;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.zip.ZipException;

/**
 * 
 * 基于common-compress的zip压缩工具类
 * 
 * @version  1.0
 * @author   gotanks
 * @since    2019-04-08
 * 
 */
public final class Zip_ {

	enum CompressType {
		ZIP//, JAR, GZIP
	}
	
	/**
	 * 压缩文件或文件夹至指定的目录
	 * @param srcFileOrDirPath 需要压缩的文件或文件夹
	 * @param destFilePath     压缩后的文件
	 */
	public static void zip(String srcFileOrDirPath, String destFilePath) {
		if(srcFileOrDirPath.toLowerCase().startsWith("http")) {
			zipAfterDownload(srcFileOrDirPath, null, destFilePath);
		}else {
			zip(new File(srcFileOrDirPath), new File(destFilePath));
		}
	}

	/**
	 * 压缩文件或文件夹至指定的目录
	 * @param srcFileOrDir 需要压缩的文件或文件夹
	 * @param destFile     压缩后的文件
	 */
	public static void zip(File srcFileOrDir, File destFile) {
		zip(srcFileOrDir, destFile, CompressType.ZIP);
	}

	/**
	 * 压缩文件或文件夹至指定的目录
	 * @param srcFileOrDir 需要压缩的文件或文件夹
	 * @param destFile     压缩后的文件
	 * @param type       压缩类型
	 */
	protected static void zip(String srcFileOrDir, String destFile, CompressType type) {
		zip(new File(srcFileOrDir), new File(destFile), type);
	}
 
	/**
	 * 初始化压缩包信息并开始进行压缩
	 * 
	 * @param srcFileOrDir  需要压缩的文件或文件夹
	 * @param destFile 压缩后的文件
	 * @param type       压缩类型
	 */
	protected static void zip(File srcFileOrDir, File destFile, CompressType type) {
        ZipArchiveOutputStream zaos = null;
        try {
			String name = srcFileOrDir.getName();
			
			//对输出文件进行处理，自动创建不存在的文件夹
			File_.createFile(destFile);
        	
            zaos = new ZipArchiveOutputStream(destFile);
            zaos.setUseZip64(Zip64Mode.AsNeeded);
            zipFile(zaos, srcFileOrDir, name);
            zaos.finish();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
			IOUtils.closeQuietly(zaos);
        }
	}
	
	/**
	 * 下载后压缩至指定目录
	 * @param srcUrl       需要下载的文件
	 * @param fileName     下载指定的文件名
	 * @param destFilePath 压缩后的文件
	 */
	public static void zipAfterDownload(String srcUrl, String fileName, String destFilePath) {
		if(!srcUrl.toLowerCase().startsWith("http")) {
			return;
		}
		File destFile = new File(destFilePath);
		// url中的文件名
		String name = fileName;
		if(name == null) {
			name = new File(srcUrl).getName();
		}
		// 下载临时存放路径
		int destFilePathNum = destFile.getPath().lastIndexOf(File.separator);
		String tempSrcPath = new StringBuilder()
				.append(destFile.getPath().substring(0, destFilePathNum))
				.append(File.separator)
				.append(UUID_.genCurrentTimeId())
				.append(File.separator)
				.append(name)
				.toString();
		// 下载
		File tempSrcFile = File_.createFile(tempSrcPath);
		File file = null;//HttpClient_.download(srcUrl, tempSrcFile);
		// 压缩
		zip(file, destFile);
		//删除临时路径
		file.delete();
		file.getParentFile().delete();
	}
 
	/**
	 * 如果是单个文件，那么就直接进行压缩。如果是文件夹，那么递归压缩所有文件夹里的文件
	 * 
	 * @param zaos       压缩输出流
	 * @param srcFileOrDir 需要压缩的文件
	 * @param path      需要压缩的文件在压缩包里的路径
	 */
	private static void zipFile(ZipArchiveOutputStream zaos, File srcFileOrDir, String path) {
		if (srcFileOrDir.isDirectory()) {
			// 记录压缩包中文件的全路径
			String p = null;
			File[] fileList = srcFileOrDir.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				
				File file = fileList[i];
				// 如果路径为空，说明是根目录
				if (path == null || path.isEmpty()) {
					p = file.getName();
				} else {
					p = path + File.separator + file.getName();
				}
				// 打印路径
				System.out.println(p);
				
				// 如果是目录递归调用，直到遇到文件为止
				zipFile(zaos, file, p);
			}
		} else {
			zipSingleFile(zaos, srcFileOrDir, path);
		}
	}
 
	/**
	 * 压缩单个文件到指定压缩流里
	 * 
	 * @param zaos       压缩输出流
	 * @param srcFileOrDir 需要压缩的文件
	 * @param path      需要压缩的文件在压缩包里的路径
	 * @throws FileNotFoundException
	 */
	private static void zipSingleFile(ZipArchiveOutputStream zaos, File srcFileOrDir, String path) {
		InputStream in = null;
		try {
			in = new FileInputStream(srcFileOrDir);
			zaos.putArchiveEntry(new ZipArchiveEntry(srcFileOrDir, path));
			IOUtils.copy(in, zaos);
            zaos.closeArchiveEntry(); 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	/**
	 * 解压压缩包到指定目录
	 * 
	 * @param srcFile
	 * @param destFile
	 */
	public static void unZip(String srcFile, String destFile) {
		unZip(new File(srcFile), new File(destFile));
	}
 
	/**
	 * 解压压缩包到指定目录
	 * 
	 * @param srcFile
	 * @param destFile
	 */
	public static void unZip(File srcFile, File destFile) {
		if (!destFile.exists()) {
			destFile.mkdirs();
		}

		ZipArchiveInputStream zais = null;
		OutputStream os = null;
		try {
			InputStream is = new FileInputStream(srcFile);
			ArchiveEntry archiveEntry = null;
			File file = null;
			zais = new ZipArchiveInputStream(is);
			String path = destFile.getAbsolutePath() + File.separator;
			while ((archiveEntry = zais.getNextEntry()) != null) {
				String name = archiveEntry.getName();
				
				//如果是文件夹，则跳过
				if(name.endsWith(File.separator) || name.endsWith("/")) {
					continue;
				}
				// 构造解压出来的文件存放路径
				String entryFilePath = path + name;

				// 创建文件缺失的目录（不然会报异常：找不到指定文件）
				String p = new File(entryFilePath).getPath();
				file = new File(p.substring(0, p.lastIndexOf(File.separator)));
				file.mkdirs();

				try {
					// 创建文件输出流
					os = new FileOutputStream(entryFilePath);
					// 写出解压后文件数据
					IOUtils.copy(zais, os);
				} finally {
					IOUtils.closeQuietly(os);
				}
			} 
			
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(zais);
		}
	}

}
