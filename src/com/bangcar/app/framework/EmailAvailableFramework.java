package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.RegisterEmailActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.EmailReq;
import com.bangcar.app.mapi.user.EmailResp;
import com.bangcar.app.thrift.UserAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/9/17.
 */
public class EmailAvailableFramework extends BaseClient {
    private String email = null;

    public EmailAvailableFramework(RegisterEmailActivity act, String email) {
        super(act);
        this.email = email;
        synClient(Global.USERURL, "UserAPI", this);
    }
    @Override
    public Object synReqAndRes(Object iface) throws TException {
        UserAPI.Client client = (UserAPI.Client) iface;
        EmailReq req = new EmailReq();
        req.head = Global.getReqHead();
        req.setEmail(email);
        EmailResp resp = client.emailAvailable(req);
        return resp;
    }
    @Override
    public void dealwithData(Object data, int status) {
        ((RegisterEmailActivity) act).emailAvailableCallback(data, status);
    }
}
