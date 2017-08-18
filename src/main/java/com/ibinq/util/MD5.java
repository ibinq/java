package com.ibinq.util;

import java.security.MessageDigest;
/**
 * 
 * @author 
 *
 */
public class MD5 {
	public MD5() {
		
	}
	
	/**
	 * md5加密
	 * @param s
	 * @return
	 */
	public final static String getMd5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	public static void main(String agrs[])
	{
		MD5 md5 = new MD5();
		System.out.println(md5.getMd5("765321"));//066f17c9dcdd24f6177431bcda50b683
		System.out.println(md5.getMd5("sq765321"));//32fffc656653bb14b103df2486c963c6
		System.out.println(md5.getMd5("tmkj#85215716"));//80c657affc5ba77aa2fdf9fae8144ee7
		//System.out.println(UUID.randomUUID());
		//4B401B604B sqos.family
		//24C7D9E5CE sqos.workerapp
	}
	
	

}
