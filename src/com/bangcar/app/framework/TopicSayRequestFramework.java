package com.bangcar.app.framework;

import org.apache.thrift.TException;

import android.app.Activity;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.ProductDetail.ProductInfoWorkmateSayFragment;
import com.bangcar.app.mapi.product.CommentListReq;
import com.bangcar.app.thrift.ProductAPI;
import com.bangcar.app.util.Global;

/**
 * @author andy 同事说 返回帖子内容，同事说内容
 */

public class TopicSayRequestFramework extends BaseClient {

    private CommentListReq req = null;
    private ProductInfoWorkmateSayFragment context = null;

    public TopicSayRequestFramework(Activity act, ProductInfoWorkmateSayFragment context) {
        super(act);
        this.context = context;
    }

    public void execute(CommentListReq req) {
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
        return client.commentList(req);
    }

    @Override
    public void dealwithData(Object data, int status) {
        // TODO Auto-generated method stub
        context.responseData(data, status);
    }

}
