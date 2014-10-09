package com.bangcar.app.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.bangcar.app.BTCApp;

/**
 * Created by vive on 2014/10/8.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {

    public BaseActivity baseAct;
    public ProgressDialog dialog = null;
    public Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        baseAct = this;
        dialog = new ProgressDialog(baseAct);
        setLayout();
        findViews();
        setEvents();
        initDatas();
    }

    public void showToast(String msg) {
        toast = Toast.makeText(baseAct, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showToast(int id) {
        showToast(getStr(id));
    }

    /**
     * 显示在中间的toast
     *
     * @param msg
     */
    public void showCenterToast(String msg) {
        toast = Toast.makeText(baseAct, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void showCenterToast(int id) {
        showCenterToast(getStr(id));
    }

    public void showProgressDialog(String text) {
        dialog.setMessage(text);
        dialog.show();
    }

    public void cancelDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }

    public String getStr(int id) {
        return BTCApp.getRes().getString(id);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    public int getColor(int id) {
        return BTCApp.getRes().getColor(id);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (toast != null) {
            toast.cancel();
        }
    }

    /** setContentView For Activity,must be realized */
    protected abstract void setLayout();

    /** init to get the views to values */
    protected abstract void findViews();

    /** setEvents deals to every views */
    protected abstract void setEvents();

    /** other data inits */
    protected abstract void initDatas();
}

