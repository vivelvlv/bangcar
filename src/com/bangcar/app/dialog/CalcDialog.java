package com.bangcar.app.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bangcar.app.R;
import com.bangcar.app.mapi.buy.BuyResp;

import java.text.DecimalFormat;


/**
 * Created by 9020MT on 2014/9/23.
 */
public class CalcDialog extends BaseDialog {
    private View closeImg;
    private TextView expectIncomeLabel, expectIncomeTv, expectRateLabel, investAmountTv, investDaysTv, calcDaysTv, endTimeDayTv, beginTimeDayTv, expectRateTv;
    private BuyResp buyResp;
    private String resultString;
    private long investAmount;

    public CalcDialog(Context context, BuyResp buyResp, String resultString, long investAmount) {
        super(context);
        this.buyResp = buyResp;
        this.resultString = resultString;
        this.investAmount = investAmount;
        setContentView(R.layout.layout_calc_dialog);
        findViews();
        setEvents();
    }

    @Override
    protected void findViews() {
        closeImg = findViewById(R.id.closeImg);
        expectIncomeLabel = (TextView) findViewById(R.id.expectIncomeLabel);
        expectIncomeTv = (TextView) findViewById(R.id.expectIncomeTv);
        expectRateLabel = (TextView) findViewById(R.id.expectRateLabel);
        investAmountTv = (TextView) findViewById(R.id.investAmountTv);
        investDaysTv = (TextView) findViewById(R.id.investDaysTv);
        calcDaysTv = (TextView) findViewById(R.id.calcDaysTv);
        endTimeDayTv = (TextView) findViewById(R.id.endTimeDayTv);
        beginTimeDayTv = (TextView) findViewById(R.id.beginTimeDayTv);
        expectRateTv = (TextView) findViewById(R.id.expectRateTv);
    }

    @Override
    protected void setEvents() {
        closeImg.setOnClickListener(this);
        if (resultString == null || resultString.isEmpty()) {
            expectIncomeTv.setText("0.00");
        } else {
            expectIncomeTv.setText(resultString);
        }
        expectIncomeLabel.setText(buyResp.incomeTip);
        expectRateLabel.setText(buyResp.incomeRateTip);

        DecimalFormat df = new DecimalFormat("######0.0");
        expectRateTv.setText(df.format((double)buyResp.incomeRateE6 / 10000) + "%");
        investAmountTv.setText(investAmount + "");
        investDaysTv.setText(buyResp.incomePeriod + "/365");
        calcDaysTv.setText("*计息天数(" + buyResp.incomePeriod + "天)");
        endTimeDayTv.setText("到期日(" + buyResp.incomeEndDate + ")");
        beginTimeDayTv.setText("起息日(" + buyResp.incomeBeginDate + ")");
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void responseData(Object data, int status) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.closeImg:
                CalcDialog.this.cancel();
                break;
        }

    }
}
