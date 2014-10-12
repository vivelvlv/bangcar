package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.thrift.ProductAPI;
import org.apache.thrift.TException;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.ProductDetail.ProductInfoWorkmateBuyFragment;
import com.bangcar.app.mapi.product.ProductStaffBuyReq;
import com.bangcar.app.util.Global;

/**
 * 同事买framework
 * @author andy
 *
 */

public class StaffBuyRequestFramework extends BaseClient {

	private ProductStaffBuyReq req = null;
	private ProductInfoWorkmateBuyFragment context = null;

	public StaffBuyRequestFramework(Activity act,ProductInfoWorkmateBuyFragment context) {
		super(act);
		this.context = context;
	}

	public void execute(ProductStaffBuyReq req) {
		this.req = req;
		try {
			synClient(Global.PRODUCTURL, "ProductAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		// TODO Auto-generated method stub
		ProductAPI.Client client = (ProductAPI.Client) iface;
		return client.productStaffBuy(req);
	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
		context.responseData(data, status);
	}

}
