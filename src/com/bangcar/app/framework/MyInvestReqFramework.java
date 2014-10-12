package com.bangcar.app.framework;

import org.apache.thrift.TException;

import android.app.Activity;

import com.bangcar.app.activity.HistoryOrderActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.RootFragment.InvestFragment;
import com.bangcar.app.mapi.order.OrderListReq;
import com.bangcar.app.thrift.OrderAPI;
import com.bangcar.app.util.Global;

/**
 * 我的投资
 * @author andy
 *
 */

public class MyInvestReqFramework extends BaseClient {

	private OrderListReq req = null;
	private InvestFragment inF;

	public MyInvestReqFramework(Activity act,InvestFragment inF) {
        super(act);
        this.inF = inF;
	}

	public void execute(OrderListReq req) {
		this.req = req;
		try {
			synClient(Global.ORDERURL, "OrderAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		// TODO Auto-generated method PayAPI
		OrderAPI.Client client = (OrderAPI.Client) iface;
		return client.orderList(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
		if(act instanceof HistoryOrderActivity){
			((HistoryOrderActivity)act).responseData(data, status);
		}else{
			inF.responseData(data, status);
		}
	}
}
