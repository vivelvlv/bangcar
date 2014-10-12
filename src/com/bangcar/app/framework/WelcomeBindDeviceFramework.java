package com.bangcar.app.framework;

import org.apache.thrift.TException;

import android.app.Activity;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.notify.BindDeviceTokenReq;
import com.bangcar.app.mapi.notify.BindDeviceTokenResp;
import com.bangcar.app.thrift.NotifyAPI;
import com.bangcar.app.util.Global;

public class WelcomeBindDeviceFramework extends BaseClient {

    private BindDeviceTokenReq req;
    
    public WelcomeBindDeviceFramework(Activity act,BindDeviceTokenReq req){
        super(act);
        this.req = req;
        synClient(Global.NOTIFYURL,"NotifyAPI",this);
    }
    @Override
    public Object synReqAndRes(Object iface) throws TException {
        NotifyAPI.Client client = (NotifyAPI.Client) iface;
        BindDeviceTokenResp resp = client.bindDeviceToken(req);
        return resp;
    }

    @Override
    public void dealwithData(Object data, int status) {
    }
}
