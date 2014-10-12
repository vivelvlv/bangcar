package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.BaseActivity;
import com.bangcar.app.activity.FindPasswordVerifyActivity;
import com.bangcar.app.activity.RegisterTelphoneActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.user.MobileReq;
import com.bangcar.app.mapi.user.MobileResp;
import com.bangcar.app.thrift.UserAPI;
import com.bangcar.app.util.Global;

/**
 * Created by xus5985 on 2014/6/26. 本类只使用thrift的异步通信机制
 * 
 */
public class CheckRegisterInfoFramework extends BaseClient {

	String phone = "";

	public CheckRegisterInfoFramework(BaseActivity act) {
		super(act);
	}

	// 提交手机号是否已经注册过
	public void isRegister(String phone) {
		this.phone = phone;
	    synClient(Global.USERURL, "UserAPI", this);
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {

        UserAPI.Client client = (UserAPI.Client) iface;
        MobileResp is = null;
        MobileReq req = new MobileReq();

		req.head = Global.getReqHead();
		req.setMobile(phone);

		is = client.mobileExist(req);

		return is;
	}

	@Override
	public void dealwithData(Object data, int status) {
		if (act instanceof RegisterTelphoneActivity) {
			((RegisterTelphoneActivity) act).telphoneIsRegistered(data, status);
		} else if (act instanceof FindPasswordVerifyActivity) {
			((FindPasswordVerifyActivity) act).telphoneIsRegistered(data,
					status);
		}
	}
}
