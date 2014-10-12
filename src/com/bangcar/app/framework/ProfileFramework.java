package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.RegisterCompleteActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.profile.ProfileReq;
import com.bangcar.app.mapi.profile.ProfileResp;
import com.bangcar.app.thrift.ProfileAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/09/19.
 */
public class ProfileFramework extends BaseClient {

	private RegisterCompleteActivity act;

	public ProfileFramework(RegisterCompleteActivity act){
		super(act);
		this.act = act;
		synClient(Global.PROFILE, "ProfileAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		ProfileAPI.Client client = (ProfileAPI.Client) iface;
		ProfileReq req = new ProfileReq();
		req.head = Global.getReqHead();
		ProfileResp resp = client.profile(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {

		this.act.profileCallback(data, status);
	}
}
