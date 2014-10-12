package com.bangcar.app.fragment.AccountSafeManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bangcar.app.R;
import com.bangcar.app.activity.AccountManagerActivity;
import com.bangcar.app.adapter.BankListAdapter;
import com.bangcar.app.adapter.CityListAdapter;
import com.bangcar.app.adapter.ProvinceListAdapter;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.framework.CheckAuthFramework;
import com.bangcar.app.framework.GetCityListFramework;
import com.bangcar.app.framework.bankCardAuthSubmitFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.common.Bank;
import com.bangcar.app.mapi.common.KV;
import com.bangcar.app.mapi.profile.AuthCheckResp;
import com.bangcar.app.mapi.profile.BankcardAuthSubmitReq;
import com.bangcar.app.mapi.profile.CityListResp;
import com.bangcar.app.util.Global;

import java.util.ArrayList;

/**
 * step 2. 添加银行卡
 * Created by 9020MT on 2014/9/24.
 */
public class AddBankCardFragment extends BaseFragment {
    private TextView nameTv, identityCardTv;
    private AuthCheckResp authCheckResp;
    private Spinner chooseBankSp;//银行名列表
    private Spinner chooseProvinceSp; //省列表
    private Spinner chooseCitySp;//城市列表
    private ArrayList<Bank> bankList;
    private Bank choosedBank = null;
    private KV chooseProvince = null;
    private KV chooseCity = null;
    private ArrayList<KV> provinceList;
    private ArrayList<KV> cityList;
    private EditText bankCardIdEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentView = inflater.inflate(R.layout.layout_account_manager_addbankcard_fragment, null);
        nameTv = (TextView) currentView.findViewById(R.id.nameTv);
        identityCardTv = (TextView) currentView.findViewById(R.id.identityCardTv);
        chooseBankSp = (Spinner) currentView.findViewById(R.id.chooseBankSp);
        chooseProvinceSp = (Spinner) currentView.findViewById(R.id.chooseProvinceSp);
        chooseCitySp = (Spinner) currentView.findViewById(R.id.chooseCitySp);
        bankCardIdEt = (EditText) currentView.findViewById(R.id.bankCardIdEt);
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
            //activity对应的“下一步”
            @Override
            public void onClick(View view) {

                BankcardAuthSubmitReq req = new BankcardAuthSubmitReq();
                req.head = Global.getReqHead();
                req.bankId = choosedBank.bankId;
                req.cardNo = bankCardIdEt.getText().toString().trim();
                req.cityId = Integer.parseInt(chooseCity.getK());
                req.provinceId = Integer.parseInt(chooseProvince.getK());
                new bankCardAuthSubmitFramework(baseAct,AddBankCardFragment.this,req);
                showToast("add bank card");
                showProgressDialog("提交卡号中...");
            }
        });
        authCheckResp = (((AccountManagerActivity)baseAct)).getAuthCheckResp();//拿到Activity记录的authCheckResp内容
        nameTv.setText(authCheckResp.getName());
        identityCardTv.setText(authCheckResp.getIdCardNo());
        bankList = (ArrayList<Bank>) authCheckResp.getBanks();
        provinceList = (ArrayList<KV>) authCheckResp.getProvinceKVs();
        chooseBankSp.setAdapter(new BankListAdapter(baseAct, bankList));
        chooseProvinceSp.setAdapter(new ProvinceListAdapter(baseAct, provinceList));
        chooseCitySp.setVisibility(View.GONE);
        chooseBankSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                choosedBank = bankList.get(position);
                showToast(choosedBank.bankName + " - " + choosedBank.bankId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        chooseProvinceSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                chooseProvince = provinceList.get(position);
                showToast(chooseProvince.getK() + " => " + chooseProvince.getV());
                new GetCityListFramework(baseAct, AddBankCardFragment.this, Integer.parseInt(chooseProvince.getK()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void reponseCityList(Object data, int status) {
        switch (status) {
            case Global.DATA_OK:
                CityListResp resp = (CityListResp) data;
                chooseCitySp.setVisibility(View.VISIBLE);
                cityList = (ArrayList<KV>) resp.getCityKVs();
                chooseCitySp.setAdapter(new CityListAdapter(baseAct, cityList));
                chooseCitySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        chooseCity = cityList.get(position);
                        showToast(chooseCity.getK() + " => " + chooseCity.getV());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                break;
            case Global.DATA_LOGICEXCEPTION:
                showToast(((MApiException) data).retMsg);
                break;
            case Global.DATA_SYSTEMEXCEPTION:
                showToast(((MApiException) data).retMsg);
                break;
        }
    }


    public void reponseBankcardAuthSubmit(Object data, int status){
        switch (status){
            case Global.DATA_OK:
                new CheckAuthFramework(baseAct, AddBankCardFragment.this, true);
                break;
            case Global.DATA_LOGICEXCEPTION:
                cancelDialog();
                showToast(((MApiException) data).retMsg);
                break;
            case Global.DATA_SYSTEMEXCEPTION:
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
