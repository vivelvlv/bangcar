package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.activity.TeacherDetailActivity;
import com.bangcar.app.thrift.NotifyAPI;
import org.apache.thrift.TException;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.notify.RemindProductReq;
import com.bangcar.app.mapi.notify.RemindProductResp;
import com.bangcar.app.util.Global;

public class RemindProductFramework extends BaseClient {

    private Object context;
    private RemindProductReq req;
    
    public RemindProductFramework(Activity act,Object context,RemindProductReq req){
        super(act);
        this.context = context;
        this.req = req;
        synClient(Global.NOTIFYURL,"NotifyAPI",this);
    }
    @Override
    public Object synReqAndRes(Object iface) throws TException {
        NotifyAPI.Client client = (NotifyAPI.Client) iface;
        RemindProductResp resp = client.remindProduct(req);
        return resp;
    }

    @Override
    public void dealwithData(Object data, int status) {



    }
}
