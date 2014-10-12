package com.bangcar.app.util;

import java.security.MessageDigest;

/**
 * 该类用于计算字符串或者文件的MD5
 * 
 * @author andy.miao
 * 
 */
public class MD5 {
	public static String toMD5(String str) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
			System.out.println("MD5(" + str + ",32) = " + result);
			System.out.println("MD5(" + str + ",16) = "
					+ buf.toString().substring(8, 24));
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
