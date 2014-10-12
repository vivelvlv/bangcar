package com.bangcar.app.framework;

import org.apache.thrift.TException;

import android.app.Activity;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.RootFragment.InvestFragment;
import com.bangcar.app.mapi.order.UnPaidReq;
import com.bangcar.app.thrift.OrderAPI;
import com.bangcar.app.util.Global;

/**
 * @author andy 未支付订单请求
 */
public class UnpayOrderRequestFramework extends BaseClient {

	private UnPaidReq req = null;
	private InvestFragment inf = null;

	public UnpayOrderRequestFramework(Activity act, InvestFragment inf) {
		super(act);
		this.inf = inf;
	}

	public void execute(UnPaidReq req) {
		this.req = req;
		try {
			synClient(Global.ORDERURL, "OrderAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		// TODO Auto-generated method stub
		OrderAPI.Client client = (OrderAPI.Client) iface;
		return client.checkUnPaidOrder(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
		inf.responseUnpayData(data, status);
	}

}
