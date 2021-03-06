package com.bangcar.app;

import java.io.File;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.baidu.mapapi.SDKInitializer;
import com.bangcar.app.util.Global;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.analytics.MobclickAgent;

public class YGBApp extends Application {

	private static Resources res = null;
	public static Context context = null;
	private static SharedPreferences userSp = null;
	private static YGBApp mInstance = null;
	private static String deviceId, versionName;
	private static SharedPreferences configSp = null;
	private static ImageLoader loader = null;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context = getApplicationContext();
		mInstance = this;
		//uemg统计，开发者模式
		MobclickAgent.setDebugMode(true);
		// 禁止默认的页面统计方式
		MobclickAgent.openActivityDurationTrack(false);
		//Jpush init
		JPushInterface.setDebugMode(false); // 设置开启日志,发布时请关闭日志
		JPushInterface.init(this); // 初始化 JPush
        //baidu map
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(this);
	}

	/**
	 * 获取图片加载实例
	 * 
	 * @return
	 */
	public static ImageLoader getLoader() {
		if (context == null) {
			return null;
		}
		if (loader == null) {
			loader = ImageLoader.getInstance();
			File cacheFile = new File(Global.IMAGE_PATH);

			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
					context)
					.diskCache(
							new LruDiscCache(cacheFile,
									new HashCodeFileNameGenerator(),
									100 * 1024 * 1024))
					.memoryCache(new WeakMemoryCache())
					.denyCacheImageMultipleSizesInMemory().build();
			loader.init(config);
		}
		return loader;
	}

	/**
	 * 展示app toast，不依赖于activity的生命周期
	 * 
	 * @param msg
	 */
	public void showSystemCenterToast(String msg) {
		Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		toast.setText(msg);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	public void showSystemCenterToast(int id) {
		showSystemCenterToast(getRes().getString(id));
	}

	/**
	 * 获取Resource
	 * 
	 * @return
	 */
	public static Resources getRes() {
		if (res == null) {
			res = context.getResources();
		}
		return res;
	}

	public static String getDeviceId() {
		if (TextUtils.isEmpty(deviceId)) {
			TelephonyManager tm = (TelephonyManager) context
					.getSystemService(TELEPHONY_SERVICE);
			deviceId = tm.getDeviceId();
		}
		return deviceId;
	}

	/**
	 * 获得字体
	 * 
	 * @param typeName
	 * @return
	 */
	public static Typeface getFontType(String typeName) {
		return Typeface.createFromAsset(context.getAssets(), "fonts/"
				+ typeName);
	}

	/**
	 * 获取版本名称
	 * 
	 * @return
	 */
	public static String getVersionName() {
		if (TextUtils.isEmpty(versionName)) {
			PackageManager pm = context.getPackageManager();
			try {
				PackageInfo info = pm.getPackageInfo(context.getPackageName(),
						0);
				versionName = info.versionName;
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return versionName;
	}

	/**
	 * 用户缓存信息
	 * 
	 * @return
	 */
	public static SharedPreferences getUserSp() {
		if (userSp == null) {
			userSp = context.getSharedPreferences("user", 0);
		}
		return userSp;
	}

	/**
	 * 配置缓存信息
	 * 
	 * @return
	 */
	public static SharedPreferences getConfigSp() {
		if (configSp == null) {
			configSp = context.getSharedPreferences("config", 0);
		}
		return configSp;
	}
	
	public static YGBApp getInstance() {
		return mInstance;
	}
}
