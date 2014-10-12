package com.bangcar.app.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.dialog.VerifyEmailDialog;
import com.bangcar.app.framework.ProfileFramework;
import com.bangcar.app.framework.SendVerifyEmailFramework;
import com.bangcar.app.framework.WelcomeBindDeviceFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.notify.BindDeviceTokenReq;
import com.bangcar.app.mapi.profile.ProfileResp;
import com.bangcar.app.mapi.utility.EEmailTokenOp;
import com.bangcar.app.mapi.utility.EmailTokenResp;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

public class RegisterCompleteActivity extends BaseActivity {

	// private InputMethodManager imm = null;
	private String email = "";
	private int delay = 0;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.changeEmail:
			startActivity(new Intent(baseAct, RegisterEmailActivity.class));
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_right);
			this.finish();
			break;
		case R.id.completeButton:
			new ProfileFramework(this);
			break;
		case R.id.sendAgain:
			//new SendVerifyEmailFramework(this, "", EEmailTokenOp.RESEND);
			new VerifyEmailDialog(RegisterCompleteActivity.this).show();
			break;
		}

	}

	@Override
	protected void setLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_register_complete);
		email = getIntent().getStringExtra("email");
		((TextView)findViewById(R.id.verifyText2)).setText(email);
		delay = getIntent().getIntExtra("delay", 0);
		// imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
	}

	@Override
	protected void findViews() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setEvents() {
		// TODO Auto-generated method stub
		findViewById(R.id.changeEmail).setOnClickListener(this);
		findViewById(R.id.sendAgain).setOnClickListener(this);
		findViewById(R.id.completeButton).setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub
		
	}

	public void resendEmailTokenCallback(Object data, int status) {

		cancelDialog();

		switch (status) {
		case Global.DATA_OK:
			EmailTokenResp resp = (EmailTokenResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			delay = resp.getDelay();
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			//ConfigUtil.saveSkey(e.head.skey);
			Toast.makeText(this, e.retMsg, Toast.LENGTH_SHORT).show();
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}

	}

	public void profileCallback(Object data, int status) {
		switch (status) {
		case Global.DATA_OK:
			ProfileResp resp = (ProfileResp) data;
			ConfigUtil.saveUser(resp.getUser());
			//ConfigUtil.saveSkey(resp.head.skey);
			if (resp.getUser().emailVerified == 1) {
				startActivity(new Intent(baseAct, CreateGesturePasswordActivity.class));
				finish();
				BindDeviceTokenReq bindReq = new BindDeviceTokenReq();
				bindReq.head = Global.getReqHead();
				bindReq.deviceToken = YGBApp.getConfigSp().getString("registerId", "");
				new WelcomeBindDeviceFramework(RegisterCompleteActivity.this, bindReq);
			} else {
				showToast("请先完成邮箱验证");
			}
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			//ConfigUtil.saveSkey(e.head.skey);
			Toast.makeText(this, e.retMsg, Toast.LENGTH_SHORT).show();
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}
	
	public void resendEmailToken(){
		new SendVerifyEmailFramework(this, "", EEmailTokenOp.RESEND);
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("注册完成页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("注册完成页");
	    MobclickAgent.onPause(this);
    }
}
