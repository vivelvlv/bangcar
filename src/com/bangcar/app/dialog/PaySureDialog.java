package com.bangcar.app.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.activity.PaySuccessActivity;
import com.bangcar.app.framework.PayResultRequestFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.pay.ResultReq;
import com.bangcar.app.mapi.pay.ResultResp;
import com.bangcar.app.util.Global;

public class PaySureDialog extends BaseDialog {

	private TextView descTv;
	private int second = 10;
	private String orderId;
	private long amount;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			descTv.setText("支付结果已提交，请等待" + second + "秒");
			if (second <= 0) {
				descTv.setText("支付结果确认中...");
				ResultReq resultReq = new ResultReq();
				resultReq.head = Global.getReqHead();
				resultReq.orderId = orderId;
				new PayResultRequestFramework((Activity)context,PaySureDialog.this, resultReq);
			}
		};
	};

	public PaySureDialog(Context context, int waiteSecond, String orderId,long totalPriceE6) {
		super(context);
		this.context = context;
		this.orderId = orderId;
		this.amount = totalPriceE6;
		init();
		findViews();
		setEvents();
		this.second = waiteSecond;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (second > 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					second--;
					handler.obtainMessage().sendToTarget();
				}
			}
		}).start();
	}

	private void init() {
		setContentView(R.layout.layout_pay_sure_dialog);
		setCanceledOnTouchOutside(false);
		setCancelable(false);
	}

	@Override
	protected void findViews() {
		descTv = (TextView) findViewById(R.id.descTv);
	}

	@Override
	protected void setEvents() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void responseData(Object data, int status) {
		PaySureDialog.this.cancel();
		switch (status) {
		case Global.DATA_OK:
			ResultResp resp = (ResultResp) data;
            //ConfigUtil.saveSkey(resp.head.skey);
			switch (resp.payState) {
			case PROCESSING:
				// 支付处理中: 已发起,还无结果
				new PayResultSureDialog(context).show();
				break;
			case PAID:
				// 成功
				Intent intent = new Intent(context,PaySuccessActivity.class);
				intent.putExtra("result", resp);
				intent.putExtra("amount", amount);
				context.startActivity(intent);
				break;
			case FAIL:
				// 失败
				new PayFailDialog(context, resp.failReason).show();
				break;
			default:

				break;
			}
			// new PaySureDialog(context,resp).show();
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
            //ConfigUtil.saveSkey(e.head.skey);
			showToast(e.getRetMsg());
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	@Override
	public void onClick(View v) {
	}
}
