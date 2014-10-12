package com.bangcar.app.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;

import com.bangcar.app.mapi.base.MApiReqHead;

public class Global {

	/**
	 * ****** urls *********
	 */
	public static final String PHOTOPROFIX = "?imageView/1/w/100/h/100";
	// 数据callback中的三种状态，分别标识数据正常，逻辑异常和系统异常；
	public static final int DATA_OK = 0;
	public static final int DATA_LOGICEXCEPTION = 1;
	public static final int DATA_SYSTEMEXCEPTION = 2;
	// 反射用的包名
	public static final String THRIFTPATH = "com.bangcar.app.thrift.";
	/**
	 * ********* cache path ***************
	 */
	private static final String FILE_PATH = Environment
			.getExternalStorageDirectory() + File.separator;
	public static final String FILE_PATH_ROOT = FILE_PATH + "ygb/";
	public static final String CACHE_PATH = FILE_PATH_ROOT + "cache/";
	public static final String DATA_PATH = CACHE_PATH + "data/";
	public static final String IMAGE_PATH = CACHE_PATH + "image/";
	// apk路径
	public static final String APK_PATH = FILE_PATH_ROOT + "ygb.apk";
//	private final static String HOST = "https://10.21.200.175:443/";
	public final static String HOST = "https://10.21.200.75:447/";
	public final static String urlEnd = "?clientId=2&clientVer=1.0";
	// 登录
	public static final String USERURL = HOST + "user" + urlEnd;
	public static final String UTILITYURL = HOST + "utility" + urlEnd;
	// 产品
	public static final String PRODUCTURL = HOST + "product" + urlEnd;
	// 购买
	public static final String BUYRUL = HOST + "buy" + urlEnd;
	// 支付
	public static final String PAYURL = HOST + "pay" + urlEnd;
	// 同事说
	public static final String TOPICURL = HOST + "topic" + urlEnd;
	// 我的财富
	public static final String ORDERURL = HOST + "order" + urlEnd;
	public static final String CORPSATUTSURL = HOST + "corp" + urlEnd;
	// 推送
	public static final String NOTIFYURL = HOST + "notify"+urlEnd;
	public static final String PROFILE = HOST + "profile" + urlEnd;
	public static boolean needRefreshInvest = false;		//标识返回之后是否显示到我的投资和需要刷新我的投资列表数据

	/**
	 * 验证密码强度
	 * 
	 * @param pass
	 * @return
	 */
	private static String lowerChar = "[a-z]";// 英文
	private static String upperChar = "[A-Z]";
	private static String digists = "[0-9]";// 数字

	/**
	 * 图片转换为字节数组
	 * 
	 * @param bmp
	 * @param needRecycle
	 * @return
	 */
	public static byte[] bmpToByteArray(final Bitmap bmp,
			final boolean needRecycle) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		bmp.compress(CompressFormat.PNG, 100, output);
		if (needRecycle) {
			bmp.recycle();
		}
		byte[] result = output.toByteArray();
		try {
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 用来判断服务是否后台运行
	 * 
	 * @param context
	 * @return true 在运行 false 不在运行
	 */
	public static boolean isServiceRunning(Context mContext) {
		boolean IsRunning = false;
		ActivityManager activityManager = (ActivityManager) mContext
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> serviceList = activityManager
				.getRunningServices(30);
		if (!(serviceList.size() > 0)) {
			return false;
		}
		for (int i = 0; i < serviceList.size(); i++) {
			if (serviceList.get(i).service.getClassName().equals(
					"com.noahyijie.ygb.service.YuanGongBaoService")) {
				IsRunning = true;
				break;
			}
		}
		return IsRunning;
	}

	public static boolean validatePass(String pass) {
		int lowerNum = 0, upperNum = 0, digistsNum = 0, otherNum = 0;
		for (int i = 0; i < pass.length(); i++) {
			String temp = String.valueOf(pass.charAt(i));
			if (temp.matches(lowerChar)) {
				lowerNum = 1;
			} else if (temp.matches(upperChar)) {
				upperNum = 1;
			} else if (temp.matches(digists)) {
				digistsNum = 1;
			} else {
				otherNum = 1;
			}
			if (lowerNum + upperNum + digistsNum + otherNum >= 2) {
				return true;
			}
		}
		return false;
	}

	public static MApiReqHead getReqHead() {
		MApiReqHead head = new MApiReqHead();
		head.skey = ConfigUtil.getSkey();
		// head.accessToken = "accessToken";
		return head;
	}
}
