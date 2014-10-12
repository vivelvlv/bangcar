package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.AccountSafeManager.AddBankCardFragment;
import com.bangcar.app.mapi.profile.BankcardAuthSubmitReq;
import com.bangcar.app.thrift.ProfileAPI;
import com.bangcar.app.util.Global;
import org.apache.thrift.TException;

/**
 * Created by 9020MT on 2014/9/30.
 */
public class bankCardAuthSubmitFramework extends BaseClient {
    private BankcardAuthSubmitReq req ;
    private AddBankCardFragment context;
    /**
     * @param act
     */
    public bankCardAuthSubmitFramework(Activity act,AddBankCardFragment context,BankcardAuthSubmitReq req) {
        super(act);
        this.req = req;
        this.context = context;
        synClient(Global.PROFILE,"ProfileAPI",this);
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        ProfileAPI.Client client = (ProfileAPI.Client)iface;
        return client.bankcardAuthSubmit(req);
    }

    @Override
    public void dealwithData(Object data, int status) {
        context.reponseBankcardAuthSubmit(data,status);
    }
}
