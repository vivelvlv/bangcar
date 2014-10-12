package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.AccountSafeManager.AddBankCardFragment;
import com.bangcar.app.mapi.profile.CityListReq;
import com.bangcar.app.thrift.ProfileAPI;
import com.bangcar.app.util.Global;
import org.apache.thrift.TException;

/**
 * Created by 9020MT on 2014/9/29.
 */
public class GetCityListFramework extends BaseClient {
    private int provinceId;
    private AddBankCardFragment context;
    /**
     * @param act
     */
    public GetCityListFramework(Activity act,AddBankCardFragment context,int provinceId) {
        super(act);
        this.provinceId = provinceId;
        this.context = context;
        synClient(Global.PROFILE,"ProfileAPI",this);
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        ProfileAPI.Client client = (ProfileAPI.Client)iface;
        CityListReq req = new CityListReq();
        req.head = Global.getReqHead();
        req.provinceId = provinceId;
        return client.cityList(req);
    }

    @Override
    public void dealwithData(Object data, int status) {
        context.reponseCityList(data,status);
    }
}
