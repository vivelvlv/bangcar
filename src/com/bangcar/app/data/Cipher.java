package com.bangcar.app.data;

import android.util.Log;

public class Cipher {

	public static native String encrypt(String spec, byte[] buf);

	public static native byte[] decrypt(String spec, String cipertext);
	
	static {
		try	{
			System.loadLibrary("ygb");
		}
		catch(UnsatisfiedLinkError e){
			Log.e("ygb", "load library failed.message:" + e.getMessage() 
					+ ",localized message:" + e.getLocalizedMessage());
		}
	};
}
