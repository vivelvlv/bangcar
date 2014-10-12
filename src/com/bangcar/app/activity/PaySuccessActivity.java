package com.bangcar.app.activity;

import java.util.List;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.mapi.common.KV;
import com.bangcar.app.mapi.pay.ResultResp;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.ViewHolder;
import com.umeng.analytics.MobclickAgent;

public class PaySuccessActivity extends BaseActivity {

	/**
	 * 订单信息
	 */
	private List<com.bangcar.app.mapi.common.KV> orderItems;
	/**
	 * 投资人信息
	 */
	private List<com.bangcar.app.mapi.common.KV> investItems;

	private LinearLayout orderInfoLayout, investorInfoLayout;
	private LayoutInflater inflater = null;
	private TextView titleTv,amountTv;
	private ResultResp resp;
	private long amount;

	@SuppressWarnings("unchecked")
	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_pay_success);
		Intent intent = getIntent();
		resp = (ResultResp) intent.getSerializableExtra("result");
		orderItems = resp.orderItems;
		investItems = resp.investItems;
		amount = intent.getLongExtra("amount", 0);
		inflater = LayoutInflater.from(baseAct);
		Global.needRefreshInvest = true;
		if (TeacherDetailActivity.productDetailInstance != null) {
			TeacherDetailActivity.productDetailInstance.finish();
		}
		if (OrderDetailActivity.orderDetailInstance != null) {
			OrderDetailActivity.orderDetailInstance.finish();
		}
		if (ConfirmInvestingActivity.confirmInvestInstance != null) {
			ConfirmInvestingActivity.confirmInvestInstance.finish();
		}
		if (PayActivity.payInstance != null) {
			PayActivity.payInstance.finish();
		}
	}

	@Override
	protected void findViews() {
		titleTv = (TextView)findViewById(R.id.titleTv);
		titleTv.setText(R.string.pay_success);
		amountTv = (TextView)findViewById(R.id.amountTv);
		amountTv.setText((ConfigUtil.formateMoney(amount/1E6)));
		orderInfoLayout = (LinearLayout) findViewById(R.id.orderInfoLayout);
		investorInfoLayout = (LinearLayout) findViewById(R.id.investorInfoLayout);
		for (int i = 0; i < orderItems.size(); i++) {
			KV item = orderItems.get(i);
			View view = inflater.inflate(R.layout.layout_order_info_item, null);
			TextView infoKeyTv = ViewHolder.get(view, R.id.infoKeyTv);
			TextView infoValueTv = ViewHolder.get(view, R.id.infoValueTv);
			infoKeyTv.setText(item.k);
			infoValueTv.setText(item.v);
			orderInfoLayout.addView(view);
		}

		for (int i = 0; i < investItems.size(); i++) {
			KV item = investItems.get(i);
			View view = inflater.inflate(R.layout.layout_order_info_item, null);
			TextView infoKeyTv = ViewHolder.get(view, R.id.infoKeyTv);
			TextView infoValueTv = ViewHolder.get(view, R.id.infoValueTv);
			infoKeyTv.setText(item.k);
			infoValueTv.setText(item.v);
			investorInfoLayout.addView(view);
		}
	}

	@Override
	protected void setEvents() {
		findViewById(R.id.backImg).setOnClickListener(this);
		findViewById(R.id.commitTv).setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.backImg:
			baseAct.finish();
			break;
		case R.id.commitTv:
			baseAct.finish();
			break;
		}
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("支付成功页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("支付成功页");
	    MobclickAgent.onPause(this);
    }

}
