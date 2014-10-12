package com.bangcar.app.framework;

import com.bangcar.app.activity.TeacherDetailActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.product.ProductDetailReq;
import com.bangcar.app.thrift.ProductAPI;
import com.bangcar.app.util.Global;
import org.apache.thrift.TException;

public class ProductDetailRequestFramework extends BaseClient {

    private ProductDetailReq productDetailReq = null;
    public ProductDetailRequestFramework(TeacherDetailActivity act,
                                         ProductDetailReq productDetailReq) {
        super(act);
        this.productDetailReq = productDetailReq;
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
        return client.detail(productDetailReq);
    }

    @Override
    public void dealwithData(Object data, int status) {
        // TODO Auto-generated method stub
        ((TeacherDetailActivity)act).responseData(data, status);
    }

}
