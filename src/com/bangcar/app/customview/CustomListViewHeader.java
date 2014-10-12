package com.bangcar.app.customview;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;

public class CustomListViewHeader extends LinearLayout {
	private LinearLayout mContainer;
	private ImageView mArrowImageView;
	private ProgressBar mProgressBar;
	private TextView mHintTextView;
	private int mState = STATE_NORMAL;

	private Animation mRotateUpAnim;
	private Animation mRotateDownAnim;

	private final int ROTATE_ANIM_DURATION = 180;

	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_REFRESHING = 2;

	private Spanned refreshText;

	public CustomListViewHeader(Context context) {
		super(context);
		initView(context);
        if (isInEditMode()) { return; }
		refreshText = Html.fromHtml(YGBApp.getRes().getString(
				R.string.pull_to_refresh_pull_label));
	}

	public void SetCorpUserCountAndCorpName(int CorpUserCount, String CorpName) {
		refreshText = Html.fromHtml("<font color=\"#F05141\">" + CorpUserCount
				+ "</font><font color=\"#A9A9A9\">位</font><font color=\"#F05141\"> " + CorpName
				+ "</font><font color=\"#A9A9A9\">的同事</font>");
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public CustomListViewHeader(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(Context context) {
		// 初始情况，设置下拉刷新view高度为0
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, 0);
		mContainer = (LinearLayout) LayoutInflater.from(context).inflate(
				R.layout.pull_refresh_listview_header, null);
		addView(mContainer, lp);
		setGravity(Gravity.BOTTOM);

//		mArrowImageView = (ImageView) findViewById(R.id.pull_to_refresh_image);
		mHintTextView = (TextView) findViewById(R.id.pull_to_refresh_text);
		mProgressBar = (ProgressBar) findViewById(R.id.pull_to_refresh_progress);

		mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
		mRotateUpAnim.setFillAfter(true);
		mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
		mRotateDownAnim.setFillAfter(true);
	}

	public void setState(int state) {
		if (state == mState)
			return;
        mProgressBar.setVisibility(View.VISIBLE);
        mHintTextView.setText(refreshText);
////		if (state == STATE_REFRESHING) { // 显示进度
//////			mArrowImageView.clearAnimation();
//////			mArrowImageView.setVisibility(View.INVISIBLE);
////			mProgressBar.setVisibility(View.VISIBLE);
////		} else { // 显示箭头图片
//////			mArrowImageView.setVisibility(View.INVISIBLE);
////			mProgressBar.setVisibility(View.VISIBLE);
////		}
//        mProgressBar.setVisibility(View.VISIBLE);
//		switch (state) {
//		case STATE_NORMAL:
//			if (mState == STATE_READY) {
////				mArrowImageView.startAnimation(mRotateDownAnim);
//			}
//			if (mState == STATE_REFRESHING) {
////				mArrowImageView.clearAnimation();
//			}
//			mHintTextView.setText(refreshText);
//			break;
//		case STATE_READY:
//			if (mState != STATE_READY) {
////				mArrowImageView.clearAnimation();
////				mArrowImageView.startAnimation(mRotateUpAnim);
//				mHintTextView.setText(refreshText);
//			}
//			break;
//		case STATE_REFRESHING:
//			mHintTextView.setText(refreshText);
//			break;
//		default:
//		}

		mState = state;
	}

	public void setVisiableHeight(int height) {
		if (height < 0)
			height = 0;
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContainer
				.getLayoutParams();
		lp.height = height;
		mContainer.setLayoutParams(lp);
	}

	public int getVisiableHeight() {
		return mContainer.getHeight();
	}

}
