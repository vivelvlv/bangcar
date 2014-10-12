package com.bangcar.app.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.framework.GetAgreeHtmlFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.utility.AgreeHtmlResp;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by 9020MT on 2014/9/17.
 */
public class ProtocolHtmlActivity extends BaseActivity {
	private TextView titleTv;
	private int id;
	private WebView webView;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_html);
	}

	@Override
	protected void findViews() {
		titleTv = (TextView) findViewById(R.id.titleTv);
		webView = (WebView) findViewById(R.id.webView);
	}

	@Override
	protected void setEvents() {
		findViewById(R.id.backImg).setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
		Intent intent = getIntent();
		String title = intent.getStringExtra("title");
		titleTv.setText(title);
		id = intent.getIntExtra("id", -1);
		new GetAgreeHtmlFramework(ProtocolHtmlActivity.this, id);
		showProgressDialog("加载中...");
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.backImg:
			finish();
			break;
		}
	}

	public void agreeHtmlCallback(Object data, int status) {
		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			AgreeHtmlResp resp = (AgreeHtmlResp) data;
			// ConfigUtil.saveSkey(resp.head.skey);
			webView.loadDataWithBaseURL(null, resp.html, "text/html", "utf-8",
					null);
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			// ConfigUtil.saveSkey(e.head.skey);
			Toast.makeText(this, e.retMsg, Toast.LENGTH_SHORT).show();
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		JPushInterface.onResume(this);
		MobclickAgent.onPageStart("协议页");
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		JPushInterface.onPause(this);
		MobclickAgent.onPageEnd("协议页");
		MobclickAgent.onPause(this);
	}
}
