package com.bangcar.app.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.framework.DataCallback;
import com.bangcar.app.framework.StartUpFramework;
import com.bangcar.app.framework.WelcomeBindDeviceFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.notify.BindDeviceTokenReq;
import com.bangcar.app.mapi.utility.StartUpReq;
import com.bangcar.app.mapi.utility.StartUpResp;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.FileUtil;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/** first welcome activity */
public class WelcomeActivity extends BaseActivity {

	private Bitmap bgMap = null;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_welcome);
		MobclickAgent.updateOnlineConfig(baseAct);
		bgMap = BitmapFactory
				.decodeResource(getResources(), R.drawable.welcome);
		findViewById(R.id.welcomeLayout).setBackground(
				new BitmapDrawable(getResources(), bgMap));
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		ConfigUtil.screenWidth = dm.widthPixels;
		ConfigUtil.screenHeight = dm.heightPixels;
		createDir();
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				 StartUpReq req = new StartUpReq();
				 req.head = Global.getReqHead();
//				 new StartUpFramework(WelcomeActivity.this, req);
                 startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                 WelcomeActivity.this.finish();
			}
		}, 1500);
	}

	@Override
	protected void findViews() {
		// 测试使用RequestFramework请求
//		RequestFramework rf = new RequestFramework("utility");
//		rf.setCallback(new MyCallback());
//		StartUpReq req = new StartUpReq();
//		req.head = Global.getReqHead();
//		rf.exeReq("startUp", req);
	}

	private void createDir() {
		FileUtil.mkdir(Global.FILE_PATH_ROOT);
		FileUtil.mkdir(Global.CACHE_PATH);
		FileUtil.mkdir(Global.DATA_PATH);
		FileUtil.mkdir(Global.IMAGE_PATH);
	}

	@Override
	protected void setEvents() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		JPushInterface.onResume(this);
		MobclickAgent.onPageStart("启动页"); // 统计页面
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		JPushInterface.onPause(this);
		MobclickAgent.onPageEnd("启动页"); // 保证 onPageEnd 在onPause 之前调用,因为 onPause
										// 中会保存信息
		MobclickAgent.onPause(this);
	}

	public void receiveData(Object data, int status) {
		switch (status) {
		case Global.DATA_OK:
			StartUpResp resp = (StartUpResp) data;
			// ConfigUtil.saveSkey(resp.head.skey);
			if (resp.isLogin) {
				// 已登录
				ConfigUtil.saveUser(resp.user);
				startActivity(new Intent(baseAct,
						UnlockGesturePasswordActivity.class));
				BindDeviceTokenReq bindReq = new BindDeviceTokenReq();
				bindReq.head = Global.getReqHead();
				bindReq.deviceToken = YGBApp.getConfigSp().getString(
						"registerId", "");
				new WelcomeBindDeviceFramework(WelcomeActivity.this, bindReq);
			} else {
				startActivity(new Intent(baseAct, LoginActivity.class));
			}
			baseAct.finish();
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			// ConfigUtil.saveSkey(e.head.skey);
			showToast(e.retMsg);
			baseAct.finish();
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			ConfigUtil.clearSkey();// vive: add 9-26
			baseAct.finish();
			break;
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (bgMap != null && !bgMap.isRecycled()) {
			bgMap.recycle();
		}
	}

}
