package com.bangcar.app.dialog;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.bangcar.app.R;
import com.bangcar.app.activity.LoginActivity;

public class AccountExistingDialog extends BaseDialog {
	
	public AccountExistingDialog(Context context){
		super(context);
		setContentView(R.layout.layout_dialog_account_existing);
		setEvents();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.cancelButton:
			AccountExistingDialog.this.cancel();
			break;
		case R.id.loginButton:
			context.startActivity(new Intent(context, LoginActivity.class));
			AccountExistingDialog.this.cancel();
			break;
		}
	}

	@Override
	protected void findViews() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setEvents() {
		// TODO Auto-generated method stub
		findViewById(R.id.cancelButton).setOnClickListener(this);
		findViewById(R.id.loginButton).setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void responseData(Object data, int status) {
		// TODO Auto-generated method stub

	}

}
