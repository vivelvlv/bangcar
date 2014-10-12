package com.bangcar.app.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.activity.ConfirmInvestingActivity;
import com.bangcar.app.dialog.NoTradeInfoDialog;
import com.bangcar.app.framework.BuyRequestFramework;
import com.bangcar.app.framework.RemindProductFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.buy.BuyReq;
import com.bangcar.app.mapi.buy.BuyResp;
import com.bangcar.app.mapi.common.EAuthStep;
import com.bangcar.app.mapi.notify.RemindProductReq;
import com.bangcar.app.mapi.notify.RemindProductResp;
import com.bangcar.app.mapi.product.ProductListField;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.ViewHolder;

public class ProductListAdapter extends YGBAdapter {

    private Typeface rateFace;
    private boolean isRequest = false , isBuyResponse = false;
    private final int REMIND = 0, BUY = 1, SOLD = 2;
    private ProgressDialog dialog = null;
    private float floatSize, fixSize;
    private int currentPid = -1;

    @Override
    public int getCount() {
        // TODO Auto-generated method stub

        return 9;
    }

    public ProductListAdapter(Context context, ArrayList<ProductListField> list) {
        super(context, list);
        // TODO Auto-generated constructor stub
        rateFace = YGBApp.getFontType("product_rate.otf");
        dialog = new ProgressDialog(context);
        dialog.setMessage(YGBApp.getRes().getString(R.string.loading_data));
        floatSize = YGBApp.getRes().getDimension(R.dimen.float_income_size);
        fixSize = YGBApp.getRes().getDimension(R.dimen.fix_income_size);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_productlist_item,
                    null);
        }

        return convertView;
    }

    private String getHtmlCode(int value) {
        return "<font color=#f2b084>" + value + "</font>";
    }

    private String getHtmlCode(String value) {
        return "<font color=#f2b084>" + value + "</font>";
    }




    private void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
