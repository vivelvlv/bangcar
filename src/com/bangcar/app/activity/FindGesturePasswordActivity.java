package com.bangcar.app.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.framework.CaptchaFindGestureFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.user.CaptchaResp;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

public class FindGesturePasswordActivity extends BaseActivity {

	private TextView accountTv;
	private EditText pwdEt;
	private TextView titleTv;

//	private DBUtils dbUtils;

	private String phoneNumber;
	private RelativeLayout veryftLayout;
	private EditText verifyEt;
	private ImageView verifyImg;
	private int captchahash2;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_find_gesture_pwd);
	}

	@Override
	protected void findViews() {
		accountTv = (TextView) findViewById(R.id.accountTv);
		pwdEt = (EditText) findViewById(R.id.pwdEt);
		titleTv = (TextView) findViewById(R.id.titleTv);
		titleTv.setText(R.string.find_gesture_pass);
		veryftLayout = (RelativeLayout) findViewById(R.id.veryftLayout);
		verifyEt = (EditText) findViewById(R.id.verifyEt);
		verifyImg = (ImageView) findViewById(R.id.verifyImg);
	}

	@Override
	protected void setEvents() {
		findViewById(R.id.forgetPwdTv).setOnClickListener(this);
		findViewById(R.id.nextButton).setOnClickListener(this);
		verifyImg.setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
//		dbUtils = DBUtils.getInstance(this, DBConsts.DB_NAME,
//				DBConsts.DB_VESION);
//		List<String> userInfo = dbUtils.Db_getUserInfo();
//		phoneNumber = userInfo.get(0);
//		if (userInfo != null) {
//			String str = phoneNumber.substring(0, 3);
//			str += "****";
//			str += phoneNumber.substring(7);
//			accountTv.setText(str);
//		}

	}

	public void updateCaptcha() {
		new CaptchaFindGestureFramework(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.forgetPwdTv:
			// startActivity(new Intent(baseAct, FindPassActivity.class));
			// baseAct.finish();
			break;
		case R.id.nextButton:
			// new findGesturePasswordFramework(this, phoneNumber,
			// pwdEt.getText().toString(), "");
			break;
		case R.id.verifyImg:
			updateCaptcha();
			break;
		}
	}

	public void LoginCallback(Object data, int status) {
		switch (status) {
		case Global.DATA_OK:
			startActivity(new Intent(baseAct,
					CreateGesturePasswordActivity.class));
			baseAct.finish();
			break;
		case Global.DATA_LOGICEXCEPTION:
			showToast(((MApiException) data).getRetMsg());
			veryftLayout.setVisibility(View.VISIBLE);
			updateCaptcha();
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			break;
		}
	}

	public void captchaCallback(Object data, int status) {
		// 获得图形验证码
		switch (status) {
		case Global.DATA_OK:
			CaptchaResp resp = (CaptchaResp) data;
            //ConfigUtil.saveSkey(resp.head.skey);
			YGBApp.getLoader().displayImage(resp.img, verifyImg);
			captchahash2 = resp.getHash2();
			break;
		case Global.DATA_LOGICEXCEPTION:
            MApiException e = (MApiException)data;
            //ConfigUtil.saveSkey(e.head.skey);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			break;
		}
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("找回手势密码页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("找回手势密码页");
	    MobclickAgent.onPause(this);
    }

}
