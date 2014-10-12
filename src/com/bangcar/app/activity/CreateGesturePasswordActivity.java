package com.bangcar.app.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.customview.LockPatternView;
import com.bangcar.app.customview.LockPatternView.Cell;
import com.bangcar.app.customview.LockPatternView.DisplayMode;
import com.bangcar.app.util.LockPatternUtils;
import com.umeng.analytics.MobclickAgent;

public class CreateGesturePasswordActivity extends Activity implements
		OnClickListener {
	private static final int ID_EMPTY_MESSAGE = -1;
	private static final String KEY_UI_STAGE = "uiStage";
	private static final String KEY_PATTERN_CHOICE = "chosenPattern";
	private LockPatternView mLockPatternView;
	protected TextView mHeaderText;
	protected List<LockPatternView.Cell> mChosenPattern = null;
	private Toast mToast;
	private Stage mUiStage = Stage.Introduction;
	private View mPreviewViews[][] = new View[3][3];
	private TextView resetTv = null; // 重设手势密码

	/**
	 * Keep track internally of where the user is in choosing a pattern.
	 */
	protected enum Stage {
		
		Introduction(R.string.lockpattern_recording_intro_header,
				ID_EMPTY_MESSAGE, true), ChoiceTooShort(
				R.string.lockpattern_recording_incorrect_too_short,
				ID_EMPTY_MESSAGE, true), FirstChoiceValid(
				R.string.lockpattern_pattern_entered_header, ID_EMPTY_MESSAGE,
				false), NeedToConfirm(R.string.lockpattern_need_to_confirm,
				ID_EMPTY_MESSAGE, true), ConfirmWrong(
				R.string.lockpattern_need_to_unlock_wrong, ID_EMPTY_MESSAGE,
				true), ChoiceConfirmed(
				R.string.lockpattern_pattern_confirmed_header,
				ID_EMPTY_MESSAGE, false);

		/**
		 * @param headerMessage
		 *            The message displayed at the top.
		 * @param leftMode
		 *            The mode of the left button.
		 * @param rightMode
		 *            The mode of the right button.
		 * @param footerMessage
		 *            The footer message.
		 * @param patternEnabled
		 *            Whether the pattern widget is enabled.
		 */
		Stage(int headerMessage, int footerMessage, boolean patternEnabled) {
			this.headerMessage = headerMessage;
			this.footerMessage = footerMessage;
			this.patternEnabled = patternEnabled;
		}

		final int headerMessage;
		final int footerMessage;
		final boolean patternEnabled;
	}

	private void showToast(CharSequence message) {
		if (null == mToast) {
			mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
			mToast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			mToast.setText(message);
		}
		mToast.show();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_gesturepassword_create);
		mLockPatternView = (LockPatternView) this
				.findViewById(R.id.gesturepwd_create_lockview);
		mLockPatternView.clearPattern();
		mLockPatternView.setDisplayMode(DisplayMode.Correct);
		mHeaderText = (TextView) findViewById(R.id.gesturepwd_create_text);
		initPreviewViews();
		mLockPatternView.setOnPatternListener(mChooseNewLockPatternListener);
		mLockPatternView.setTactileFeedbackEnabled(true);
		resetTv = (TextView) findViewById(R.id.resetTv);
		resetTv.setOnClickListener(this);
		updateStage(Stage.Introduction);
		if (savedInstanceState == null) {
			updateStage(Stage.Introduction);
		} else {
			// restore from previous state
			final String patternString = savedInstanceState
					.getString(KEY_PATTERN_CHOICE);
			if (patternString != null) {
				mChosenPattern = LockPatternUtils
						.stringToPattern(patternString);
			}
			updateStage(Stage.values()[savedInstanceState.getInt(KEY_UI_STAGE)]);
		}

	}

	private void initPreviewViews() {
		mPreviewViews = new View[3][3];
		mPreviewViews[0][0] = findViewById(R.id.gesturepwd_setting_preview_0);
		mPreviewViews[0][1] = findViewById(R.id.gesturepwd_setting_preview_1);
		mPreviewViews[0][2] = findViewById(R.id.gesturepwd_setting_preview_2);
		mPreviewViews[1][0] = findViewById(R.id.gesturepwd_setting_preview_3);
		mPreviewViews[1][1] = findViewById(R.id.gesturepwd_setting_preview_4);
		mPreviewViews[1][2] = findViewById(R.id.gesturepwd_setting_preview_5);
		mPreviewViews[2][0] = findViewById(R.id.gesturepwd_setting_preview_6);
		mPreviewViews[2][1] = findViewById(R.id.gesturepwd_setting_preview_7);
		mPreviewViews[2][2] = findViewById(R.id.gesturepwd_setting_preview_8);
	}

	private void updatePreviewViews() {
		if (mChosenPattern == null)
			return;
		Log.i("way", "result = " + mChosenPattern.toString());
		for (LockPatternView.Cell cell : mChosenPattern) {
			Log.i("way", "cell.getRow() = " + cell.getRow()
					+ ", cell.getColumn() = " + cell.getColumn());
			mPreviewViews[cell.getRow()][cell.getColumn()]
					.setBackgroundResource(R.drawable.gesture_small_circle_select);

		}
	}
	
	private void resetPreviews(){
		for(int i = 0;i<mPreviewViews.length;i++){
			for(int j = 0;j<mPreviewViews[i].length;j++){
				mPreviewViews[i][j].setBackgroundResource(R.drawable.gesture_small_circle_normal);
			}
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_UI_STAGE, mUiStage.ordinal());
		if (mChosenPattern != null) {
			outState.putString(KEY_PATTERN_CHOICE,
					LockPatternUtils.patternToString(mChosenPattern));
		}
	}

	private Runnable mClearPatternRunnable = new Runnable() {
		public void run() {
			mLockPatternView.clearPattern();
			// updateStage(Stage.Introduction);
		}
	};
	private Runnable mClearFirstRunnable = new Runnable() {
		public void run() {
			mLockPatternView.clearPattern();
			updateStage(Stage.NeedToConfirm);
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
			if (mUiStage == Stage.NeedToConfirm
					|| mUiStage == Stage.ConfirmWrong) {
				if (mChosenPattern == null)
					throw new IllegalStateException(
							"null chosen pattern in stage 'need to confirm");
				if (mChosenPattern.equals(pattern)) {
					updateStage(Stage.ChoiceConfirmed);
				} else {
					updateStage(Stage.ConfirmWrong);
				}
			} else if (mUiStage == Stage.Introduction
					|| mUiStage == Stage.ChoiceTooShort) {
				if (pattern.size() < LockPatternUtils.MIN_LOCK_PATTERN_SIZE) {
					updateStage(Stage.ChoiceTooShort);
				} else {
					mChosenPattern = new ArrayList<LockPatternView.Cell>(
							pattern);
					updateStage(Stage.NeedToConfirm);
				}
			} else {
				throw new IllegalStateException("Unexpected stage " + mUiStage
						+ " when " + "entering the pattern.");
			}
		}

		public void onPatternCellAdded(List<Cell> pattern) {

		}

		private void patternInProgress() {
			mHeaderText.setText(R.string.lockpattern_recording_inprogress);
		}
	};

	/**
	 * 更新状态
	 * 
	 * @param stage
	 */
	private void updateStage(Stage stage) {
		mUiStage = stage;
		if (stage == Stage.ChoiceTooShort) {
			mHeaderText.setText(getResources().getString(stage.headerMessage,
					LockPatternUtils.MIN_LOCK_PATTERN_SIZE));
		} else {
			mHeaderText.setText(stage.headerMessage);
		}
		// same for whether the patten is enabled
		if (stage.patternEnabled) {
			mLockPatternView.enableInput();
		} else {
			mLockPatternView.disableInput();
		}
		mLockPatternView.setDisplayMode(DisplayMode.Correct);
		switch (mUiStage) {
		case Introduction:
			mLockPatternView.clearPattern();
			resetTv.setVisibility(View.GONE);
			resetPreviews();
			break;
		case ChoiceTooShort:
			mLockPatternView.setDisplayMode(DisplayMode.Wrong);
			postClearPatternRunnable();
			break;
		case FirstChoiceValid:
			break;
		case NeedToConfirm:
			// postClearFirstPatternRunnable();
			updatePreviewViews();
			resetTv.setVisibility(View.VISIBLE);
			mLockPatternView.clearPattern();
			break;
		case ConfirmWrong:
			mLockPatternView.setDisplayMode(DisplayMode.Wrong);
			postClearPatternRunnable();
			break;
		case ChoiceConfirmed:
			saveChosenPatternAndFinish();
			break;
		default:
			break;
		}

	}

	// clear the wrong pattern unless they have started a new one
	// already
	private void postClearPatternRunnable() {
		mLockPatternView.removeCallbacks(mClearPatternRunnable);
		mLockPatternView.postDelayed(mClearPatternRunnable, 1000);
	}

	private void postClearFirstPatternRunnable() {
		mLockPatternView.removeCallbacks(mClearFirstRunnable);
		mLockPatternView.postDelayed(mClearFirstRunnable, 1000);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.resetTv:
			updateStage(Stage.Introduction);
			break;
		}
	}

	private void saveChosenPatternAndFinish() {
		new LockPatternUtils(CreateGesturePasswordActivity.this)
				.saveLockPattern(mChosenPattern);
		showToast("密码设置成功");
		/*** 需要在这个地方增加本地保存，SESSION KEY的内容，以后通过手势时候发送SESSION KEY就可以确认登录了 8-1 ***/
		startActivity(new Intent(this, RootActivity.class));
		finish();
		if (LoginActivity.loginInstance != null) {
			LoginActivity.loginInstance.finish();
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (mLockPatternView != null) {
			mLockPatternView.release();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		JPushInterface.onResume(this);
		MobclickAgent.onPageStart("创建手势密码页");
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		JPushInterface.onPause(this);
		MobclickAgent.onPageEnd("创建手势密码页");
		MobclickAgent.onPause(this);
	}
}
