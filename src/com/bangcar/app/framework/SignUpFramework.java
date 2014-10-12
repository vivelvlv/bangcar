package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.RegisterPasswordActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.SignUpReq;
import com.bangcar.app.mapi.user.SignUpResp;
import com.bangcar.app.thrift.UserAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/9/19.
 */
public class SignUpFramework extends BaseClient {

    private String phone;
    private String password;
    private String token;

    public SignUpFramework(RegisterPasswordActivity act, String phone, String token, String password) {
        super(act);
        this.phone = phone;
        this.token = token;
        this.password = password;
        synClient(Global.USERURL, "UserAPI", this);
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        UserAPI.Client client = (UserAPI.Client) iface;
        SignUpReq req = new SignUpReq();
        req.head = Global.getReqHead();
        req.mobile = phone;
        req.token = token;
        req.password = password;
        
        SignUpResp resp = client.signUp(req);
        return resp;
    }

    @Override
    public void dealwithData(Object data, int status) {
        ((RegisterPasswordActivity)act).signUpCallback(data,status);
    }
}
