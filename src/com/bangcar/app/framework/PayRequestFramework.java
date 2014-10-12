package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.PayActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.pay.PayReq;
import com.bangcar.app.thrift.PayAPI;
import com.bangcar.app.util.Global;

/**
 * 支付
 * @author andy
 *
 */

public class PayRequestFramework extends BaseClient {

	private PayReq req = null;
	public PayRequestFramework(PayActivity act) {
        super(act);
	}

	public void execute(PayReq req) {
		this.req = req;
		try {
			synClient(Global.PAYURL, "PayAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		// TODO Auto-generated method PayAPI
		PayAPI.Client client = (PayAPI.Client) iface;
		return client.pay(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
        ((PayActivity)act).payResponseData(data, status);
	}

}
