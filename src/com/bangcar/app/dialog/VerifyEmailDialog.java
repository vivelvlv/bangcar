package com.bangcar.app.dialog;

import android.view.View;

import com.bangcar.app.R;
import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.RegisterCompleteActivity;
import com.bangcar.app.activity.RegisterEmailActivity;

public class VerifyEmailDialog extends BaseDialog {
	
	private RegisterEmailActivity act1 = null;
	private RegisterCompleteActivity act2 = null;

	public VerifyEmailDialog(BaseActivity act){
		super(act);
		setContentView(R.layout.layout_dialog_verify_email);
		setEvents();
		
		if (act instanceof RegisterEmailActivity == true) {
			this.act1 = (RegisterEmailActivity) act;
		} else if (act instanceof RegisterCompleteActivity == true) {
			this.act2 = (RegisterCompleteActivity) act;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.cancelButton:
			VerifyEmailDialog.this.cancel();
			break;
		case R.id.okButton:
			if (act1 != null) {
				act1.sendEmailToken();
			}

			if (act2 != null) {
				act2.resendEmailToken();
			}
			VerifyEmailDialog.this.cancel();
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
		findViewById(R.id.okButton).setOnClickListener(this);
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
