package com.usoft.suntg.algorithm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 文件操作
 * 
 * @author sunyj
 * @since 2017年3月22日 上午9:40:41
 */
public class FileUtils {

	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * 删除文件夹下所有子文件（不含该文件夹本身）
	 * 
	 * @param dir
	 */
	public static void deleteSubFiles(File dir) {
		if (dir == null || !dir.exists() || !dir.isDirectory()) {
			return;
		}
		File[] files = dir.listFiles();
		for (File file : files) {
			delete(file);
		}
	}

	/**
	 * 删除文件（子文件及其本身均删除）
	 * 
	 * @param file
	 */
	public static void delete(File file) {
		if (file == null || !file.exists()) {
			return;
		}
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				delete(f);
			}
		}
		file.delete();
		logger.info("Deleted ..." + file.getPath());
	}

}
