package com.bangcar.app.fragment.AccountSafeManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bangcar.app.R;
import com.bangcar.app.activity.AccountManagerActivity;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.framework.CheckAuthFramework;
import com.bangcar.app.framework.SubmitIdentityInfoFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.profile.AuthCheckResp;
import com.bangcar.app.util.Global;

/**
 * step 1: 身份认证
 * Created by 9020MT on 2014/9/24.
 */
public class NameIdentificationFragment extends BaseFragment {

    private EditText nameEv, identityCardEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        currentView = inflater.inflate(R.layout.layout_account_manager_nameidentification_fragment, null);
        nameEv = (EditText) currentView.findViewById(R.id.nameEt);
        identityCardEt = (EditText) currentView.findViewById(R.id.identityCardEt);
        return currentView;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AccountManagerActivity)baseAct).setOperateTvHandle(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.提交身份信息
                showProgressDialog("提交认证中...");
                new SubmitIdentityInfoFramework(baseAct, NameIdentificationFragment.this, nameEv.getText().toString().trim(), identityCardEt.getText().toString().trim());
            }
        });
    }


    public void responseVerifyIdentitiy(Object data, int status) {

        switch (status) {
            case Global.DATA_OK:
                //2.提交成功，在进行checkAuth查询
                new CheckAuthFramework(baseAct, NameIdentificationFragment.this, true);
                break;
            case Global.DATA_LOGICEXCEPTION:
                MApiException e = (MApiException) data;
                showToast(e.retMsg);
                cancelDialog();
                break;
            case Global.DATA_SYSTEMEXCEPTION:
                MApiException ex = (MApiException) data;
                showToast(ex.retMsg);
                cancelDialog();
                break;
        }
    }

    /**
     * 通用的账号安全返回内容
     *
     * @param data
     * @param status
     */
    public void reponseCheckAuth(Object data, int status) {
        //3.返回Auth查询结果，交给父亲Activity统一处理
        cancelDialog();
        switch (status) {
            case Global.DATA_OK:
                AuthCheckResp resp = (AuthCheckResp) data;
                ((AccountManagerActivity)baseAct).generateAuthDeal(resp);
                break;
            case Global.DATA_LOGICEXCEPTION:
                showToast(((MApiException) data).retMsg);
                break;
            case Global.DATA_SYSTEMEXCEPTION:
                showToast(((MApiException) data).retMsg);
                break;
        }
    }


    @Override
    public void onClick(View view) {

    }
}
