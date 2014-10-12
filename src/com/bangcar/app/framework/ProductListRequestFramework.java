package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.fragment.RootFragment.TeacherListFragment;
import com.bangcar.app.thrift.ProductAPI;
import org.apache.thrift.TException;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.product.ProductListReq;
import com.bangcar.app.util.Global;

public class ProductListRequestFramework extends BaseClient {

	private Object context;
	private ProductListReq paramListReq;

	public ProductListRequestFramework(Activity act,Object context) {
        super(act);
        this.context = context;
	}

	public void request(ProductListReq param) {
		try {
			this.paramListReq = param;
			synClient(Global.PRODUCTURL, "ProductAPI", this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object synReqAndRes(Object iface) throws TException {
		// TODO Auto-generated method stub
		ProductAPI.Client client = (ProductAPI.Client) iface;
		return client.productList(paramListReq);

	}

	@Override
	public void dealwithData(Object data, int status) {
		// TODO Auto-generated method stub
        if(context instanceof TeacherListFragment){
            ((TeacherListFragment)context).receiveData(data,status);
        }
	}

}
