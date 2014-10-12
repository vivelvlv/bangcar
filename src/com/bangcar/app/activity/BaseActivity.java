package com.bangcar.app.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

import com.bangcar.app.YGBApp;

public abstract class BaseActivity extends Activity implements OnClickListener {

	public BaseActivity baseAct;
	public ProgressDialog dialog = null;
	public Toast toast = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
		if(baseAct == null){
			return;
		}
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
		if(baseAct == null){
			return;
		}
		toast = Toast.makeText(baseAct, msg, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	public void showCenterToast(int id) {
		showCenterToast(getStr(id));
	}

	public void showProgressDialog(String text) {
		if(baseAct == null){
			return;
		}
		dialog.setMessage(text);
		dialog.show();
	}

	public void cancelDialog() {
		if(baseAct == null){
			return;
		}
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
	}

	public String getStr(int id) {
		return YGBApp.getRes().getString(id);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	public int getColor(int id) {
		return YGBApp.getRes().getColor(id);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (toast != null) {
			toast.cancel();

		}
        cancelDialog();
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
