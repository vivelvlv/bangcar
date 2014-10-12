package com.bangcar.app.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.mapi.product.ProductStaffBuyRecord;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.ViewHolder;

public class StaffBuyAdapter extends YGBAdapter {

	private final String datePattern = "yyyy-MM-dd  HH:mm:ss";

	public StaffBuyAdapter(Context context, ArrayList<?> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        TextView msgTv = null;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_staff_buy, null);
        }
        msgTv = ViewHolder.get(convertView, R.id.msgTv);
		ProductStaffBuyRecord entity = (ProductStaffBuyRecord) list
				.get(position);
		msgTv.setText(ConfigUtil.getDate(entity.payTime, datePattern)
				+ "    同事" + entity.name + "购买了此产品。");
		return convertView;
	}
}
