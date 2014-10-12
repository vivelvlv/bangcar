package com.bangcar.app.framework;

import android.app.Activity;
import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.AccountSafeManager.NameIdentificationFragment;
import com.bangcar.app.mapi.profile.AuthReq;
import com.bangcar.app.thrift.ProfileAPI;
import com.bangcar.app.util.Global;
import org.apache.thrift.TException;

/**
 * Created by 9020MT on 2014/9/29.
 */
public class SubmitIdentityInfoFramework extends BaseClient {
    private NameIdentificationFragment context;
    private String name;
    private String identityId;

    /**
     * @param act
     */
    public SubmitIdentityInfoFramework(Activity act, NameIdentificationFragment context, String name, String identityId) {
        super(act);
        this.name = name;
        this.context = context;
        this.identityId = identityId;
        synClient(Global.PROFILE, "ProfileAPI", this);
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        ProfileAPI.Client client = (ProfileAPI.Client) iface;
        AuthReq req = new AuthReq();
        req.head = Global.getReqHead();
        req.name = name;
        req.idcard = identityId;
        return client.auth(req);
    }

    @Override
    public void dealwithData(Object data, int status) {
        context.responseVerifyIdentitiy(data, status);

    }
}










