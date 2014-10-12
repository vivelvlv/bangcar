package com.bangcar.app.activity;

import android.view.View;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.umeng.analytics.MobclickAgent;

public class HelpCenterActivity extends BaseActivity {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.cancel:
			onBackPressed();
			break;
		case R.id.accountSettingLayout:
			break;
		case R.id.buyAndPayLayout:
			break;
		case R.id.incomeLayout:
			break;
		}
	}

	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_help_center);
	}

	@Override
	protected void findViews() {
	}

	@Override
	protected void setEvents() {
		findViewById(R.id.cancel).setOnClickListener(this);
		findViewById(R.id.accountSettingLayout).setOnClickListener(this);
		findViewById(R.id.buyAndPayLayout).setOnClickListener(this);
		findViewById(R.id.incomeLayout).setOnClickListener(this);
	}
	
	protected void initDatas(){
		
	}

	public void onBackPressed() {
		this.finish();
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("帮助中心");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("帮助中心");
	    MobclickAgent.onPause(this);
    }

}
