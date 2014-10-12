package com.bangcar.app.framework;

import com.bangcar.app.activity.ProductDetailHtmlActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.product.*;
import com.bangcar.app.thrift.ProductAPI;
import com.bangcar.app.util.Global;
import org.apache.thrift.TException;

/**
 * Created by 9020MT on 2014/8/27.
 */
public class ProductDetailHtmlFramework extends BaseClient {

    private int pid;
    private String type;
    public ProductDetailHtmlFramework(ProductDetailHtmlActivity act, int pid,String type){
        super(act);
        this.pid = pid;
        this.type = type;
        synClient(Global.PRODUCTURL,"ProductAPI",this);
    }
    @Override
    public Object synReqAndRes(Object iface) throws TException {
        ProductAPI.Client client = (ProductAPI.Client) iface;
        ProductWebViewReq req = new ProductWebViewReq();
        req.head = Global.getReqHead();
        req.pid = pid;
        req.setType(type);
       return client.productWebView(req);
    }

    @Override
    public void dealwithData(Object data, int status) {
        ((ProductDetailHtmlActivity)act).CallbackData(data,status);
    }
}
