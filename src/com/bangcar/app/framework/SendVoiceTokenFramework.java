package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.FindPasswordVerifyActivity;
import com.bangcar.app.activity.RegisterTelphoneActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.utility.VoiceTokenReq;
import com.bangcar.app.mapi.utility.VoiceTokenResp;
import com.bangcar.app.thrift.UtilityAPI;
import com.bangcar.app.util.Global;

/**
 * Created by lawrence on 2014/9/17.
 */
public class SendVoiceTokenFramework extends BaseClient {
	private String phone = null;
	private String token = null;

	public SendVoiceTokenFramework(BaseActivity act, String phone,
			String voiceToken) {
		super(act);
		this.phone = phone;
		this.token = voiceToken;
		synClient(Global.UTILITYURL, "UtilityAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		UtilityAPI.Client client = (UtilityAPI.Client) iface;
		VoiceTokenReq req = new VoiceTokenReq();
		req.head = Global.getReqHead();
		req.voiceMobile = phone;
		req.voiceToken = token;
		VoiceTokenResp resp = client.sendVoiceToken(req);
		return resp;
	}

	@Override
	public void dealwithData(Object data, int status) {
		if (act instanceof RegisterTelphoneActivity) {
			((RegisterTelphoneActivity) act).sendVoiceTokenCallback(data,
					status);
		} else if (act instanceof FindPasswordVerifyActivity) {
			((FindPasswordVerifyActivity) act).sendVoiceTokenCallback(data,
					status);
		}
	}
}
