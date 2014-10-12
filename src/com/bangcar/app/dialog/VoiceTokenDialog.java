package com.bangcar.app.dialog;

import android.view.View;

import com.bangcar.app.R;
import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.FindPasswordVerifyActivity;
import com.bangcar.app.activity.RegisterTelphoneActivity;

public class VoiceTokenDialog extends BaseDialog {
	private BaseActivity act = null;
	
	public VoiceTokenDialog(BaseActivity act){
		super(act);
		setContentView(R.layout.layout_dialog_voice_token);
		setEvents();
		this.act = act;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.cancelButton:
			VoiceTokenDialog.this.cancel();
			break;
		case R.id.okButton:
			VoiceTokenDialog.this.cancel();
			if (act instanceof RegisterTelphoneActivity){
				((RegisterTelphoneActivity)act).sendVoiceToken();
			}else if (act instanceof FindPasswordVerifyActivity){
				((FindPasswordVerifyActivity)act).sendVoiceToken();
			}
			
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
