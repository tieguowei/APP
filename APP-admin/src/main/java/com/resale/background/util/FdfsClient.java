package com.resale.background.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
/** 
 * fdfs API封装类 
 * @author Administrator 
 * 
 */  
@Configuration  
public class FdfsClient {
	
protected static final InputStream InputStream = null;
@Autowired  
private FastFileStorageClient storageClient;  
  
		@Value("${fdfs.ip}")
		private String ip;
		  
		/** 
		 * 上传文件  适用于所有文件 
		 * @param file 文件对象 
		 * @return 文件访问地址 
		 * @throws IOException 
		 */  
		public StorePath uploadFile(MultipartFile file) throws IOException{  
		    StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(),   
		            FilenameUtils.getExtension(file.getOriginalFilename()),null);  
		    return storePath;  
		}  
  
	/** 
	 * 将一段字符串生成一个文件上传 
	 * @param content 文件路径 
	 * @param extName 文件扩展名
	 * @return文件访问地址 
	 * @throws FileNotFoundException  
	 */  
	public StorePath uploadFile(String content,String extName) throws FileNotFoundException{  
	    File file = new File(content);  
	    FileInputStream inputStream=new FileInputStream(file);  
	    StorePath storePath = storageClient.uploadFile(inputStream,file.length(),extName,null);  
	    return storePath;  
	}  
  
		/** 
		 * 传图片并同时生成一个缩略图 
		 * "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP" 
		 * @param file 文件对象 
		 * @return 文件访问地址 
		 * @throws IOException 
		 */  
		public StorePath uploadImageAndCrtThumbImage(MultipartFile file) throws IOException{  
		    StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(),file.getSize(),   
		            FilenameUtils.getExtension(file.getOriginalFilename()),null);  
		    return storePath;  
		}  
		  
		  
		/** 
		 * 删除文件 
		 * @param fileUrl 文件访问地址 
		 * @return 
		 * @throws IOException 
		 */  
		public void deleteFile(String storePath){  
		    if (!StringUtils.hasText(storePath)) {  
		        throw new NullPointerException();  
		    }  
		    storageClient.deleteFile(storePath);  
		} 
		
		/**
		 * 下载文件
		 * @param response 
		 * @param filePath 文件路径
		 *  @param fileName 设置文件名
		 */ 
		public void downLoadFile(String filePath, HttpServletResponse response,String fileName){
		    try {
				URL url = new URL(filePath);
				URLConnection conn = url.openConnection();
				InputStream inStream = conn.getInputStream();
				byte[] buffer = new byte[inStream.available()];
				inStream.read(buffer);
				inStream.close();
				// 清空response
				response.reset();
				// 设置response的Header
				response.addHeader("content-disposition","attachment;filename*=UTF-8''" + URLEncoder.encode(fileName+".xls", "UTF-8")); 
				OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");
				toClient.write(buffer);
				toClient.flush();
				toClient.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		}  
		
		
		// 封装文件完整URL地址
	   public String getResAccessUrl(StorePath storePath) {
	       String fileUrl = "http://"+ip + "/" + storePath.getFullPath();
	       return fileUrl;
	   }
}  