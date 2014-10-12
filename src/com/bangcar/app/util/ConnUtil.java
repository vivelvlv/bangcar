package com.bangcar.app.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class ConnUtil {

	/**
	 * @author andy.miao 
	 * isAccessNetwork
	 * @param context
	 * @return
	 */
	public static boolean isAccessNetwork(Context context) {
		ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connManager.getActiveNetworkInfo() != null
				&& connManager.getActiveNetworkInfo().isAvailable()) {
			return true;
		}
		return false;
	}

	/**
	 * isWifiWork
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isWifiWork(Context context) {
		ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo.State state = connManager.getNetworkInfo(
				ConnectivityManager.TYPE_WIFI).getState();
		if (state == State.CONNECTED || state == State.CONNECTING) {
			return true;
		}
		return false;
	}

	/**
	 * @param context
	 * @return
	 */
	public static boolean isCMWap(Context context) {
		ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mobInfo = connManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		String mobileInfo = mobInfo.getExtraInfo();
		if (mobileInfo != null && mobileInfo.equals("cmwap")) {
			return true;
		}
		return false;
	}
}