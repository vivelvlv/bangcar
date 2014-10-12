package com.bangcar.app.dialog;

import android.content.Context;
import android.view.View;
import com.bangcar.app.R;

/**
 * Created by 9020MT on 2014/9/25.
 */
public class WaitChanceToBuyDialog extends BaseDialog {
    public WaitChanceToBuyDialog(Context context) {
        super(context);
        findViews();
    }

    @Override
    protected void findViews() {
        setContentView(R.layout.layout_wait_chance_to_buy);
        findViewById(R.id.okButton).setOnClickListener(this);
    }

    @Override
    protected void setEvents() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void responseData(Object data, int status) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.okButton:
                cancel();
                break;
        }
    }
}
