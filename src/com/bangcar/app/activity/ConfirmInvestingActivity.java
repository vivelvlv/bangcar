package com.bangcar.app.activity;

import java.text.DecimalFormat;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.dialog.CalcDialog;
import com.bangcar.app.dialog.WaitChanceToBuyDialog;
import com.bangcar.app.framework.BuyRequestFramework;
import com.bangcar.app.framework.GetOrderIdFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.buy.BuyReq;
import com.bangcar.app.mapi.buy.BuyResp;
import com.bangcar.app.mapi.buy.GetOrderIdResp;
import com.bangcar.app.mapi.common.EAuthStep;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by vive on 2014/9/15.
 * 确认投资界面
 */
public class ConfirmInvestingActivity extends BaseActivity {
    private TextView cancelTv;
    private ImageView refreshBuyInfoIv;
    private int pid;
    private TextView virtualRemainShareTv, minBuyLimitTv, expectIncomeTv, productNameTv, expectedRevenueLabel;
    private CheckBox isAnonymousCb;
    private int maxBuyLimit;//支付上限
    private int minBuyLimit;//支付下限
    private EditText investEt;
    private TextView calcDialogLaunchBt;
    private BuyResp buyResp;
    private long incomeRate, investAmount = 0;
    private long expectIncomeE6;
    private int incomePeriod;
    private String resultString;
    public static ConfirmInvestingActivity confirmInvestInstance;
    private int incrShare;//增量

    @Override
    protected void setLayout() {
        setContentView(R.layout.layout_confirminvesting_activity);
        confirmInvestInstance = this;
    }

    @Override
    protected void findViews() {
        cancelTv = (TextView) findViewById(R.id.cancelTv);
        refreshBuyInfoIv = (ImageView) findViewById(R.id.refreshBuyInfoIv);
        virtualRemainShareTv = (TextView) findViewById(R.id.virtualRemainShareTv);
        minBuyLimitTv = (TextView) findViewById(R.id.minBuyLimitTv);
        expectIncomeTv = (TextView) findViewById(R.id.expectIncomeTv);
        productNameTv = (TextView) findViewById(R.id.productNameTv);
        isAnonymousCb = (CheckBox) findViewById(R.id.isAnonymousCb);
        investEt = (EditText) findViewById(R.id.investEt);
        calcDialogLaunchBt = (TextView) findViewById(R.id.calcDialogLaunchBt);
        expectedRevenueLabel = (TextView) findViewById(R.id.expectedRevenueLabel);
    }

    @Override
    protected void setEvents() {
        cancelTv.setOnClickListener(this);
        refreshBuyInfoIv.setOnClickListener(this);
        calcDialogLaunchBt.setOnClickListener(this);
        investEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                investEt.setSelection(investEt.length());
                if (charSequence.length() == 0) {
                    investAmount = 0;
                    resultString = "";
                    expectIncomeTv.setText("0");
                    return;
                }
                if (charSequence.toString().contains(".")) {
                    investEt.setText(charSequence.toString().substring(0, charSequence.toString().indexOf('.')));
                    return;
                }
                String inputNumber = charSequence.toString();
                long amount = Long.parseLong(inputNumber);
                if (amount == 0 && charSequence.length() == 2) {
                    investEt.setText("0");
                    return;
                }
                if (maxBuyLimit / 10000 < amount) {
                    //超出可购买的最大限制
                    amount = maxBuyLimit / 10000;
                    investEt.setText(amount + "");
                    showToast("超出购买额度限制");
                }
                getInputAndCalcExpectIncome(amount);
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void getInputAndCalcExpectIncome(long amount) {
        if (amount >= 0) {
            double result = incomeRate * incomePeriod * amount / (100 * 365);
            expectIncomeE6 = (long) (result * 1000000);
            DecimalFormat df = new DecimalFormat("######0");
            resultString = df.format(result);
            expectIncomeTv.setText(resultString);
            investAmount = amount;
        }

    }


    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        pid = intent.getIntExtra("productId", -1);
        buyResp = (BuyResp) intent.getSerializableExtra("buyResp");
        getFreshData(buyResp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancelTv:
                finish();
                break;
            case R.id.refreshBuyInfoIv://刷新
                showProgressDialog("刷新中...");
                BuyReq buyReq = new BuyReq();
                buyReq.head = Global.getReqHead();
                buyReq.setPid(pid);
//                new BuyRequestFramework(ConfirmInvestingActivity.this, ConfirmInvestingActivity.this, buyReq);
                break;
            case R.id.calcDialogLaunchBt:
                showCalcForIncome();
                break;
        }

    }

