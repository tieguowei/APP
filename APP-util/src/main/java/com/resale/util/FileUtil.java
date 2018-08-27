package com.resale.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/** 
 *
 * Description: 文件操作工具类
 *
 * @author yaodawei
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-1-7    yaodawei       1.0        1.0 Version 
 * </pre>
 */
public class FileUtil {
	
	
	
private static final Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 读取文件
	 * 
	 * @param filePath:文件路径
	 * @return 字符串
	 * @throws FileAccesserException 
	 * @throws ServiceException
	 */
	public static String readFileByLines(String filePath) throws Exception{
		log.info("filePath:" + filePath);
		if(filePath == null || "".equals(filePath)){
			throw new Exception("参数 filePath为空!");
		}
		File file = new File(filePath);
		
		if(!file.exists() || !file.isFile()){
			throw new Exception(filePath + "不存在,或者不是文件而是目录");
		}
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")); 
			String line = null;  
			while ((line = br.readLine()) != null) {  
			      sb.append(line);
			}
			br.close();
		} catch (Exception e) {
			log.error("文件"+filePath+"加载失败!", e);
		}finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					log.error("", e);
				}
			}
		}
		return sb.toString();
	}

	
	/**
	 * 
	 * Description: 根据路径将文件转换成字节数组
	 *
	 * @param 
	 * @return byte[]
	 * @throws 
	 * @Author yaodawei
	 * Create Date: 2014-1-7 下午05:03:21
	 */
	public static byte[] getBytes(String filePath){   
        byte[] buffer = null;   
        try {
        	if(filePath != null && !"".equals(filePath)){
        		File file = new File(filePath);   
                FileInputStream fis = new FileInputStream(file);   
                ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);   
                byte[] b = new byte[1000];   
                int n;   
                while ((n = fis.read(b)) != -1) {   
                    bos.write(b, 0, n);   
                }   
                fis.close();   
                bos.close();   
                buffer = bos.toByteArray();
        	}
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
        return buffer;   
    } 
	
	/**
	 * 得到文件的扩展名.
	 * @param fileName 需要处理的文件的名字.
	 * @return the extension portion of the file's name.
	 */
	public static String getExtension(String fileName) {
		if (fileName != null) {
			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1) {
				return fileName.substring(i + 1).toLowerCase();
			}
		}
		return "";
	}

	/**
	 * 得到文件的前缀名.
	 * @date 2005-10-18
	 * @param fileName 需要处理的文件的名字.
	 * @return the prefix portion of the file's name.
	 */
	public static String getPrefix(String fileName) {
		if (fileName != null) {
			fileName = fileName.replace('\\', '/');

			if (fileName.lastIndexOf("/") > 0) {
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1,
						fileName.length());
			}

			int i = fileName.lastIndexOf('.');
			if (i > 0 && i < fileName.length() - 1) {
				return fileName.substring(0, i);
			}
		}
		return "";
	}

	/**
	 * 得到文件的短路径, 不包括目录.
	 * @date 2005-10-18
	 * @param fileName 需要处理的文件的名字.
	 * @return the short version of the file's name.
	 */
	public static String getShortFileName(String fileName) {
		if (fileName != null) {
			String oldFileName = new String(fileName);

			fileName = fileName.replace('\\', '/');

			if (fileName.endsWith("/")) {
				int idx = fileName.indexOf('/');
				if (idx == -1 || idx == fileName.length() - 1) {
					return oldFileName;
				} else {
					return oldFileName
							.substring(idx + 1, fileName.length() - 1);
				}

			}
			if (fileName.lastIndexOf("/") > 0) {
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1,
						fileName.length());
			}

			return fileName;
		}
		return "";
	}

	/**
	 * 删除文件
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myDelFile = new File(filePath);
			myDelFile.delete();
			System.out.println("删除文件操作 成功执行");
		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件夹
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (myFilePath.delete()) { // 删除空文件夹
				System.out.println("删除文件夹" + folderPath + "操作 成功执行");
			} else {
				System.out.println("删除文件夹" + folderPath + "操作 执行失败");
			}
		} catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件夹里面的所有文件
	 * @param path 文件夹路径 如 c:/fqf
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
				// delAllFile(path+"/"+ tempList[i]);//先删除文件夹里面的文件
				delFolder(path + File.separatorChar + tempList[i]);// 再删除空文件夹
			}
		}
		System.out.println("删除文件操作 成功执行");
	}

	/**
	 * 复制单个文件
	 * @param oldPath 原文件路径 如：c:/fqf.txt
	 * @param newPath 复制后路径 如：f:/fqf.txt
	 */
	public static void copyFile(String oldPath, String newPath) {
		InputStream inStream = null;
		FileOutputStream fs = null;
		try {
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				// 文件存在时
				inStream = new FileInputStream(oldPath); // 读入原文件
				fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		} finally{
			try {
				if(inStream != null){
					inStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(fs != null){
					fs.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 复制整个文件夹内容
	 * @param oldPath 原文件路径 如：c:/fqf
	 * @param newPath 复制后路径 如：f:/fqf/ff
	 */
	public static void copyFolder(String oldPath, String newPath) {
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					input = new FileInputStream(temp);
					output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
				}
				if (temp.isDirectory()) {
					// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
			System.out.println("复制文件夹操作 成功执行");
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();
		} finally{
			try {
				if(output != null){
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(input != null){
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 移动文件到指定目录
	 *
	 * @param oldPath 如：c:/fqf.txt
	 * @param newPath 如：d:/fqf.txt
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 移动文件夹到指定目录
	 *
	 * @param oldPath 如：c:/fqf.txt
	 * @param newPath 如：d:/fqf.txt
	 */
	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}

	/**
	 * Description: 判断目录是否存在，不存在就创建
	 * 
	 * @param
	 * @return void
	 * @throws
	 * @Author ydw Create Date: 2011-11-16 上午10:28:19
	 */
	public static void existDirectory(String dir) {
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	/**
	 * 生成新的文件名，格式：yyyyMMddHHmmssSSS
	 * @param fileName 原文件名
	 * @return
	 */
	public static String getNewFileName(String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String newName = sdf.format(Calendar.getInstance().getTime());
		String extendName = "";
		if (fileName.lastIndexOf(".") != -1)
			extendName = fileName.substring(fileName.lastIndexOf("."));
		return newName + extendName;
	}
	
	public static void main(String[] args){
		System.out.println(getNewFileName(""));
	}
}
