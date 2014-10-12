package com.bangcar.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bangcar.app.R;
import com.bangcar.app.mapi.common.Bank;

import java.util.ArrayList;

/**
 * Created by 9020MT on 2014/9/29.
 */
public class BankListAdapter extends YGBAdapter {
    public BankListAdapter(Context context, ArrayList<?> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_banklist_item, null);
        TextView text = (TextView)convertView.findViewById(R.id.adapterBankListItemTv);
        text.setText(((Bank)list.get(position)).bankName);
        return convertView;
    }
}
