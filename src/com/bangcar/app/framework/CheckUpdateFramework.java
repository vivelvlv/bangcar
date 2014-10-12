package com.bangcar.app.framework;

import org.apache.thrift.TException;

import android.app.Activity;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.RootFragment.SettingsFragment;
import com.bangcar.app.mapi.utility.StartUpReq;
import com.bangcar.app.mapi.utility.StartUpResp;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

public class CheckUpdateFramework extends BaseClient {

	private Object context;

	public CheckUpdateFramework(Activity act, Object context) {
		super(act);
		this.context = context;
		synClient(Global.UTILITYURL, "UtilityAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		UtilityAPI.Client client = (UtilityAPI.Client) iface;
		StartUpReq req = new StartUpReq();
		req.head = Global.getReqHead();
		StartUpResp resp = client.startUp(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {
		((SettingsFragment) context).receiveData(data, status);
	}
}
