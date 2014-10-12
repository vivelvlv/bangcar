package com.bangcar.app.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.framework.ProductDetailHtmlFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.product.ProductWebViewResp;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by 9020MT on 2014/8/27.
 */
public class ProductDetailHtmlActivity extends BaseActivity {

    public final static String PIDACTION = "com.noahyijie.ygb.activity.ProductHtmlActivity.Pid";
    public final static String HTML_REQUEST_NAME = "com.noahyijie.ygb.activity.ProductHtmlActivity.HtmlRequestName";
    public final static String HTML_REQUEST_TYPE = "com.noahyijie.ygb.activity.ProductHtmlActivity.HtmlRequestType";
    private WebView webView = null;
    private TextView titleTv = null;
    private int pid;

    @Override
    protected void setLayout() {
        setContentView(R.layout.layout_html);
    }

    @Override
    protected void findViews() {
        webView = (WebView) findViewById(R.id.webView);
        titleTv = (TextView) findViewById(R.id.titleTv);
    }

    @Override
    protected void setEvents() {
        findViewById(R.id.backImg).setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        titleTv.setText("风险控制");
        Intent intent = getIntent();
        String name = intent.getStringExtra(HTML_REQUEST_NAME);
        String type = intent.getStringExtra(HTML_REQUEST_TYPE);
        pid = intent.getIntExtra(PIDACTION, 0);
        if (pid <= 0) {
            showToast("产品id异常");
            finish();
        }
        titleTv.setText(name);
        new ProductDetailHtmlFramework(this, pid, type);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backImg:
                finish();
                break;
        }
    }

    public void CallbackData(Object obj, int status) {
        switch (status) {
            case Global.DATA_OK:
                ProductWebViewResp resp = (ProductWebViewResp) obj;
                //ConfigUtil.saveSkey(resp.head.skey);
                webView.getSettings().setDefaultTextEncodingName("UTF-8");
                webView.loadDataWithBaseURL(null, resp.getHtml(), "text/html", "utf-8", null);
                break;
            case Global.DATA_LOGICEXCEPTION:
                MApiException e = (MApiException)obj;
                //ConfigUtil.saveSkey(e.head.skey);
                break;
            case Global.DATA_SYSTEMEXCEPTION:
                break;
        }
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("产品风险控制页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("产品风险控制页");
	    MobclickAgent.onPause(this);
    }
}
