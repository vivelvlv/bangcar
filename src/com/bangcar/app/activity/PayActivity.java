package com.bangcar.app.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.dialog.PaySureDialog;
import com.bangcar.app.framework.MobileTokenReqFramework;
import com.bangcar.app.framework.PayRequestFramework;
import com.bangcar.app.framework.PaySubmitRequestFramework;
import com.bangcar.app.framework.VoiceTokenReqFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.common.Bankcard;
import com.bangcar.app.mapi.pay.PayReq;
import com.bangcar.app.mapi.pay.PayResp;
import com.bangcar.app.mapi.pay.SubmitReq;
import com.bangcar.app.mapi.pay.SubmitResp;
import com.bangcar.app.mapi.utility.EMobileTokenType;
import com.bangcar.app.mapi.utility.MobileTokenReq;
import com.bangcar.app.mapi.utility.MobileTokenResp;
import com.bangcar.app.mapi.utility.VoiceTokenReq;
import com.bangcar.app.mapi.utility.VoiceTokenResp;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

public class PayActivity extends BaseActivity {

	private TextView titleTv, productNameTv, amountTv, bankNameTv,
			bankSuffixTv, payLimitTv, tickTv, xieyiTv;
	private ImageView bankLogo;
	private EditText tradePassEt, verifyEt;
	private Button getCatchaButton, payButton;
	private boolean isSubmitReq = false; // 是否正在提交
	private String orderId;
	private PayResp payResp = null;
	private MobileTokenResp mobileTokenResp = null;
	private VoiceTokenResp voiceTokenResp = null;
	private ImageView agreeImg;
	private boolean isAgree = true; // 是否统一协议
	private RelativeLayout bodyLayout;
	private ProgressBar loadingBar = null;
	private RemainCount remainCount = null;
	private TimeCount timeCount = null;
	private RelativeLayout voiceTokenLayout = null;
	private TextView sendMobileTv = null;
	public static PayActivity payInstance = null;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_pay);
		payInstance = this;
		orderId = getIntent().getStringExtra("orderId");
	}

	@Override
	protected void findViews() {
		titleTv = (TextView) findViewById(R.id.titleTv);
		titleTv.setText(R.string.pay);
		productNameTv = (TextView) findViewById(R.id.productNameTv);
		amountTv = (TextView) findViewById(R.id.amountTv);
		bankNameTv = (TextView) findViewById(R.id.bankNameTv);
		bankSuffixTv = (TextView) findViewById(R.id.bankSuffixTv);
		payLimitTv = (TextView) findViewById(R.id.payLimitTv);
		tickTv = (TextView) findViewById(R.id.tickTv);
		xieyiTv = (TextView) findViewById(R.id.xieyiTv);
		sendMobileTv = (TextView) findViewById(R.id.sendMobileTv);
		bankLogo = (ImageView) findViewById(R.id.bankLogo);
		tradePassEt = (EditText) findViewById(R.id.tradePassEt);
		verifyEt = (EditText) findViewById(R.id.verifyEt);
		getCatchaButton = (Button) findViewById(R.id.getCatchaButton);
		payButton = (Button) findViewById(R.id.payButton);
		agreeImg = (ImageView) findViewById(R.id.agreeImg);
		bodyLayout = (RelativeLayout) findViewById(R.id.bodyLayout);
		bodyLayout.setVisibility(View.GONE);
		loadingBar = (ProgressBar) findViewById(R.id.loadingBar);
		voiceTokenLayout = (RelativeLayout) findViewById(R.id.voiceTokenLayout);
		voiceTokenLayout.setVisibility(View.GONE);
	}

	@Override
	protected void setEvents() {
		findViewById(R.id.backImg).setOnClickListener(this);
		getCatchaButton.setOnClickListener(this);
		payButton.setOnClickListener(this);
		findViewById(R.id.voiceTokenTv).setOnClickListener(this);
		agreeImg.setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
		PayReq req = new PayReq();
		req.head = Global.getReqHead();
		req.orderId = orderId;
		new PayRequestFramework(PayActivity.this).execute(req);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.backImg:
			baseAct.finish();
			break;
		case R.id.getCatchaButton:
			// 获取验证码
			MobileTokenReq req = new MobileTokenReq();
			req.head = Global.getReqHead();
			req.type = EMobileTokenType.TRANSACTION;
			new MobileTokenReqFramework(PayActivity.this).execute(req);
			break;
		case R.id.payButton:
			// 支付
			if (isSubmitReq) {
				return;
			}
			exeSubmit();
			break;
		case R.id.voiceTokenTv:
			// 获取语音验证码
			if (mobileTokenResp == null) {
				showToast("无法获取语音token");
				return;
			}
			VoiceTokenReq vReq = new VoiceTokenReq();
			vReq.head = Global.getReqHead();
			vReq.voiceMobile = mobileTokenResp.voiceMobile;
			vReq.voiceToken = mobileTokenResp.voiceToken;
			new VoiceTokenReqFramework(PayActivity.this).execute(vReq);
			break;
		case R.id.agreeImg:
			isAgree = !isAgree;
			if (isAgree) {
				agreeImg.setImageResource(R.drawable.icon_agree);
			} else {
				agreeImg.setImageResource(R.drawable.icon_not_agree);
			}
			break;
		}
	}

	/**
	 * 支付提交
	 */
	private void exeSubmit() {
		String tradePass = tradePassEt.getText().toString().trim();
		if (TextUtils.isEmpty(tradePass)) {
			showToast("请输入交易密码");
			return;
		}
		String verifyCode = verifyEt.getText().toString().trim();
		if (TextUtils.isEmpty(verifyCode)) {
			showToast("请输入验证码");
			return;
		}
		if (TextUtils.isEmpty(orderId)) {
			showToast("没有生成订单");
			return;
		}
		if(!isAgree){
			showToast("请先勾选同意协议");
			return;
		}
		if (payResp == null) {
			showToast("数据异常");
			return;
		}
		isSubmitReq = true;
		showProgressDialog("正在提交支付...");
		SubmitReq req = new SubmitReq();
		req.head = Global.getReqHead();
		req.bankcardId = payResp.bankcards.get(0).bankcardId;
		req.orderId = orderId;
		req.token = verifyCode;
		req.transPwd = tradePass;
		new PaySubmitRequestFramework(PayActivity.this).execute(req);
	}

	/**
	 * 支付信息获取回调
	 * 
	 * @param data
	 * @param status
	 */
	public void payResponseData(Object data, int status) {
		loadingBar.setVisibility(View.GONE);
		switch (status) {
		case Global.DATA_OK:
			payResp = (PayResp) data;
			//ConfigUtil.saveSkey(payResp.head.skey);
			initViews();
			break;
		case Global.DATA_LOGICEXCEPTION:
			// 登录异常，会到这里
			MApiException e = (MApiException) data;
			//ConfigUtil.saveSkey(e.head.skey);
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	private void initViews() {
		if (payResp == null) {
			return;
		}
		bodyLayout.setVisibility(View.VISIBLE);
		Bankcard bank = payResp.bankcards.get(0);
		bankNameTv.setText(bank.bankName);
		payLimitTv.setText(bank.payLimit / 10000 + "万");
		bankSuffixTv.setText(bank.cardNoSuffix);
		productNameTv.setText(payResp.productName);
		amountTv.setText((ConfigUtil.formateMoney(payResp.totalPriceE6 / 1E6)) + "");
		remainCount = new RemainCount(payResp.remainTime * 1000, 1000);
		remainCount.start();
		StringBuffer sb = new StringBuffer();
		sb.append("我已阅读并同意");
		for (int i = 0; i < payResp.agrees.size(); i++) {
			if (i == payResp.agrees.size() - 1 || payResp.agrees.size() == 1) {
				sb.append("<a style=\"color:#F05141\" href="
						+ payResp.agrees.get(i).agreeId + ">《"
						+ payResp.agrees.get(i).subject + "》</a>");
			} else {
				sb.append("<a style=\"color:#F05141\" href="
						+ payResp.agrees.get(i).agreeId + ">《"
						+ payResp.agrees.get(i).subject + "》、</a>");
			}
		}
		sb.append("所有条款，充分了解并清楚知晓相应权利义务，愿意承担相关风险");
		xieyiTv.setText(Html.fromHtml(sb.toString()));
		xieyiTv.setMovementMethod(LinkMovementMethod.getInstance());
		CharSequence text = xieyiTv.getText();
		if (text instanceof Spannable) {
			int end = text.length();
			Spannable sp = (Spannable) xieyiTv.getText();
			URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
			SpannableStringBuilder style = new SpannableStringBuilder(text);
			style.clearSpans();// should clear old spans

			// 循环把链接发过去
			for (URLSpan url : urls) {
				MyURLSpan myURLSpan = new MyURLSpan(url.getURL());
				style.setSpan(myURLSpan, sp.getSpanStart(url),
						sp.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
			}
			xieyiTv.setText(style);
		}
	}

	class MyURLSpan extends ClickableSpan {

		private String mUrl;

		MyURLSpan(String url) {
			mUrl = url;
		}

		@Override
		public void updateDrawState(TextPaint ds) {
			// TODO Auto-generated method stub
			super.updateDrawState(ds);
			ds.setColor(ds.linkColor);
			ds.setUnderlineText(false); // 去掉下划线
		}

		@Override
		public void onClick(View widget) {
			Intent intent = new Intent(baseAct, ProtocolHtmlActivity.class);
			int id = Integer.parseInt(mUrl);
			intent.putExtra("id", id);
			intent.putExtra("title", getAgreeTitle(id));
			startActivity(intent);
		}
	}

	private String getAgreeTitle(int agreeId) {
		if (payResp == null || payResp.agrees == null
				|| payResp.agrees.size() <= 0) {
			return "";
		}
		for (int i = 0; i < payResp.agrees.size(); i++) {
			if (payResp.agrees.get(i).agreeId == agreeId) {
				return payResp.agrees.get(i).subject;
			}
		}
		return "";
	}

	class RemainCount extends CountDownTimer {

		public RemainCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onFinish() {
			bodyLayout.setVisibility(View.GONE);
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
			tickTv.setText(Html.fromHtml("请在<font color=#F05141>" + mStr
					+ "</font>分<font color=#F05141>" + secondStr
					+ "</font>秒内完成交易"));
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		payInstance = null;
		if (remainCount != null) {
			remainCount.cancel();
		}
		if (timeCount != null) {
			timeCount.cancel();
		}
	}

	/**
	 * 提交支付回调
	 * 
	 * @param data
	 * @param status
	 */
	public void paySubmitResponseData(Object data, int status) {
		isSubmitReq = false;
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
		switch (status) {
		case Global.DATA_OK:
			timeCount.cancel();
			remainCount.cancel();
			SubmitResp resp = (SubmitResp) data;
			new PaySureDialog(baseAct, resp.payWaitSeconds, orderId,
					payResp.totalPriceE6).show();
			//ConfigUtil.saveSkey(resp.head.skey);
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			//ConfigUtil.saveSkey(e.head.skey);
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	/**
	 * 手机短信验证码回调
	 * 
	 * @param data
	 * @param status
	 */
	public void mobileTokenResponseData(Object data, int status) {
		switch (status) {
		case Global.DATA_OK:
			mobileTokenResp = (MobileTokenResp) data;
			getCatchaButton.setEnabled(false);
			voiceTokenLayout.setVisibility(View.VISIBLE);
			//ConfigUtil.saveSkey(mobileTokenResp.head.skey);
			timeCount = new TimeCount(mobileTokenResp.delay * 1000, 1000);
			timeCount.start();
			sendMobileTv.setText("验证码已发送至" + mobileTokenResp.mobile + "的手机");
			break;
		case Global.DATA_LOGICEXCEPTION:
			// 登录异常，会到这里
			MApiException e = (MApiException) data;
			//ConfigUtil.saveSkey(e.head.skey);
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	class TimeCount extends CountDownTimer {

		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		public void onFinish() {// 计时完毕时触发
			getCatchaButton.setText("发送");
			getCatchaButton.setEnabled(true);
		}

		public void onTick(long millisUntilFinished) {// 计时过程显示
			getCatchaButton.setText(millisUntilFinished / 1000 + "秒后重发");
		}
	}

	/**
	 * 语音验证码
	 * 
	 * @param data
	 * @param status
	 */
	public void voiceTokenResponseData(Object data, int status) {
		switch (status) {
		case Global.DATA_OK:
			showToast("语音验证码发送成功，请注意接听");
			voiceTokenResp = (VoiceTokenResp) data;
			//ConfigUtil.saveSkey(voiceTokenResp.head.skey);
			break;
		case Global.DATA_LOGICEXCEPTION:
			// 登录异常，会到这里
			MApiException e = (MApiException) data;
			//ConfigUtil.saveSkey(e.head.skey);
			showToast("语音验证码发送失败");
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			showToast("语音验证码发送失败");
			break;
		}
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("支付页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("支付页");
	    MobclickAgent.onPause(this);
    }

}
