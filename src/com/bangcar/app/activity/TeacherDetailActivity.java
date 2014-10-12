package com.bangcar.app.activity;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.dialog.NoTradeInfoDialog;
import com.bangcar.app.fragment.ProductDetail.ProductInfoFragment;
import com.bangcar.app.framework.ProductDetailRequestFramework;
import com.bangcar.app.framework.RemindProductFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.buy.BuyReq;
import com.bangcar.app.mapi.buy.BuyResp;
import com.bangcar.app.mapi.common.EAuthStep;
import com.bangcar.app.mapi.notify.RemindProductReq;
import com.bangcar.app.mapi.notify.RemindProductResp;
import com.bangcar.app.mapi.product.ProductDetailReq;
import com.bangcar.app.mapi.product.ProductDetailResp;
import com.bangcar.app.mapi.common.KV;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

import java.util.List;

/**
 * Created by xus5985 on 2014/6/24.
 */
public class TeacherDetailActivity extends BaseFragmentActivity {

    private Fragment[] mFragments;
    private FragmentManager fragmentManager;
    private View productDetailTextView, productStuffBuyTextView, productStuffSayTextView;
    private Button productBtn,addressBt;
    private FragmentTransaction fragmentTransaction;
    private TextView titleTv;
    private int pid;
    private Intent intent = null;

    private TextView productNameTv, startBuyTv, buyTimeTv, totalTv, periodTv, timeTv, rateTv,canBuyTv,backImg;
    private View loadingProgressFragmentView = null;
    private List<KV> TabParams = null;
    private float floatSize, fixSize;
    private Typeface rateFace;
    private ProgressBar progressBar;
    private final int REMIND = 0, BUY = 1, SOLD = 2;
    private boolean isRequest = false;
    private float fontSizeOrginal = 0;
    private int choosedColor = 0;
    private int unchoosedColor = 0;
    public static TeacherDetailActivity productDetailInstance = null;

    @Override
    protected void setLayout() {
        setContentView(R.layout.layout_product_detail);
    }

    @Override
    protected void findViews() {
        titleTv = (TextView)findViewById(R.id.titleTv);
        titleTv.setText("王师傅");
        backImg = (TextView)findViewById(R.id.backImg);
        backImg.setOnClickListener(this);
        addressBt = (Button)findViewById(R.id.addressBt);
        addressBt.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
    }

    @Override
    public void responseData(Object data, int status) {

    }

    @Override
    protected void setEvents() {
        findViewById(R.id.backImg).setOnClickListener(this);
    }




    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
	    MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        productDetailInstance = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backImg:
                finish();
                break;
            case R.id.addressBt:
                startActivity(new Intent(this,AddressActivity.class));
                break;
        }

    }
}
