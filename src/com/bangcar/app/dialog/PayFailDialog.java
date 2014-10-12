package com.bangcar.app.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bangcar.app.R;

public class PayFailDialog extends Dialog implements
		android.view.View.OnClickListener {

	private Context context;
	private TextView errMsgTv;

	public PayFailDialog(Context context, String reason) {
		super(context, R.style.dialogStyle);
		this.context = context;
		init();
		findViews();
		setEvents();
		if(!TextUtils.isEmpty(reason)){
			errMsgTv.setText(reason);
		}
	}

	private void init() {
		setContentView(R.layout.layout_pay_fail_dialog);
		setCanceledOnTouchOutside(false);
		setCancelable(false);
	}

	private void findViews() {
		errMsgTv = (TextView) findViewById(R.id.errMsgTv);
	}

	private void setEvents() {
		findViewById(R.id.sureTv).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sureTv:
			PayFailDialog.this.cancel();
			break;
		}
	}
}
