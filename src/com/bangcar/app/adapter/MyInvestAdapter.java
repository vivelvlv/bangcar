package com.bangcar.app.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.mapi.common.KV;
import com.bangcar.app.mapi.order.UserOrder;
import com.bangcar.app.util.ViewHolder;

public class MyInvestAdapter extends YGBAdapter {

	public MyInvestAdapter(Context context, ArrayList<UserOrder> list) {
		super(context, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.adapter_my_invest, null);
		}
		TextView productNameTv = ViewHolder
				.get(convertView, R.id.productNameTv);
		TextView statusTv = ViewHolder.get(convertView, R.id.statusTv);
		TextView expireTv = ViewHolder.get(convertView, R.id.expireTv);
		TextView expire = ViewHolder.get(convertView, R.id.expire);
		LinearLayout infoLayout = ViewHolder.get(convertView, R.id.infoLayout);
		UserOrder entity = (UserOrder) list.get(position);
		productNameTv.setText(entity.productName);
		expire.setText(entity.dateItem.k);
		expireTv.setText(entity.dateItem.v);
		statusTv.setText(entity.status);
		infoLayout.removeAllViews();
		for(int i = 0;i<entity.detailItems.size();i++){
			KV kv = entity.detailItems.get(i);
			View view = inflater.inflate(R.layout.layout_invest_adapter_item, null);
			TextView key = ViewHolder.get(view, R.id.key);
			TextView value = ViewHolder.get(view, R.id.value);
			key.setText(kv.k);
			value.setText(kv.v);
			infoLayout.addView(view);
		}
		return convertView;
	}
}
