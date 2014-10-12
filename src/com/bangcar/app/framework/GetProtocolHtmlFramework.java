package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.data.BaseClient;
import org.apache.thrift.TException;

/**
 * Created by 9020MT on 2014/9/17.
 * 用户协议的显示webView
 */
public class GetProtocolHtmlFramework extends BaseClient {
    private int id;
    public GetProtocolHtmlFramework(Activity act,int id){
        super(act);
        this.id = id;
        //synClient();
    }
    @Override
    public Object synReqAndRes(Object iface) throws TException {
        //TODO :
        return null;
    }

    @Override
    public void dealwithData(Object data, int status) {

    }
}
