package com.bangcar.app.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by 9020MT on 2014/9/9.
 */
public class RootActivity extends BaseFragmentActivity {
	private Fragment[] mFragments;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private LinearLayout ProductListFragment_button, InvestFragment_button,
			SettingsFragment_button;
    private ImageView productListImageView,myInvestMenuImageView;
    private TextView productListMenuTv,myInvestMenuTv;
    private Drawable productUnChoose,productChoose,myInvestUnChoose,myInvestChoose;

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_root_activity);
	}

	@Override
	protected void findViews() {
		ProductListFragment_button = (LinearLayout) findViewById(R.id.ProductListFragment_button);
		InvestFragment_button = (LinearLayout) findViewById(R.id.InvestFragment_button);
		SettingsFragment_button = (LinearLayout) findViewById(R.id.SettingsFragment_button);
        //菜单按下的变化效果
        productListImageView = (ImageView) findViewById(R.id.productListImageView);
        myInvestMenuImageView = (ImageView) findViewById(R.id.myInvestMenuImageView);
        productListMenuTv = (TextView) findViewById(R.id.productListMenuTv);
        myInvestMenuTv = (TextView) findViewById(R.id.myInvestMenuTv);
        productUnChoose = getResources().getDrawable(R.drawable.product_unchoose);
        productChoose = getResources().getDrawable(R.drawable.product_choose);
        myInvestChoose = getResources().getDrawable(R.drawable.myinvest_choose);
        myInvestUnChoose = getResources().getDrawable(R.drawable.myinvest_unchoose);
	}

	@Override
	protected void setEvents() {
		ProductListFragment_button.setOnClickListener(this);
		InvestFragment_button.setOnClickListener(this);
		SettingsFragment_button.setOnClickListener(this);
	}

	@Override
	protected void initDatas() {
		mFragments = new Fragment[3];
		fragmentManager = getSupportFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();

		mFragments[0] = fragmentManager
				.findFragmentById(R.id.TeacherListFragment);
		mFragments[1] = fragmentManager.findFragmentById(R.id.InvestFragment);
		mFragments[2] = fragmentManager.findFragmentById(R.id.SettingsFragment);
		fragmentTransaction.hide(mFragments[1]).hide(mFragments[2])
				.show(mFragments[0]).commit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		JPushInterface.onResume(this);
		 MobclickAgent.onResume(this);
		if (Global.needRefreshInvest) {
			fragmentTransaction = fragmentManager.beginTransaction()
					.hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
			fragmentTransaction.show(mFragments[1]).commit();
			productListImageView.setImageDrawable(productUnChoose);
	        productListMenuTv.setTextColor(getColor(R.color.menu_unchoose));
	        myInvestMenuImageView.setImageDrawable(myInvestChoose);
            myInvestMenuTv.setTextColor(getColor(R.color.menu_choose));
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		JPushInterface.onPause(this);
		MobclickAgent.onPause(this);
	}
	
	@Override
	public void responseData(Object data, int status) {

	}

	/** 对外菜单入口 */
	public void rootMenuShow(int showId) {
        productListImageView.setImageDrawable(productUnChoose);
        myInvestMenuImageView.setImageDrawable(myInvestUnChoose);
        productListMenuTv.setTextColor(getColor(R.color.menu_unchoose));
        myInvestMenuTv.setTextColor(getColor(R.color.menu_unchoose));
		fragmentTransaction = fragmentManager.beginTransaction()
				.hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
		switch (showId) {
		case R.id.ProductListFragment_button:
			fragmentTransaction.show(mFragments[0]).commit();
            productListImageView.setImageDrawable(productChoose);
            productListMenuTv.setTextColor(getColor(R.color.menu_choose));
			break;
		case R.id.InvestFragment_button:
			fragmentTransaction.show(mFragments[1]).commit();
            myInvestMenuImageView.setImageDrawable(myInvestChoose);
            myInvestMenuTv.setTextColor(getColor(R.color.menu_choose));
			break;
		case R.id.SettingsFragment_button:
			fragmentTransaction.show(mFragments[2]).commit();
			break;
		}
	}

	@Override
	public void onClick(View view) {
		rootMenuShow(view.getId());
	}
}
