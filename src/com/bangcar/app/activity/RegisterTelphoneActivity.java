package com.bangcar.app.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.dialog.AccountExistingDialog;
import com.bangcar.app.dialog.VoiceTokenDialog;
import com.bangcar.app.framework.CheckRegisterInfoFramework;
import com.bangcar.app.framework.NewCatchaRequestFramework;
import com.bangcar.app.framework.SendVoiceTokenFramework;
import com.bangcar.app.framework.VerifyMobileTokenFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.user.MobileResp;
import com.bangcar.app.mapi.utility.EMobileTokenType;
import com.bangcar.app.mapi.utility.MobileTokenResp;
import com.bangcar.app.mapi.utility.VerifyRegisterResp;
import com.bangcar.app.mapi.utility.VoiceTokenResp;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.StringUtil;
import com.umeng.analytics.MobclickAgent;

public class RegisterTelphoneActivity extends BaseActivity {

	private EditText mobileEt, verifyEt;
	private Button getCatchaButton = null;
	// private InputMethodManager imm = null;
	private String phoneNumber = "";
	private TextView showPhoneCheck;
	private String regTokenhash;// 注册时，系统回传回来的注册码，hash值
	private int regTokendelay;// 注册时，系统回传回来的注册码重发等待时间
	private String voicePhone, voiceToken;
	private boolean executeTokenCountBoolean = false;
	private TimeCount timecount;
	private String token;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.next:
			if (phoneNumber.length() != 11){
				showToast("请输入正确的手机号码");
				break;
			}
			
			token = verifyEt.getText().toString();
			if (token.length() != 4) {
				showToast("验证码不正确");
				break;
			}

			if (regTokenhash != null) {
				int calcToken = 0;
				calcToken += token.charAt(0);
				calcToken += token.charAt(1);
				calcToken += token.charAt(2);
				calcToken += token.charAt(3);

				if ((calcToken + "").equals(regTokenhash) == false) {
					showToast("验证码不正确");
					break;
				}
			}

