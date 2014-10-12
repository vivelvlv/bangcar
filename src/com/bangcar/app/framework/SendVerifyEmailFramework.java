package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.RegisterCompleteActivity;
import com.bangcar.app.activity.RegisterEmailActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.EEmailTokenOp;
import com.bangcar.app.mapi.utility.EEmailTokenType;
import com.bangcar.app.mapi.utility.EmailTokenReq;
import com.bangcar.app.mapi.utility.EmailTokenResp;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/09/17.
 */
public class SendVerifyEmailFramework extends BaseClient {

	private String email = null;
	private EEmailTokenOp op = null;
	private RegisterEmailActivity act1 = null;
	private RegisterCompleteActivity act2 = null;

	public SendVerifyEmailFramework(BaseActivity act, String email,
			EEmailTokenOp op) {
		super(act);
		this.email = email;
		this.op = op;
		if (act instanceof RegisterEmailActivity == true) {
			this.act1 = (RegisterEmailActivity) act;
		} else if (act instanceof RegisterCompleteActivity == true) {
			this.act2 = (RegisterCompleteActivity) act;
		}
		synClient(Global.UTILITYURL, "UtilityAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		UtilityAPI.Client client = (UtilityAPI.Client) iface;
		EmailTokenReq req = new EmailTokenReq();
		req.head = Global.getReqHead();
		req.op = op;
		req.type = EEmailTokenType.REGISTER;
		req.email = email;
		EmailTokenResp resp = client.sendEmailToken(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {

		if (act1 != null) {
			act1.sendEmailTokenCallback(data, status);
		}

		if (act2 != null) {
			act2.resendEmailTokenCallback(data, status);
		}

	}
}
