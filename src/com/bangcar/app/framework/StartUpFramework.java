package com.bangcar.app.framework;

import com.bangcar.app.thrift.UtilityAPI;
import org.apache.thrift.TException;

import com.bangcar.app.activity.WelcomeActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.StartUpReq;
import com.bangcar.app.mapi.utility.StartUpResp;
import com.bangcar.app.util.Global;

public class StartUpFramework extends BaseClient {

    private StartUpReq req;
    
    public StartUpFramework(WelcomeActivity act,StartUpReq req){
        super(act);
        this.req = req;
        synClient(Global.UTILITYURL,"UtilityAPI",this);
    }
    @Override
    public Object synReqAndRes(Object iface) throws TException {
        UtilityAPI.Client client = (UtilityAPI.Client) iface;
        StartUpResp resp = client.startUp(req);
        return resp;
    }

    @Override
    public void dealwithData(Object data, int status) {
        ((WelcomeActivity)act).receiveData(data,status);
    }
}
