package com.bangcar.app.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.framework.ResetLoginPwdFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.user.ResetLoginPwdResp;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

public class FindPasswordResetActivity extends BaseActivity {


	private EditText passEt, surePassEt;
	//private InputMethodManager imm = null;
	private String passwordFirst;
	private String passwordSecond;
	private String phone;
	private String authCode;
	// private TextView showPassCheck = null;
	// private TextView showsurePassCheck = null;
	//private boolean agreeProtocol = true;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.next:
			//String passwordFirst = passEt.getText().toString().trim();
			//String passwordSecond = surePassEt.getText().toString().trim();
			passwordFirst = passwordFirst.trim();
			passwordSecond = passwordSecond.trim();
			if (passwordFirst.length() < 6 || passwordFirst.length() > 20) {
				showToast("请按照要求设置密码");
				break;
			}

			if (Global.validatePass(passwordFirst) == false) {
				showToast("请按照要求设置密码");
				break;
			}

			if (passwordSecond.equals(passwordFirst) == false) {
				showToast("两次密码不一致");
				break;
			}

			/*if (agreeProtocol == false) {
				showToast("请阅读并同意《员工宝网站服务协议》");
				break;
			}*/

			Intent intent = getIntent();
			phone = intent.getStringExtra("phone");
			authCode = intent.getStringExtra("authCode");
			showProgressDialog("正在创建密码");
			new ResetLoginPwdFramework(FindPasswordResetActivity.this, authCode, phone, passwordFirst);
			
			break;
		case R.id.cancel:
			onBackPressed();
			break;
		/*case R.id.box_icon:
			ImageView icon = (ImageView) v;
			agreeProtocol = !agreeProtocol;
			if (agreeProtocol == true) {
				icon.setImageResource(R.drawable.icon_agree);
			} else {
				icon.setImageResource(R.drawable.icon_not_agree);
			}
			break;*/
		case R.id.protocolText:
			break;
			
		case R.id.deleteImgPass:
			passEt.setText("");
			break;
			
		case R.id.deleteImgSurePass:
			surePassEt.setText("");
			break;
		}
	}

	@Override
	protected void setLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_find_password_reset);
		//imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

	}

	@Override
	protected void findViews() {
		// TODO Auto-generated method stub
		passEt = (EditText) findViewById(R.id.passEt);// user passwords
		surePassEt = (EditText) findViewById(R.id.surePassEt);// double check
		/*
		 * showPassCheck = (TextView) RegisterPasswordActivity.this
		 * .findViewById(R.id.showPassCheck); showsurePassCheck = (TextView)
		 * RegisterPasswordActivity.this .findViewById(R.id.showsurePassCheck);
		 */
	}

	@Override
	protected void setEvents() {
		// TODO Auto-generated method stub
		findViewById(R.id.next).setOnClickListener(this);
		findViewById(R.id.cancel).setOnClickListener(this);
		findViewById(R.id.deleteImgPass).setOnClickListener(this);
		findViewById(R.id.deleteImgSurePass).setOnClickListener(this);
		
		passEt.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i,
					int i2, int i3) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i2,
					int i3) {
				
				passwordFirst = charSequence.toString();
				if (passwordFirst.length() > 0) {
					findViewById(R.id.deleteImgPass).setVisibility(View.VISIBLE);
				}else {
					findViewById(R.id.deleteImgPass).setVisibility(View.GONE);
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {
			}
		});
		
		surePassEt.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i,
					int i2, int i3) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i2,
					int i3) {
				
				passwordSecond = charSequence.toString();
				if (passwordSecond.length() > 0) {
					findViewById(R.id.deleteImgSurePass).setVisibility(View.VISIBLE);
				}else {
					findViewById(R.id.deleteImgSurePass).setVisibility(View.GONE);
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {
			}
		});

		/*
		 * passEt.setOnFocusChangeListener(new OnFocusChangeListener() {
		 * 
		 * @Override public void onFocusChange(View v, boolean hasFocus) { //
		 * TODO Auto-generated method stub
		 * 
		 * if (!hasFocus) {
		 * 
		 * passwordFirst = passEt.getText().toString();
		 * 
		 * if (StringUtil.isPasswordStandard(passwordFirst)) {
		 * showPassCheck.setText(""); } else { showPassCheck.setText("密码不规范"); }
		 * if (passwordFirst.trim().length() == 0) {
		 * showPassCheck.setVisibility(View.GONE); } else {
		 * showPassCheck.setVisibility(View.VISIBLE); }
		 * 
		 * } else { showPassCheck.setVisibility(View.GONE); }
		 * 
		 * } });
		 */

		/*
		 * surePassEt.setOnFocusChangeListener(new OnFocusChangeListener() {
		 * 
		 * @Override public void onFocusChange(View v, boolean hasFocus) { //
		 * TODO Auto-generated method stub if (!hasFocus) { passwordSecond =
		 * surePassEt.getText().toString();
		 * 
		 * if (passwordSecond.equals(passwordFirst)) {
		 * showsurePassCheck.setText(""); } else {
		 * showsurePassCheck.setText(" 密码不一致"); } if
		 * (passwordSecond.trim().length() == 0) {
		 * showsurePassCheck.setVisibility(View.GONE); } else {
		 * showsurePassCheck.setVisibility(View.VISIBLE); } } } });
		 */
	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub

	}

	public void resetLoginPwdCallback(Object data, int status) {
		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			ResetLoginPwdResp resp = (ResetLoginPwdResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			startActivity(new Intent(baseAct, CreateGesturePasswordActivity.class));
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
		startActivity(new Intent(baseAct, LoginActivity.class));
		this.finish();
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("找回密码填写新密码页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("找回密码填写新密码页");
	    MobclickAgent.onPause(this);
    }
}
