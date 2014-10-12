package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.FindPasswordResetActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.ResetLoginPwdReq;
import com.bangcar.app.mapi.user.ResetLoginPwdResp;
import com.bangcar.app.thrift.UserAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/9/25.
 */
public class ResetLoginPwdFramework extends BaseClient {

	private String authCode;
	private String mobile; 
	private String newPwd;

	public ResetLoginPwdFramework(BaseActivity act, String authCode, String mobile, String newPwd) {
		super(act);
		
		this.authCode = authCode;
		this.mobile = mobile;
		this.newPwd = newPwd;
		synClient(Global.USERURL, "UserAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		UserAPI.Client client = (UserAPI.Client) iface;

		ResetLoginPwdReq req = new ResetLoginPwdReq();
		req.head = Global.getReqHead();
		req.authCode = authCode;
		req.mobile = mobile;
		req.newPassword = newPwd;
		ResetLoginPwdResp resp = client.resetLoginPwd(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {
		if (act instanceof FindPasswordResetActivity) {
			((FindPasswordResetActivity) act).resetLoginPwdCallback(data,
					status);
		}
	}
}
