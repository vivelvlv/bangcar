package com.bangcar.app.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bangcar.app.YGBApp;

public abstract class BaseFragment extends Fragment implements OnClickListener {

	public View currentView;
	public ProgressDialog dialog = null;
	public Activity baseAct;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		baseAct = activity;
		dialog = new ProgressDialog(baseAct);
	}

	public void showToast(String msg) {
		if(baseAct == null){
			return;
		}
		Toast.makeText(baseAct, msg, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public abstract View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState);

	public void showToast(int id) {
		showToast(getStr(id));
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
}
