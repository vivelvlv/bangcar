package com.bangcar.app.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by xus5985 on 2014/7/17.
 */
public class ProductDescriptionActivity extends BaseActivity {

    private ImageView backImage;
    private TextView titleTv;
    @Override
    protected void setLayout() {
        setContentView(R.layout.layout_productdescription);
    }

    @Override
    protected void findViews() {
        backImage = (ImageView)findViewById(R.id.backImg);
        titleTv = (TextView)findViewById(R.id.titleTv);
    }

    @Override
    protected void setEvents() {
        backImage.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        titleTv.setText("基本信息");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.backImg:
                finish();
                break;
        }

    }
    
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("产品基本信息页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("产品基本信息页");
	    MobclickAgent.onPause(this);
    }
}
