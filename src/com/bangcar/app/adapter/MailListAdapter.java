package com.bangcar.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bangcar.app.R;

import java.util.ArrayList;

/**
 * Created by xus5985 on 2014/7/2.
 */
public class MailListAdapter extends YGBAdapter {
    private int selectPostion = -1;

    public MailListAdapter(Context context,ArrayList<?> list,int selectPostion){
        super(context,list);
        this.selectPostion = selectPostion;

    }


    public MailListAdapter(Context context, ArrayList<?> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter_maillist_item, null);
        TextView text = (TextView)convertView.findViewById(R.id.mailListitem);
        text.setText(list.get(position).toString());
        return convertView;



    }
}
