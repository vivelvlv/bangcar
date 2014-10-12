package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.FindPasswordVerifyActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.FindLoginPwdReq;
import com.bangcar.app.mapi.user.FindLoginPwdResp;
import com.bangcar.app.thrift.UserAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/9/25.
 */
public class FindLoginPwdFramework extends BaseClient {

	private String mobile; // required

	private String token; // required

	public FindLoginPwdFramework(BaseActivity act, String mobile, String token) {
		super(act);
		this.mobile = mobile;
		this.token = token;
		synClient(Global.USERURL, "UserAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		UserAPI.Client client = (UserAPI.Client) iface;

		FindLoginPwdReq req = new FindLoginPwdReq();
		req.head = Global.getReqHead();
		req.mobile = mobile;
		req.token = token;
		FindLoginPwdResp resp = client.findLoginPwd(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {
		if (act instanceof FindPasswordVerifyActivity) {
			((FindPasswordVerifyActivity) act).verifyMobileTokenCallback(data,
					status);
		}
	}
}
