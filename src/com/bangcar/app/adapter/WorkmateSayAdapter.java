package com.bangcar.app.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bangcar.app.R;
import com.bangcar.app.mapi.product.Comment;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.ViewHolder;

public class WorkmateSayAdapter extends YGBAdapter {

	public WorkmateSayAdapter(Context context, ArrayList<?> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.adapter_post_detail, null);
		}
		Comment entity = (Comment) list.get(position);
		TextView nameTv = ViewHolder.get(convertView, R.id.nameTv);
		TextView postMsgTv = ViewHolder.get(convertView, R.id.postMsgTv);
		TextView floorTv = ViewHolder.get(convertView, R.id.floorTv);
		TextView timeTv = ViewHolder.get(convertView, R.id.timeTv);
		nameTv.setText(entity.name+"  来自:"+entity.productShortName);
		postMsgTv.setText(entity.message);
		floorTv.setText("# "+entity.position);
		timeTv.setText(ConfigUtil.getDate(entity.createTime, "yyyy/MM/dd  HH:mm:ss"));
		return convertView;
	}

}
