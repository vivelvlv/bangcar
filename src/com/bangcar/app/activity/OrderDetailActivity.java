package com.bangcar.app.activity;

import java.io.File;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.framework.OrderDetailReqFramework;
import com.bangcar.app.framework.PdfDownloadReqFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.common.Agree;
import com.bangcar.app.mapi.common.EPayState;
import com.bangcar.app.mapi.common.KV;
import com.bangcar.app.mapi.order.OrderDetailReq;
import com.bangcar.app.mapi.order.OrderDetailResp;
import com.bangcar.app.mapi.utility.AgreePdfReq;
import com.bangcar.app.mapi.utility.AgreePdfResp;
import com.bangcar.app.util.FileUtil;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.ViewHolder;
import com.umeng.analytics.MobclickAgent;

/**
 * 订单详情
 * 
 * @author andy
 * 
 */
public class OrderDetailActivity extends BaseActivity {

	private TextView titleTv, productNameTv;
	private Button goButton;
	private ScrollView allLayout;
	private ProgressBar loadingBar = null;
	private LinearLayout orderInfoLayout, investorInfoLayout;
	private String orderId = null;
	private OrderDetailResp resp = null;
	private boolean isGoPay = false; // 标识去按钮是否是去支付
	public static OrderDetailActivity orderDetailInstance;
	private LinearLayout remainLayout = null;
	private TextView minuteTv, secondTv;
	private RemainCount remainCount;
	private PopupWindow popWindow = null;
	private View popView = null;
	private LinearLayout pdfLayout;
	private RelativeLayout mlayout = null;
	private String currentPdfName = "协议";
	private ImageView agreeImg = null;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_order_detail);
		orderDetailInstance = this;
		orderId = getIntent().getStringExtra("orderId");
	}

	@Override
	protected void findViews() {
		titleTv = (TextView) findViewById(R.id.titleTv);
		titleTv.setText(R.string.order_detail);
		productNameTv = (TextView) findViewById(R.id.productNameTv);
		goButton = (Button) findViewById(R.id.goButton);
		allLayout = (ScrollView) findViewById(R.id.allLayout);
		loadingBar = (ProgressBar) findViewById(R.id.loadingBar);
		orderInfoLayout = (LinearLayout) findViewById(R.id.orderInfoLayout);
		investorInfoLayout = (LinearLayout) findViewById(R.id.investorInfoLayout);
		allLayout.setVisibility(View.GONE);
		remainLayout = (LinearLayout) findViewById(R.id.remainLayout);
		minuteTv = (TextView) findViewById(R.id.minuteTv);
		secondTv = (TextView) findViewById(R.id.secondTv);
		mlayout = (RelativeLayout) findViewById(R.id.mlayout);
		agreeImg = (ImageView) findViewById(R.id.agreeImg);
	}

	@Override
	protected void setEvents() {
		goButton.setOnClickListener(this);
		findViewById(R.id.backImg).setOnClickListener(this);
		agreeImg.setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
		OrderDetailReq req = new OrderDetailReq();
		req.head = Global.getReqHead();
		req.orderId = orderId;
		new OrderDetailReqFramework(OrderDetailActivity.this).execute(req);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.backImg:
			baseAct.finish();
			break;
		case R.id.goButton:
			Intent intent = new Intent();
			if (isGoPay) {
				// 支付
				intent.setClass(baseAct, PayActivity.class);
				intent.putExtra("orderId", orderId);
			} else {
				// 产品详情
				intent.setClass(baseAct, TeacherDetailActivity.class);
				intent.putExtra("pid", resp.pid);
			}
			startActivity(intent);
			break;
		case R.id.agreeImg:
			//
			popWindow.setAnimationStyle(R.style.AnimBottom);
			popWindow.setContentView(popView);
			popWindow.showAtLocation(mlayout, Gravity.BOTTOM
					| Gravity.CENTER_HORIZONTAL, 0, 0);
			break;
		}
	}

	public void responseData(Object data, int status) {
		allLayout.setVisibility(View.VISIBLE);
		loadingBar.setVisibility(View.GONE);
		switch (status) {
		case Global.DATA_OK:
			resp = (OrderDetailResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			productNameTv.setText(resp.productName);
			initView();
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	private void initView() {
		if(resp.agreeItems == null || resp.agreeItems.size() <= 0){
			agreeImg.setVisibility(View.GONE);
		}else{
			agreeImg.setVisibility(View.VISIBLE);
		}
		if (resp.pid != 0) {
			goButton.setVisibility(View.VISIBLE);
		} else {
			goButton.setVisibility(View.GONE);
		}
		if (resp.payState == EPayState.UNPAID) {
			// 未支付
			isGoPay = true;
			goButton.setText("去支付");
			remainLayout.setVisibility(View.VISIBLE);
			remainCount = new RemainCount(resp.remainSeconds * 1000, 1000);
			remainCount.start();
		} else {
			// 已支付
			isGoPay = false;
			goButton.setText("产品详情");
			remainLayout.setVisibility(View.GONE);
		}
		LayoutInflater inflater = LayoutInflater.from(baseAct);
		for (int i = 0; i < resp.orderItems.size(); i++) {
			KV item = resp.orderItems.get(i);
			View view = inflater.inflate(R.layout.layout_order_info_item, null);
			TextView infoKeyTv = ViewHolder.get(view, R.id.infoKeyTv);
			TextView infoValueTv = ViewHolder.get(view, R.id.infoValueTv);
			infoKeyTv.setText(item.k);
			infoValueTv.setText(item.v);
			orderInfoLayout.addView(view);
		}

		for (int i = 0; i < resp.investItems.size(); i++) {
			KV item = resp.investItems.get(i);
			View view = inflater.inflate(R.layout.layout_order_info_item, null);
			TextView infoKeyTv = ViewHolder.get(view, R.id.infoKeyTv);
			TextView infoValueTv = ViewHolder.get(view, R.id.infoValueTv);
			infoKeyTv.setText(item.k);
			infoValueTv.setText(item.v);
			investorInfoLayout.addView(view);
		}

		// init pop
		popView = inflater.inflate(R.layout.layout_pdf_pop, null);
		popWindow = new PopupWindow(baseAct);
		popWindow.setContentView(popView);
		popWindow.setWidth(LayoutParams.MATCH_PARENT);
		popWindow.setHeight(LayoutParams.MATCH_PARENT);
		popWindow.setFocusable(true);
		popWindow.setBackgroundDrawable(new ColorDrawable(0x50000000));
		popWindow.setOutsideTouchable(true);
		pdfLayout = ViewHolder.get(popView, R.id.pdfLayout);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.bottomMargin = 20;
		if(resp != null && resp.agreeItems != null){
			for (int i = 0; i < resp.agreeItems.size(); i++) {
				Button pdfButton = (Button) inflater.inflate(
						R.layout.layout_order_pdf_item, null);
				final Agree agree = resp.agreeItems.get(i);
				pdfButton.setText("《" + agree.subject + "》");
				pdfButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						AgreePdfReq pdfReq = new AgreePdfReq();
						pdfReq.head = Global.getReqHead();
						pdfReq.agreeId = agree.agreeId;
						pdfReq.orderId = orderId;
						new PdfDownloadReqFramework(OrderDetailActivity.this)
								.execute(pdfReq);
						showProgressDialog("正在下载《" + agree.subject + "》到"
								+ Global.CACHE_PATH + "目录中");
						currentPdfName = agree.subject;
					}
				});
				pdfLayout.addView(pdfButton, params);
			}
		}
		
		popView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int height = popView.findViewById(R.id.popBottomLayout)
						.getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						if (popWindow != null && popWindow.isShowing()) {
							popWindow.dismiss();
						}
					}
				}
				return true;
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		orderDetailInstance = null;
		if (remainCount != null) {
			remainCount.cancel();
		}
		if (popWindow != null && popWindow.isShowing()) {
			popWindow.dismiss();
		}
	}

	public void responsePdfData(Object data, int status) {
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
		switch (status) {
		case Global.DATA_OK:
			AgreePdfResp resp = (AgreePdfResp) data;
			saveFile(resp.contentBase64);
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	byte[] bytes = null;

	private void saveFile(String content) {
		try {
			bytes = Base64.decode(content, Base64.DEFAULT);
			new DownloadThread().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class RemainCount extends CountDownTimer {

		public RemainCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onFinish() {
			showToast("订单已过期，请重新购买");
			baseAct.finish();
		}

		@Override
		public void onTick(long millisUntilFinished) {
			int allSecond = (int) (millisUntilFinished / 1000);
			int min = allSecond / 60;
			String minute = "0" + min;
			String second = "0" + (allSecond - min * 60);
			String mStr = minute.substring(minute.length() - 2);
			String secondStr = second.substring(second.length() - 2);
			minuteTv.setText(mStr);
			secondTv.setText(secondStr);
		}

	}

	class DownloadThread extends Thread {

		@Override
		public void run() {
			super.run();
			FileUtil.writeToFile(Global.CACHE_PATH + currentPdfName + ".pdf",
					bytes);
			handler.obtainMessage().sendToTarget();
		}
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (dialog != null && dialog.isShowing()) {
				dialog.cancel();
			}
			showToast("下载完成");
			Uri path = Uri.fromFile(new File(Global.CACHE_PATH + currentPdfName + ".pdf"));
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setDataAndType(path, "application/pdf");
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			try {
				startActivity(intent);
			} catch (Exception e) {
				showToast("没有找到可打开pdf的程序，请下载pdf阅读器");
			}
		};
	};
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("订单详情页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("订单详情页");
	    MobclickAgent.onPause(this);
    }

}