    //for ProductDetailActivity  buyButton feedback
    public void buyResponse(Object data, int status) {

        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
        switch (status) {
            case Global.DATA_OK:
                buyResp = (BuyResp) data;
                //ConfigUtil.saveSkey(buyResp.head.skey);
                EAuthStep eAuthStep = buyResp.authStep;
                switch (eAuthStep) {
                    case STEP_FINISH://finish
                        if (pid < 0) {
                            showToast("产品ID错误");
                            return;
                        }
                        if (!buyResp.canBuy) {
                            showToast("无法购买");
                            finish();
                            return;
                        }
//                        Intent intent = new Intent(this, ConfirmInvestingActivity.class);
//                        intent.putExtra("buyResp", buyResp);
//                        intent.putExtra("productId", pid);
                        getFreshData(buyResp);
                        return;
                    case STEP_IDCARD://身份认证
                        break;
                    case STEP_BANKCARD://绑定银行卡
                        break;
                    case STEP_TRANSPWD://设置交易密码
                        break;
                }
                finish();
                break;
            case Global.DATA_LOGICEXCEPTION:
                MApiException e = (MApiException) data;
                //ConfigUtil.saveSkey(e.head.skey);
                showToast(e.retMsg);
                break;
            case Global.DATA_SYSTEMEXCEPTION:
                break;
        }
    }


    private void getFreshData(BuyResp buyResp) {
        productNameTv.setText(buyResp.productName);
        virtualRemainShareTv.setText(buyResp.virtualRemainShare / 10000 + "万元");
        minBuyLimitTv.setText("(" + buyResp.minBuyLimit / 10000 + "万元起投)");
        maxBuyLimit = buyResp.maxBuyLimit;
        minBuyLimit = buyResp.minBuyLimit;
        expectedRevenueLabel.setText(buyResp.incomeTip);
        incomeRate = buyResp.incomeRateE6;
        incomePeriod = buyResp.incomePeriod;
        incrShare = buyResp.incrShare;
        getInputAndCalcExpectIncome(investAmount);
        if (buyResp.virtualRemainShare == 0) {
            if (buyResp.unpaidShare != 0) {
                new WaitChanceToBuyDialog(this).show();
            }
        }
    }


    /**
     * 提交按钮
     *
     * @param v
     */
    public void onClickInvestBt(View v) {

        if ((investAmount * 10000 - minBuyLimit) % incrShare != 0) {
            showToast("投资金额需是" + incrShare / 10000 + "万元的倍数");
            return;
        }
        if (investAmount > maxBuyLimit / 10000) {
            showToast("超过购买上限: " + maxBuyLimit / 10000 + "万元");
            return;
        }
        if (investAmount < minBuyLimit / 10000) {
            showToast("低于购买下限: " + minBuyLimit / 10000 + "万元");
            return;
        }
        //investAmount是万元为单位，现在转化成元,在转化成E6，提交给thrift接口
        long investAmountE6 = investAmount * 10000 * 1000000;
        new GetOrderIdFramework(this, pid, investAmountE6, expectIncomeE6, isAnonymousCb.isChecked());
        showProgressDialog("提交订单中...");
    }


    public void getOrderIdResponseData(Object data, int status) {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
        switch (status) {
            case Global.DATA_OK:
                GetOrderIdResp resp = (GetOrderIdResp) data;
                Intent intent = new Intent(baseAct, PayActivity.class);
                intent.putExtra("orderId", resp.orderId);
                startActivity(intent);
                //ConfigUtil.saveSkey(resp.head.skey);
                finish();
                break;
            case Global.DATA_LOGICEXCEPTION:
                MApiException e = (MApiException) data;
                showToast(e.retMsg);
                //ConfigUtil.saveSkey(e.head.skey);
                break;
            case Global.DATA_SYSTEMEXCEPTION:
                break;
        }
    }

    private void showCalcForIncome() {
        new CalcDialog(this, buyResp, resultString, investAmount).show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        confirmInvestInstance = null;
    }
    
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("下单页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("下单页");
	    MobclickAgent.onPause(this);
    }
}
