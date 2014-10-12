package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.PayActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.pay.SubmitReq;
import com.bangcar.app.thrift.PayAPI;
import com.bangcar.app.util.Global;

/**
 * 支付提交请求
 * 
 * @author andy
 * 
 */

public class PaySubmitRequestFramework extends BaseClient {

	private SubmitReq req = null;

	public PaySubmitRequestFramework(PayActivity act) {
		super(act);
	}

	public void execute(SubmitReq req) {
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
		return client.submit(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
		((PayActivity) act).paySubmitResponseData(data, status);
	}

}
