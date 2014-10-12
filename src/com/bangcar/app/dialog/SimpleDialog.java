package com.bangcar.app.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bangcar.app.R;

public class SimpleDialog extends BaseDialog {
	
	protected TextView title = null;
	
	public SimpleDialog(Context context){
		super(context);
		setContentView(R.layout.layout_dialog_simple);
		findViews();
		setEvents();
		setTitle();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.cancelButton:
			SimpleDialog.this.cancel();
			break;
		case R.id.okButton:
			SimpleDialog.this.cancel();
			onOk();
			break;
		}
	}

	@Override
	protected void findViews() {
		title = (TextView)findViewById(R.id.titleTv);
		title.setText("");
	}

	@Override
	protected void setEvents() {
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
	
	protected void setTitle(){
		
	}
	
	protected void onOk(){
		
	}

}
