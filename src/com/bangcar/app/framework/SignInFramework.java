package com.bangcar.app.framework;

import com.bangcar.app.thrift.UserAPI;
import org.apache.thrift.TException;

import com.bangcar.app.activity.LoginActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.SignInReq;
import com.bangcar.app.mapi.user.SignInResp;
import com.bangcar.app.util.Global;

/**
 * Created by xus5985 on 2014/7/23.
 */
public class SignInFramework extends BaseClient {

    private SignInReq req;

    public SignInFramework(LoginActivity act, SignInReq req) {
        super(act);
        this.req = req;
        synClient(Global.USERURL, "UserAPI", this);
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        UserAPI.Client client = (UserAPI.Client) iface;
        SignInResp resp = client.signIn(req);
        return resp;
    }

    @Override
    public void dealwithData(Object data, int status) {
        ((LoginActivity)act).loginCallback(data, status);
    }
}
