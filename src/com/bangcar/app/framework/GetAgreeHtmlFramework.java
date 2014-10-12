package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.ProtocolHtmlActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.AgreeHtmlReq;
import com.bangcar.app.mapi.utility.AgreeHtmlResp;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/09/25.
 */
public class GetAgreeHtmlFramework extends BaseClient {

	private int agreeId = 0;
	
	public GetAgreeHtmlFramework(BaseActivity act, int agreeId){
		super(act);
		this.agreeId = agreeId;
		synClient(Global.UTILITYURL, "UtilityAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		UtilityAPI.Client client = (UtilityAPI.Client) iface;
		AgreeHtmlReq req = new AgreeHtmlReq();
		req.head = Global.getReqHead();
		req.agreeId = agreeId;
		AgreeHtmlResp resp = client.agreeHtml(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {

		if (act instanceof ProtocolHtmlActivity){
			((ProtocolHtmlActivity)act).agreeHtmlCallback(data, status);
		}
	}
}
