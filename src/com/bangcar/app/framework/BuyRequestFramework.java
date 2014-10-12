package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.activity.ConfirmInvestingActivity;
import com.bangcar.app.activity.TeacherDetailActivity;
import org.apache.thrift.TException;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.mapi.buy.BuyReq;
import com.bangcar.app.thrift.BuyAPI;
import com.bangcar.app.util.Global;

/**
 * @author andy
 *         购买
 */

public class BuyRequestFramework extends BaseClient {

    private BuyReq buyReq = null;
    private Object context = null;

    public BuyRequestFramework(Activity act, Object context,
                               BuyReq buyReq) {
        super(act);
        this.buyReq = buyReq;
        this.context = context;
        try {
            synClient(Global.BUYRUL, "BuyAPI", this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        // TODO Auto-generated method stub
        BuyAPI.Client client = (BuyAPI.Client) iface;
        return client.buy(buyReq);
    }

    @Override
    public void dealwithData(Object data, int status) {

        if(context instanceof ConfirmInvestingActivity){
            ((ConfirmInvestingActivity) context).buyResponse(data, status);
        }

    }

}
