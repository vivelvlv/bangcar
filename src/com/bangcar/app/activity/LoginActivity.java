package com.bangcar.app.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.framework.BindDeviceFramework;
import com.bangcar.app.framework.CaptchaFramework;
import com.bangcar.app.framework.SignInFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.notify.BindDeviceTokenReq;
import com.bangcar.app.mapi.user.CaptchaReq;
import com.bangcar.app.mapi.user.CaptchaResp;
import com.bangcar.app.mapi.user.SignInReq;
import com.bangcar.app.mapi.user.SignInResp;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.LockPatternUtils;
import com.umeng.analytics.MobclickAgent;

public class LoginActivity extends BaseActivity {

	private EditText accountEt, passEt, verifyEt;
	private ImageView verifyImg, verifyIcon;
	private String captcha = null;
	private SignInReq signReq = null;
	private boolean isLoginRequest = false;
	private boolean isCaptchaRequest = false;
	private InputMethodManager imm = null;
	private Bitmap map = null;
	public static LoginActivity loginInstance;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_login);
		loginInstance = this;
		imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		signReq = new SignInReq();
		signReq.head = Global.getReqHead();
		JPushInterface.init(baseAct);
	}

	@Override
	protected void findViews() {
		accountEt = (EditText) findViewById(R.id.accountEt);// 手机号
		passEt = (EditText) findViewById(R.id.passEt);// 密码
		verifyEt = (EditText) findViewById(R.id.verifyEt);
		verifyImg = (ImageView) findViewById(R.id.verifyImg);
		verifyIcon = (ImageView) findViewById(R.id.verifyIcon);
	}

	@Override
	protected void setEvents() {
		verifyImg.setOnClickListener(this);
		findViewById(R.id.loginButton).setOnClickListener(this);
		findViewById(R.id.registerTv).setOnClickListener(this);
		findViewById(R.id.forgetPassTv).setOnClickListener(this);

	}

	@Override
	protected void initDatas() {
	}

	/**
	 * 登录接口回调
	 *
	 * @param obj
	 * @param status
	 */
	public void loginCallback(Object obj, int status) {
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}

		isLoginRequest = false;
		switch (status) {
		case Global.DATA_OK:
			SignInResp resp = (SignInResp) obj;
			ConfigUtil.saveUser(resp.user);
			// 登录成功保存skey
			// ConfigUtil.saveSkey(resp.head.skey);
			if (resp.user.mobile.equals(YGBApp.getConfigSp().getString(
					"mobile", ""))) {
				startActivity(new Intent(baseAct, RootActivity.class));
			} else {
				new LockPatternUtils(baseAct).clearLock();
				YGBApp.getConfigSp().edit()
						.putString("mobile", resp.user.mobile).commit();
				startActivity(new Intent(baseAct,
						CreateGesturePasswordActivity.class));
			}
			showToast(R.string.login_success);
			BindDeviceTokenReq bindReq = new BindDeviceTokenReq();
			bindReq.head = Global.getReqHead();
			bindReq.deviceToken = YGBApp.getConfigSp().getString("registerId",
					"");
			new BindDeviceFramework(LoginActivity.this, bindReq);
			baseAct.finish();
			break;
		case Global.DATA_LOGICEXCEPTION:
			// 登录异常，会到这里
			updateCaptcha();
			MApiException e = (MApiException) obj;
			showToast(e.retMsg);
			// 登录成功保存skey
			// ConfigUtil.saveSkey(e.head.skey);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			updateCaptcha();
			showToast(R.string.system_exception);
			break;
		}
	}

	/**
	 * 请求验证码
	 */
	private void updateCaptcha() {
		if (isCaptchaRequest) {
			return;
		}
		verifyEt.setVisibility(View.VISIBLE);
		verifyImg.setVisibility(View.VISIBLE);
		verifyIcon.setVisibility(View.VISIBLE);
		verifyEt.setText("");
		isCaptchaRequest = true;
		CaptchaReq req = new CaptchaReq();
		req.head = Global.getReqHead();
		new CaptchaFramework(LoginActivity.this, req);
	}

	/**
	 * 验证码
	 * 
	 * @param data
	 * @param status
	 */
	public void captchaCallback(Object data, int status) {
		isCaptchaRequest = false;
		switch (status) {
		case Global.DATA_OK:
			CaptchaResp resp = (CaptchaResp) data;
			if (!TextUtils.isEmpty(resp.img)) {
				verifyEt.setVisibility(View.VISIBLE);
				verifyImg.setVisibility(View.VISIBLE);
				verifyIcon.setVisibility(View.VISIBLE);
				verifyEt.setText("");
			}
			// ConfigUtil.saveSkey(resp.head.skey);
			captcha = resp.img;
			byte[] bytes = Base64.decode(captcha, Base64.DEFAULT);
			if (map != null && !map.isRecycled()) {
				map.recycle();
			}

			map = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
			verifyImg.setImageBitmap(map);
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException me = (MApiException) data;
			// ConfigUtil.saveSkey(me.head.skey);
			showToast(me.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginButton:
			// 登录
			hideSoft();
			exeLogin();
			break;

		}
	}

	private void exeLogin() {
		String account = accountEt.getText().toString().trim();
		String pwd = passEt.getText().toString().trim();
		String verify = verifyEt.getText().toString().trim();
		if (TextUtils.isEmpty(account)) {
			showToast(R.string.mobile_empty);
			return;
		}

		if (TextUtils.isEmpty(pwd)) {
			showToast(R.string.pwd_empty);
			return;
		}

        if(account.equals("123456") && pwd.equals("123")){
            startActivity(new Intent(baseAct, RootActivity.class));
            finish();
        }
	}

	/**
	 * 隐藏键盘
	 */
	private void hideSoft() {
		// TODO Auto-generated method stub
		imm.hideSoftInputFromWindow(accountEt.getWindowToken(), 0);
		imm.hideSoftInputFromWindow(passEt.getWindowToken(), 0);
		imm.hideSoftInputFromWindow(verifyEt.getWindowToken(), 0);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		loginInstance = null;
		if (map != null && !map.isRecycled())
			map.recycle();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		JPushInterface.onResume(this);
		MobclickAgent.onPageStart("登录页");
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		JPushInterface.onPause(this);
		MobclickAgent.onPageEnd("登录页");
		MobclickAgent.onPause(this);
	}

}
