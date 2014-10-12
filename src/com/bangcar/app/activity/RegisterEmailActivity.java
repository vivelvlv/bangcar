package com.bangcar.app.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.dialog.VerifyEmailDialog;
import com.bangcar.app.framework.EmailAvailableFramework;
import com.bangcar.app.framework.SendVerifyEmailFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.user.EmailResp;
import com.bangcar.app.mapi.utility.EEmailTokenOp;
import com.bangcar.app.mapi.utility.EmailTokenResp;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

public class RegisterEmailActivity extends BaseActivity {

	//private InputMethodManager imm = null;
	private EditText emailEt;
	private String emailString="";
	private boolean emailFormat = false;
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.next:
			if (emailFormat == true) {
				showProgressDialog("邮箱验证");
				emailString = emailEt.getText().toString();
				new EmailAvailableFramework(this, emailString);

			} else {
				Toast.makeText(this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.cancel:
			onBackPressed();
			break;
		case R.id.deleteImg:
			emailEt.setText("");
			break;
		}

	}

	@Override
	protected void setLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_register_email);
		//imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

	}

	@Override
	protected void findViews() {
		// TODO Auto-generated method stub
		emailEt = (EditText) findViewById(R.id.emailEt);

	}

	@Override
	protected void setEvents() {
		// TODO Auto-generated method stub
		findViewById(R.id.next).setOnClickListener(this);
		findViewById(R.id.cancel).setOnClickListener(this);
		findViewById(R.id.deleteImg).setOnClickListener(this);

		emailEt.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				emailString = emailEt.getText().toString();
				if (emailString.contains("@")) {
					String mailhead = emailString.substring(0,
							emailString.indexOf("@"));
					String mailtail = emailString.substring(emailString
							.indexOf("@") + 1);

					if (mailhead.length() >= 1
							&& mailtail.contains(".")
							&& mailtail.substring(0, mailtail.indexOf("."))
									.length() >= 1
							&& mailtail.substring(mailtail.indexOf(".") + 1)
									.length() >= 1) {
						emailFormat = true;
					}
				}
				
				if (emailString.length() > 0){
					findViewById(R.id.deleteImg).setVisibility(View.VISIBLE);
				} else {
					findViewById(R.id.deleteImg).setVisibility(View.GONE);
				}
			}
		});
	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub

	}

	// 点击提交注册之后，验证邮箱是否被注册，这里是返回结果回调
	public void emailExistCallback(Object data, int status) {
		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			// 标示邮箱已经被注册
			Toast.makeText(baseAct, "该邮箱已经被注册", Toast.LENGTH_SHORT).show();
			break;
		case Global.DATA_LOGICEXCEPTION:
			// 标示邮箱未被注册

			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	public void emailAvailableCallback(Object data, int status) {
		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			//new SendVerifyEmailFramework(this, emailString, EEmailTokenOp.SEND);
			new VerifyEmailDialog(RegisterEmailActivity.this).show();
            EmailResp resp = (EmailResp)data;
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

	public void sendEmailTokenCallback(Object data, int status) {

		cancelDialog();

		switch (status) {
		case Global.DATA_OK:
			EmailTokenResp resp = (EmailTokenResp)data;
			int delay = resp.getDelay();
			Intent intent = new Intent(baseAct, RegisterCompleteActivity.class);
			intent.putExtra("email", emailString);
			intent.putExtra("delay", delay);
			startActivity(intent);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);
            //ConfigUtil.saveSkey(resp.head.skey);
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
	
	public void onBackPressed() {
		//startActivity(new Intent(baseAct, LoginActivity.class));
		this.finish();
	}
	
	public void sendEmailToken(){
		new SendVerifyEmailFramework(this, emailString, EEmailTokenOp.SEND);
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("绑定邮箱页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("绑定邮箱页");
	    MobclickAgent.onPause(this);
    }
}
