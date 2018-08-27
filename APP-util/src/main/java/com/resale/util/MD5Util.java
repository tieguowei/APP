package com.resale.util;

import java.security.MessageDigest;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
	
	private static final String encryModel="MD5";
	
	
	/**
     * 32位md5.
     * @param str
     * @return
     */
    public  static String md5(String str) {
        return encrypt(encryModel, str);
    }

    //得到加密后的字符
    public static String encrypt(String algorithm, String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] bytes = md.digest();
            for (int i = 0; i < bytes.length; i++) {
                int b = bytes[i] & 0xFF;
                if (b < 0x10) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
    
  public static void main(String[] args) {
      String newPs = new SimpleHash("MD5", "123456", "admin2"+"3e9ecadc600e420e9385ad142caa75fb", 2).toHex();
      System.out.println(newPs);
}
}
