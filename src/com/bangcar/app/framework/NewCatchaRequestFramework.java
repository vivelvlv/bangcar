package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.FindPasswordVerifyActivity;
import com.bangcar.app.activity.RegisterTelphoneActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.EMobileTokenType;
import com.bangcar.app.mapi.utility.MobileTokenReq;
import com.bangcar.app.mapi.utility.MobileTokenResp;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/9.
 */
public class NewCatchaRequestFramework extends BaseClient {
	private String phone = null;
	private EMobileTokenType type;

	public NewCatchaRequestFramework(BaseActivity act, String phone,
			EMobileTokenType type) {
		super(act);
		this.type = type;
		this.phone = phone;

		try {
			synClient(Global.UTILITYURL, "UtilityAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {

		MobileTokenReq req = new MobileTokenReq();
		req.head = Global.getReqHead();
		req.type = type;
		req.mobile = phone;
		UtilityAPI.Client client = (UtilityAPI.Client) iface;
		MobileTokenResp resp = null;
		resp = client.sendMobileToken(req);
		return resp;

	}

	@Override
	public void dealwithData(Object data, int status) {
		if (act instanceof RegisterTelphoneActivity) {
			((RegisterTelphoneActivity) act).phoneToken(data, status);
		} else if (act instanceof FindPasswordVerifyActivity) {
			((FindPasswordVerifyActivity) act).phoneToken(data, status);
		}
	}
}
