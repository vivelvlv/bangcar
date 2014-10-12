package com.bangcar.app.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.activity.AccountManagerActivity;
import com.bangcar.app.framework.CheckAuthFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.common.EAuthStep;
import com.bangcar.app.mapi.profile.AuthCheckResp;
import com.bangcar.app.util.Global;

/**
 * Created by 9020MT on 2014/9/15.
 */
public class NoTradeInfoDialog extends BaseDialog {
    private int pid;
    private String text;
    private TextView showText;
    private EAuthStep eAuthStep;
    public NoTradeInfoDialog(Context context, int pid,String showText,EAuthStep eAuthStep) {
        super(context);
        this.pid = pid;
        this.text = showText;
        this.eAuthStep = eAuthStep;
        setContentView(R.layout.layout_dialog_notradeinfo);
        setEvents();
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void setEvents() {
        findViewById(R.id.cancelButton).setOnClickListener(this);
        findViewById(R.id.gotoSetTradeInfoButton).setOnClickListener(this);
        showText = (TextView)findViewById(R.id.showText);
        showText.setText(text);
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
            case R.id.cancelButton:
                this.cancel();
                break;
            case R.id.gotoSetTradeInfoButton:
                showProgressDialog("账号处理中...");
                new CheckAuthFramework((Activity)context,NoTradeInfoDialog.this,true);
                break;
        }

    }

    public void reponseCheckAuth(Object data, int status){
        cancelDialog();
        switch (status){
            case Global.DATA_OK:
                Intent intent = new Intent(context, AccountManagerActivity.class);
                intent.putExtra("eAuth",(AuthCheckResp)data);
                intent.putExtra("pid",pid);
                context.startActivity(intent);
                this.cancel();
                break;
            case Global.DATA_LOGICEXCEPTION:
                showToast(((MApiException)data).retMsg);
                break;
            case Global.DATA_SYSTEMEXCEPTION:
                showToast(((MApiException)data).retMsg);
                break;
        }
    }
}