			showProgressDialog("校验验证码");
			new VerifyMobileTokenFramework(RegisterTelphoneActivity.this,
					phoneNumber, token);
			break;
		case R.id.cancel:
			onBackPressed();
			break;
		case R.id.getCatchaButton:
			showProgressDialog("正在发送验证码");
			new NewCatchaRequestFramework(RegisterTelphoneActivity.this,
					phoneNumber, EMobileTokenType.REGISTER);
			break;
		case R.id.voiceVerify:
			new VoiceTokenDialog(RegisterTelphoneActivity.this).show();
			break;
		case R.id.deleteImg:
			mobileEt.setText("");
			break;
		}

	}

	@Override
	protected void setLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_register_telphone);
		// imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
	}

	@Override
	protected void findViews() {
		// TODO Auto-generated method stub
		mobileEt = (EditText) findViewById(R.id.mobileEt);// mobile phone
		verifyEt = (EditText) findViewById(R.id.verifyEt);// active number by
		getCatchaButton = (Button) findViewById(R.id.getCatchaButton);
		showPhoneCheck = (TextView) findViewById(R.id.showPhoneCheck);
	}

	@Override
	protected void setEvents() {
		// TODO Auto-generated method stub
		findViewById(R.id.next).setOnClickListener(this);
		findViewById(R.id.cancel).setOnClickListener(this);
		findViewById(R.id.getCatchaButton).setOnClickListener(this);
		findViewById(R.id.voiceVerify).setOnClickListener(this);
		findViewById(R.id.deleteImg).setOnClickListener(this);

		verifyEt.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i,
					int i2, int i3) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i2,
					int i3) {
			}

			@Override
			public void afterTextChanged(Editable editable) {

				if (regTokenhash == null)
					return;

				token = editable.toString();

				int calcToken = 0;
				if (token.length() == 4) {
					// 输入四个数字验证码
					calcToken += token.charAt(0);
					calcToken += token.charAt(1);
					calcToken += token.charAt(2);
					calcToken += token.charAt(3);

					if ((calcToken + "").equals(regTokenhash)) {

						return;
					}
				} else {

				}
				if (token.length() == 0) {

				}
			}
		});

		mobileEt.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i,
					int i2, int i3) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i2,
					int i3) {
				showPhoneCheck.setVisibility(View.GONE);
				getCatchaButton.setEnabled(false);

				phoneNumber = charSequence.toString();
				if (phoneNumber.length() == 11) {
					if (StringUtil.isMobileNO(phoneNumber)) {
						showProgressDialog("检查手机号码");
						new CheckRegisterInfoFramework(
								RegisterTelphoneActivity.this)
								.isRegister(phoneNumber);
					} else {
						showPhoneCheck.setVisibility(View.VISIBLE);
					}
				} else if (phoneNumber.length() > 11) {
					showPhoneCheck.setVisibility(View.VISIBLE);
				}

				if (phoneNumber.length() > 0) {
					findViewById(R.id.deleteImg).setVisibility(View.VISIBLE);
				} else {
					findViewById(R.id.deleteImg).setVisibility(View.GONE);
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {
			}
		});

	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub
		timecount = new TimeCount(60000, 1000);// 构造CountDownTimer对象;

	}

	public void telphoneIsRegistered(Object data, int status) {

		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
            MobileResp resp = (MobileResp)data;
            //ConfigUtil.saveSkey(resp.head.skey);
			new AccountExistingDialog(baseAct).show();
			break;
		case Global.DATA_LOGICEXCEPTION:
            MApiException e = (MApiException)data;
            //ConfigUtil.saveSkey(e.head.skey);
			if (!timecount.getExecuteStatus()) {
				getCatchaButton.setEnabled(true);
			}
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	public void phoneToken(Object data, int status) {
		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			getCatchaButton.setEnabled(false);
			verifyEt.requestFocus(View.FOCUS_LEFT);
			
			MobileTokenResp resp = (MobileTokenResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			regTokenhash = resp.getHash();
			regTokendelay = resp.getDelay();
			voicePhone = resp.getVoiceMobile();
			voiceToken = resp.getVoiceToken();

			if (timecount.getExecuteStatus()) {
				timecount.cancel();
			}
			timecount = new TimeCount(regTokendelay * 1000, 1000);// 构造CountDownTimer对象;
			timecount.start();

			findViewById(R.id.voiceVerifyLayout).setVisibility(View.VISIBLE);
			TextView txt = (TextView) findViewById(R.id.hasSended);
			String phoneHide = phoneNumber.substring(0, 3) + "****"
					+ phoneNumber.substring(7, 11);
			txt.setText("验证码已经发送至" + phoneHide + "的手机");
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

	class TimeCount extends CountDownTimer {

		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		public void onFinish() {// 计时完毕时触发
			getCatchaButton.setText("重新验证");

			if (phoneNumber.length() == 11
					&& StringUtil.isMobileNO(phoneNumber)) {
				getCatchaButton.setEnabled(true);
			} else {
				getCatchaButton.setEnabled(false);
			}
			executeTokenCountBoolean = false;
		}

		public void onTick(long millisUntilFinished) {// 计时过程显示
			getCatchaButton.setText("已发送(" + millisUntilFinished / 1000 + "秒)");
			executeTokenCountBoolean = true;
		}

		public boolean getExecuteStatus() {
			return executeTokenCountBoolean;
		}
	}

	public void verifyMobileTokenCallback(Object data, int status) {

		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			VerifyRegisterResp resp = (VerifyRegisterResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			Intent intent = new Intent(baseAct, RegisterPasswordActivity.class);
			intent.putExtra("phone", phoneNumber);
			intent.putExtra("token", token);
			intent.putExtra("agreeId", resp.agree.agreeId);
			intent.putExtra("agreeSubject", resp.agree.subject);
			startActivity(intent);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);
			this.finish();
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

	public void sendVoiceTokenCallback(Object data, int status) {

		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			VoiceTokenResp resp = (VoiceTokenResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
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

	public void sendVoiceToken() {
		new SendVoiceTokenFramework(RegisterTelphoneActivity.this, voicePhone,
				voiceToken);
	}

	public void onBackPressed() {
		//startActivity(new Intent(baseAct, LoginActivity.class));
		this.finish();
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("注册验证手机号页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("注册验证手机号页");
	    MobclickAgent.onPause(this);
    }

}
