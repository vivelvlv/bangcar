package com.bangcar.app.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 
 * @author andy.miao
 * 
 */
public class FileUtil {

	@SuppressWarnings("unused")
	private static final String NO_CACHE_PATH = "/.nomedia";
	private static FileUtil fileUtils = new FileUtil();

	public static FileUtil getInstance() {
		return fileUtils;
	}

	public FileUtil() {
	}

	public static boolean isExistFile(String strFile) {
		File f = new File(strFile);
		return f.exists();
	}

	public static void mkdir(String path) {
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory()) {
			dir.mkdir();
		}
	}

	public static boolean createFile(String path) {
		File f = new File(path);
		try {
			return f.createNewFile();
		} catch (IOException e) {
		}
		return false;
	}

	public static void rename(String oldFilePath, String newFilePath) {
		File file = new File(oldFilePath);
		File newFile = new File(newFilePath);

		file.renameTo(newFile);
		file.delete();
	}

	public static boolean delete(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return file.delete();
		}
		return false;
	}

	/**
	 * 
	 * 
	 * @param path
	 *            String
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);
				delFolder(path + "/" + tempList[i]);
			}
		}
	}

	/**
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath);
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void writeToFile(String filePath, byte[] bytes) {
		 BufferedOutputStream stream = null;
		try {
			File file = new File(filePath);
			if (!file.isFile()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);// openFileOutput(filePath,MODE_PRIVATE);
			stream = new BufferedOutputStream(fos);
			stream.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
		}
	}

	public static long getFileSize(File f) throws Exception {
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getFileSize(flist[i]);
			} else {
				size = size + flist[i].length();
			}
		}
		return size;
	}

	public static String FormetFileSize(String filePath) {
		String fileSizeString = "";
		try {
			File file = new File(filePath);
			if (!file.isFile())
				file.createNewFile();
			long fileS = getFileSize(file);
			DecimalFormat df = new DecimalFormat("#.00");
			if (fileS == 0) {
				fileSizeString = "0M";
			} else if (fileS < 1024) {
				fileSizeString = df.format((double) fileS) + "B";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) + "K";
			} else if (fileS < 1073741824) {
				fileSizeString = df.format((double) fileS / 1048576) + "M";
			} else {
				fileSizeString = df.format((double) fileS / 1073741824) + "G";
			}
		} catch (Exception e) {
		}
		return fileSizeString;
	}
}