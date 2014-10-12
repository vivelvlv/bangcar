package com.bangcar.app.fragment.RootFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.activity.HelpCenterActivity;
import com.bangcar.app.activity.LoginActivity;
import com.bangcar.app.dialog.ServiceTelDialog;
import com.bangcar.app.dialog.SimpleDialog;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.framework.CheckUpdateFramework;
import com.bangcar.app.framework.SignOutFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.user.SignOutReq;
import com.bangcar.app.mapi.utility.StartUpResp;
import com.bangcar.app.mapi.utility.Version;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by 9020MT on 2014/9/9.
 */
public class SettingsFragment extends BaseFragment {
	protected final int downBegin = 0x0226;
	protected final int downEnd = 0x0227;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		currentView = inflater.inflate(
				R.layout.layout_root_activity_settingsfragment, null);
		// pushMsgLayout = currentView.findViewById(R.id.pushMsgLayout);

		findViews(currentView);
		setEvents(currentView);
		return currentView;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.gradeLayout:
//			Uri uri = Uri.parse("market://details?id="
//					+ getActivity().getPackageName());
//			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			startActivity(intent);
			break;
		case R.id.telLayout:
//			new ServiceTelDialog(getActivity()).show();
			break;
		case R.id.signOutButton:
			String registerId = YGBApp.getConfigSp()
					.getString("registerId", "");
			if (TextUtils.isEmpty(registerId)) {
				ConfigUtil.clearSkey();
				startActivity(new Intent(baseAct, LoginActivity.class));
				baseAct.finish();
				return;
			}
			showProgressDialog("正在退出登录...");
			SignOutReq req = new SignOutReq();
			req.head = Global.getReqHead();
			req.deviceToken = registerId;
			new SignOutFramework(baseAct, this, req);
			break;
		case R.id.helpLayout:
//			startActivity(new Intent(baseAct, HelpCenterActivity.class));
			break;
		case R.id.checkUpdateLayout:
			showProgressDialog("正在检查更新");
			//new CheckUpdateFramework(baseAct, SettingsFragment.this);
			break;
		}
	}

	private void findViews(View view) {

	}

	private void setEvents(View view) {
		view.findViewById(R.id.accountSafeLayout).setOnClickListener(this);
		view.findViewById(R.id.checkUpdateLayout).setOnClickListener(this);
		view.findViewById(R.id.gradeLayout).setOnClickListener(this);
		view.findViewById(R.id.helpLayout).setOnClickListener(this);
		view.findViewById(R.id.telLayout).setOnClickListener(this);
		view.findViewById(R.id.aboutLayout).setOnClickListener(this);
		view.findViewById(R.id.signOutButton).setOnClickListener(this);
	}

	public void signOutCallback(Object data, int status) {
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
		switch (status) {
		case Global.DATA_OK:
			ConfigUtil.clearSkey();
			startActivity(new Intent(baseAct, LoginActivity.class));
			baseAct.finish();
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}

	}

	public void receiveData(Object data, int status) {
		cancelDialog();
		switch (status) {
		case Global.DATA_OK:
			StartUpResp resp = (StartUpResp) data;
			Version v = resp.getVersion();
			// 这个字段不为空则表示有更新。
			if (v != null) {
				// boolean forceUpdate = v.forceUpdate;

				final String apkUrl = v.apkUrl;
				final String apkName = apkUrl
						.substring(apkUrl.lastIndexOf('/') + 1);
				
				final Handler handler = new Handler() {
					public void handleMessage(Message msg) {
						if (msg.what == downBegin) {
							showProgressDialog("正在下载安装包");
						}else if (msg.what == downEnd){
							cancelDialog();
						}
					}
				};

				new SimpleDialog(getActivity()) {
					protected void setTitle() {
						if (title != null) {
							title.setText("发现新版本，立即更新？");
						}
					}

					protected void onOk() {
						new Thread() {
							public void run() {
								handler.sendEmptyMessage(downBegin);
								HttpClient client = new DefaultHttpClient();
								HttpGet get = new HttpGet(apkUrl);
								HttpResponse response = null;
								try {
									response = client.execute(get);
									HttpEntity entity = response.getEntity();
									long length = entity.getContentLength();
									InputStream is = entity.getContent();

									if (is != null) {
										File file = new File(
												Environment
														.getExternalStorageDirectory(),
												apkName);
										FileOutputStream fos = new FileOutputStream(
												file);
										byte[] buf = new byte[1024];
										int ch = -1;
										int count = 0;
										while ((ch = is.read(buf)) != -1) {
											fos.write(buf, 0, ch);
											count += ch;
											if (count == length) {
											}
										}

										fos.flush();
										fos.close();
										handler.sendEmptyMessage(downEnd);
										// 安装APK
										Intent intent = new Intent();
										intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
										intent.setAction(android.content.Intent.ACTION_VIEW);
										intent.setDataAndType(
												Uri.fromFile(file),
												"application/vnd.android.package-archive");
										startActivity(intent);									
									}
								} catch (ClientProtocolException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}.start();
					}
				}.show();

				
			} else {
				// 无须更新
			}

			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MobclickAgent.onPageStart("设置页");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPageEnd("设置页");
	}
}
