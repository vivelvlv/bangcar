package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.RegisterTelphoneActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.VerifyRegisterReq;
import com.bangcar.app.mapi.utility.VerifyRegisterResp;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/9/15.
 */
public class VerifyMobileTokenFramework extends BaseClient {

	private String mobile; // required

	private String token; // required

	// private EMobileTokenType type; // required

	public VerifyMobileTokenFramework(RegisterTelphoneActivity act,
			String mobile, String token) {
		super(act);
		this.mobile = mobile;
		this.token = token;
		// this.type = type;
		synClient(Global.UTILITYURL, "UtilityAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		UtilityAPI.Client client = (UtilityAPI.Client) iface;

		VerifyRegisterReq req = new VerifyRegisterReq();
		req.head = Global.getReqHead();
		req.mobile = mobile;
		req.token = token;
		// req.type = type;
		VerifyRegisterResp resp = client.VerifyRegister(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {
		((RegisterTelphoneActivity) act)
				.verifyMobileTokenCallback(data, status);
	}
}
