package com.bangcar.app.framework;

import org.apache.thrift.TException;

import android.app.Activity;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.ProductDetail.ProductInfoWorkmateSayFragment;
import com.bangcar.app.mapi.product.CommentReplyReq;
import com.bangcar.app.thrift.ProductAPI;
import com.bangcar.app.util.Global;

/**
 * @author andy 回复同事说
 */

public class TopicReplyRequestFramework extends BaseClient {

    private CommentReplyReq replyReq = null;
    private ProductInfoWorkmateSayFragment context = null;

    public TopicReplyRequestFramework(Activity act, ProductInfoWorkmateSayFragment context,
    		CommentReplyReq replyReq) {
        super(act);
        this.context = context;
        this.replyReq = replyReq;
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
        return client.commentReply(replyReq);
    }

    @Override
    public void dealwithData(Object data, int status) {
        // TODO Auto-generated method stub
        context.responseReplyData(data, status);
    }

}
