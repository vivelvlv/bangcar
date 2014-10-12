package com.bangcar.app.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.bangcar.app.R;

public class ServiceTelDialog extends BaseDialog {
	
	public ServiceTelDialog(Context context){
		super(context);
		setContentView(R.layout.layout_dialog_service_tel);
		setEvents();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.cancelButton:
			cancel();
			break;
		case R.id.telButton:
			Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:4008-955-935"));  
            context.startActivity(intent);
			cancel();
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
		findViewById(R.id.telButton).setOnClickListener(this);
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
