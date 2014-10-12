package com.bangcar.app.framework;

import com.bangcar.app.activity.ConfirmInvestingActivity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.buy.GetOrderIdReq;
import com.bangcar.app.thrift.BuyAPI;
import com.bangcar.app.util.Global;
import org.apache.thrift.TException;

/**
 * Created by 9020MT on 2014/9/16.
 */
public class GetOrderIdFramework extends BaseClient {

    private int pid = 0;
    private long totalPriceE6 = 0,expectIncomeE6 = 0;
    private boolean isAnonymous = false;
    public GetOrderIdFramework(ConfirmInvestingActivity act,int pid, long totalPriceE6,long expectIncomeE6,boolean isAnonymous){
        super(act);
        this.pid = pid;
        this.totalPriceE6 = totalPriceE6;//元单位->E6
        this.isAnonymous = isAnonymous;
        this.expectIncomeE6 = expectIncomeE6;//元单位->E6
        synClient(Global.BUYRUL,"BuyAPI",this);
    }
    @Override
    public Object synReqAndRes(Object iface) throws TException {
        BuyAPI.Client client = (BuyAPI.Client)iface;
        GetOrderIdReq req = new GetOrderIdReq();
        req.head = Global.getReqHead();
        req.setPid(pid);
        req.setIsAnonymous(isAnonymous);
        req.setTotalPriceE6(totalPriceE6);
        req.setExpectIncomeE6(expectIncomeE6);
        return client.getOrderId(req);
    }

    @Override
    public void dealwithData(Object data, int status) {
        ((ConfirmInvestingActivity)act).getOrderIdResponseData(data,status);
    }
}
