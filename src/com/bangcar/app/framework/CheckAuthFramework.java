package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.dialog.NoTradeInfoDialog;
import com.bangcar.app.fragment.AccountSafeManager.AddBankCardFragment;
import com.bangcar.app.fragment.AccountSafeManager.NameIdentificationFragment;
import com.bangcar.app.mapi.profile.AuthCheckReq;
import com.bangcar.app.thrift.ProfileAPI;
import com.bangcar.app.util.Global;
import org.apache.thrift.TException;

/**
 * Created by 9020MT on 2014/9/28.
 */
public class CheckAuthFramework extends BaseClient {
    private Object context;

    private boolean ext;
    /**
     * @param act
     */
    public CheckAuthFramework(Activity act,Object context, boolean ext) {
        super(act);
        this.ext = ext;
        this.context = context;
        synClient(Global.PROFILE,"ProfileAPI",this);
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        ProfileAPI.Client client = (ProfileAPI.Client)iface;
        AuthCheckReq req = new AuthCheckReq();
        req.head = Global.getReqHead();
        req.ext = ext;
        return client.checkAuth(req);
    }

    @Override
    public void dealwithData(Object data, int status) {
        if(context instanceof NameIdentificationFragment)
            ((NameIdentificationFragment)context).reponseCheckAuth(data, status);
        if(context instanceof NoTradeInfoDialog){
            ((NoTradeInfoDialog)context).reponseCheckAuth(data,status);
        }
        if(context instanceof AddBankCardFragment){
            ((AddBankCardFragment)context).reponseCheckAuth(data,status);
        }
    }
}
