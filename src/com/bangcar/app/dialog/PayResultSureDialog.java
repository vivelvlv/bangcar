package com.bangcar.app.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.bangcar.app.R;
import com.bangcar.app.activity.ConfirmInvestingActivity;
import com.bangcar.app.activity.OrderDetailActivity;
import com.bangcar.app.activity.PayActivity;
import com.bangcar.app.activity.TeacherDetailActivity;
import com.bangcar.app.util.Global;

public class PayResultSureDialog extends Dialog implements
		android.view.View.OnClickListener {

	public PayResultSureDialog(Context context) {
		super(context, R.style.dialogStyle);
		init();
		findViews();
		setEvents();
	}

	private void init() {
		setContentView(R.layout.layout_pay_sureing_dialog);
		setCanceledOnTouchOutside(false);
		setCancelable(false);
	}

	private void findViews() {
	}

	private void setEvents() {
		findViewById(R.id.sureTv).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sureTv:
			if (TeacherDetailActivity.productDetailInstance != null) {
				TeacherDetailActivity.productDetailInstance.finish();
			}
			if (OrderDetailActivity.orderDetailInstance != null) {
				OrderDetailActivity.orderDetailInstance.finish();
			}
			if (ConfirmInvestingActivity.confirmInvestInstance != null) {
				ConfirmInvestingActivity.confirmInvestInstance.finish();
			}
			PayResultSureDialog.this.cancel();
			Global.needRefreshInvest = true;
			if (PayActivity.payInstance != null) {
				PayActivity.payInstance.finish();
			}
			break;
		}
	}
}
