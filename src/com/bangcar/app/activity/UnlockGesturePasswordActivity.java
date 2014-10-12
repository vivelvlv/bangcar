package com.bangcar.app.activity;

import java.util.List;

import android.content.Intent;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.customview.LockPatternView;
import com.bangcar.app.customview.LockPatternView.Cell;
import com.bangcar.app.mapi.common.User;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.LockPatternUtils;
import com.umeng.analytics.MobclickAgent;

public class UnlockGesturePasswordActivity extends BaseActivity {
	private LockPatternView mLockPatternView;
	private int mFailedPatternAttemptsSinceLastTimeout = 0;
	private LockPatternUtils patternUtils;
	private Vibrator vib = null;
	// 输错之后震动时间
	private final int VIBRATETIME = 1000;
	private TextView welcomeNameTv;
	private User user = null;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_gesturepassword_unlock);
		patternUtils = new LockPatternUtils(baseAct);
		vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		user = ConfigUtil.getUser();
	}

	@Override
	protected void findViews() {
		mLockPatternView = (LockPatternView) findViewById(R.id.gesturepwd_unlock_lockview);
		mLockPatternView.setTactileFeedbackEnabled(true);
		welcomeNameTv = (TextView) findViewById(R.id.welcomeNameTv);
		if (!TextUtils.isEmpty(user.name)) {
			// 已实名验证
			welcomeNameTv.setText(user.name + "，欢迎回来");
		} else {
			welcomeNameTv.setText(user.mobile);
		}
	}

	@Override
	protected void setEvents() {
		mLockPatternView.setOnPatternListener(mChooseNewLockPatternListener);
		findViewById(R.id.forgetGesturePwd).setOnClickListener(this);
		findViewById(R.id.loginWithAnother).setOnClickListener(this);
	}

	private Runnable mClearPatternRunnable = new Runnable() {
		public void run() {
			mLockPatternView.clearPattern();
		}
	};

	protected LockPatternView.OnPatternListener mChooseNewLockPatternListener = new LockPatternView.OnPatternListener() {

		public void onPatternStart() {
			mLockPatternView.removeCallbacks(mClearPatternRunnable);
			patternInProgress();
		}

		public void onPatternCleared() {
			mLockPatternView.removeCallbacks(mClearPatternRunnable);
		}

		public void onPatternDetected(List<LockPatternView.Cell> pattern) {
			if (pattern == null)
				return;
			if (patternUtils.checkPattern(pattern)) {
				mLockPatternView
						.setDisplayMode(LockPatternView.DisplayMode.Correct);
				Intent intent = new Intent(UnlockGesturePasswordActivity.this,
						RootActivity.class);
				// 打开新的Activity
				startActivity(intent);
				showCenterToast("解锁成功");
				finish();
			} else {
				vib.vibrate(VIBRATETIME);
				mLockPatternView
						.setDisplayMode(LockPatternView.DisplayMode.Wrong);
				if (pattern.size() >= LockPatternUtils.MIN_PATTERN_REGISTER_FAIL) {
					mFailedPatternAttemptsSinceLastTimeout++;
					int retry = LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT
							- mFailedPatternAttemptsSinceLastTimeout;
					if (retry >= 0) {
						if (retry == 0) {
							YGBApp.getInstance().showSystemCenterToast(
									R.string.no_retry_time);
							patternUtils.clearLock();
							startActivity(new Intent(baseAct,
									LoginActivity.class));
							baseAct.finish();
							return;
						} else {
							showCenterToast("密码错误，还可以再输入" + retry + "次");
						}
					}
				} else {
					showCenterToast(R.string.lockpattern_recording_incorrect_too_short);
				}

				if (mFailedPatternAttemptsSinceLastTimeout < LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT) {
					mLockPatternView.postDelayed(mClearPatternRunnable, 2000);
				}
			}
		}

		public void onPatternCellAdded(List<Cell> pattern) {

		}

		private void patternInProgress() {
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		JPushInterface.onResume(this);
		MobclickAgent.onPageStart("手势解锁页"); // 统计页面
		MobclickAgent.onResume(this);
		/**
		 * if no gesture file in phone, will lanuch LoginActivity instead of
		 * this Gesture Login Activity
		 */
		if (!patternUtils.savedPatternExists()) {
			startActivity(new Intent(this, LoginActivity.class));
			finish();
		}
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		JPushInterface.onPause(this);
		MobclickAgent.onPageEnd("手势解锁页");
		MobclickAgent.onPause(this);
	}

	@Override
	protected void initDatas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.forgetGesturePwd:
			// 忘记手势密码
			patternUtils.clearLock();
			startActivity(new Intent(baseAct, FindGesturePasswordActivity.class));
			baseAct.finish();
			YGBApp.getConfigSp().edit().putString("mobile", "").commit();
			break;
		case R.id.loginWithAnother:
			// 其他帐号登录
			startActivity(new Intent(baseAct, LoginActivity.class));
			baseAct.finish();
//			YGBApp.getConfigSp().edit().putString("mobile", "").commit();
			break;
		}
	}
	
	@Override
	protected void onDestroy() {
		if(mLockPatternView != null){
			mLockPatternView.release();
		}
		super.onDestroy();
	}
}
