package com.bangcar.app.framework;

import android.app.Activity;
import org.apache.thrift.TException;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.dialog.PaySureDialog;
import com.bangcar.app.mapi.pay.ResultReq;
import com.bangcar.app.thrift.PayAPI;
import com.bangcar.app.util.Global;

/**
 * @author andy 预下单framework
 */
public class PayResultRequestFramework extends BaseClient {

	private ResultReq resultReq = null;
	private PaySureDialog context = null;

	public PayResultRequestFramework(Activity act, PaySureDialog context,
			ResultReq resultReq) {
		super(act);
		this.context = context;
		this.resultReq = resultReq;
		try {
			synClient(Global.PAYURL, "PayAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		// TODO Auto-generated method stub
		PayAPI.Client client = (PayAPI.Client) iface;
		return client.result(resultReq);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
		context.responseData(data, status);
	}

}
