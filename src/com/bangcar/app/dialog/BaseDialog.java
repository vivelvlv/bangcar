package com.bangcar.app.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;

public abstract class BaseDialog extends Dialog implements OnClickListener {

	public Context context;
	public ProgressDialog dialog = null;
	public Toast toast = null;
	public BaseDialog(Context context) {
		super(context,R.style.dialogStyle);
		this.context = context;
		dialog = new ProgressDialog(context);
	}

	public void showToast(String msg) {
		toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
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
		toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
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
		return YGBApp.getRes().getString(id);
	}

	public int getColor(int id) {
		return YGBApp.getRes().getColor(id);
	}

	/** init to get the views to values */
	protected abstract void findViews();

	/** setEvents deals to every views */
	protected abstract void setEvents();

	/** other data inits */
	protected abstract void initDatas();
	public abstract void responseData(Object data,int status);
}
