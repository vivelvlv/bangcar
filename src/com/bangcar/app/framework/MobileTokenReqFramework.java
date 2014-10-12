package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.PayActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.MobileTokenReq;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

/**
 * 短信验证码
 * @author andy
 *
 */

public class MobileTokenReqFramework extends BaseClient {

	private MobileTokenReq req = null;

	public MobileTokenReqFramework(PayActivity act) {
        super(act);
	}

	public void execute(MobileTokenReq req) {
		this.req = req;
		try {
			synClient(Global.UTILITYURL, "UtilityAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		// TODO Auto-generated method PayAPI
		UtilityAPI.Client client = (UtilityAPI.Client) iface;
		return client.sendMobileToken(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
        ((PayActivity)act).mobileTokenResponseData(data, status);
	}

}
