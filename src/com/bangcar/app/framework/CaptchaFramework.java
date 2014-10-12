package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.LoginActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.CaptchaReq;
import com.bangcar.app.thrift.UserAPI;
import com.bangcar.app.util.Global;

public class CaptchaFramework extends BaseClient {

	private CaptchaReq req;

	public CaptchaFramework(LoginActivity act,CaptchaReq req) {
        super(act);
		this.req = req;
		synClient(Global.USERURL, "UserAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
        UserAPI.Client client = (UserAPI.Client) iface;
		return client.captcha(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
        ((LoginActivity)act).captchaCallback(data, status);
	}
}
