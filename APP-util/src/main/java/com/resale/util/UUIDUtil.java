package com.resale.util;

import java.util.UUID;

/**
 * 
 *
 * Description:
 *
 * @author ouyangjin
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-7-5      ouyangjin       1.0         1.0 Version 
 * </pre>
 */
public class UUIDUtil {
	
	/**
	 * 获得32位去 - 字符
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
}
