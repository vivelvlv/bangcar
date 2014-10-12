package com.bangcar.app.framework;

import com.bangcar.app.thrift.UserAPI;
import org.apache.thrift.TException;

import com.bangcar.app.activity.FindGesturePasswordActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.CaptchaReq;
import com.bangcar.app.mapi.user.CaptchaResp;
import com.bangcar.app.util.Global;

public class CaptchaFindGestureFramework extends BaseClient {


	public CaptchaFindGestureFramework(FindGesturePasswordActivity act) {
        super(act);
		synClient(Global.USERURL, "UserAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
        UserAPI.Client client = (UserAPI.Client) iface;
		CaptchaReq req = new CaptchaReq();
		req.head = Global.getReqHead();
		CaptchaResp resp = client.captcha(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {
        ((FindGesturePasswordActivity)act).captchaCallback(data, status);
	}
}
