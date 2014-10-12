package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.OrderDetailActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.AgreePdfReq;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

/**
 * pdf协议下载
 * @author andy
 *
 */

public class PdfDownloadReqFramework extends BaseClient {

	private AgreePdfReq req = null;
	private OrderDetailActivity oda;

	public PdfDownloadReqFramework(OrderDetailActivity oda) {
        super(oda);
        this.oda = oda;
	}

	public void execute(AgreePdfReq req) {
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
		return client.agreePdf(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
        oda.responsePdfData(data, status);
	}
}
