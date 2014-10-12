package com.bangcar.app.fragment.AccountSafeManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bangcar.app.R;
import com.bangcar.app.fragment.BaseFragment;

/**
 * step 4. 设置银行卡密码
 * Created by 9020MT on 2014/9/24.
 */
public class SettingTradePasswordFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentView = inflater.inflate(R.layout.layout_account_manager_settingtradepassword_fragment,null);
        return currentView;
    }

    @Override
    public void onClick(View view) {

    }
}
