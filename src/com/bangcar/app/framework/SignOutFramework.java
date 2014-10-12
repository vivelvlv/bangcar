package com.bangcar.app.framework;

import com.bangcar.app.fragment.RootFragment.TeacherListFragment;
import org.apache.thrift.TException;

import android.app.Activity;

import com.bangcar.app.data.BaseClient;
import com.bangcar.app.fragment.RootFragment.SettingsFragment;
import com.bangcar.app.mapi.user.SignOutReq;
import com.bangcar.app.mapi.user.SignOutResp;
import com.bangcar.app.thrift.UserAPI;
import com.bangcar.app.util.Global;

public class SignOutFramework extends BaseClient {

    private Object context;
    private SignOutReq req;

    public SignOutFramework(Activity act, Object context, SignOutReq req) {
        super(act);
        this.context = context;
        this.req = req;
        synClient(Global.USERURL, "UserAPI", this);
    }

    @Override
    public Object synReqAndRes(Object iface) throws TException {
        UserAPI.Client client = (UserAPI.Client) iface;
        SignOutResp resp = client.signOut(req);
        return resp;
    }

    @Override
    public void dealwithData(Object data, int status) {
        if (context instanceof TeacherListFragment) {
            ((TeacherListFragment) context).signOutCallback(data, status);
        }else if (context instanceof SettingsFragment) {
        	((SettingsFragment) context).signOutCallback(data, status);
        }
    }
}
