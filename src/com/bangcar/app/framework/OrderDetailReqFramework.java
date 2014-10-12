package com.bangcar.app.framework;

import org.apache.thrift.TException;

import com.bangcar.app.activity.OrderDetailActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.order.OrderDetailReq;
import com.bangcar.app.thrift.OrderAPI;
import com.bangcar.app.util.Global;

/**
 * 订单详情
 * @author andy
 *
 */

public class OrderDetailReqFramework extends BaseClient {

	private OrderDetailReq req = null;
	private OrderDetailActivity oda;

	public OrderDetailReqFramework(OrderDetailActivity oda) {
        super(oda);
        this.oda = oda;
	}

	public void execute(OrderDetailReq req) {
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
		return client.orderDetail(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
        oda.responseData(data, status);
	}
}
