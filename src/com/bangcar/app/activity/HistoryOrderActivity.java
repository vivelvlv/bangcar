package com.bangcar.app.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;

import com.bangcar.app.R;
import com.bangcar.app.adapter.MyInvestAdapter;
import com.bangcar.app.framework.MyInvestReqFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.order.EFilterType;
import com.bangcar.app.mapi.order.OrderListReq;
import com.bangcar.app.mapi.order.OrderListResp;
import com.bangcar.app.mapi.order.UserOrder;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;


/**
 * 历史订单
 * @author andy
 *
 */
public class HistoryOrderActivity extends BaseActivity{

	private ListView listView = null;
	private MyInvestAdapter adapter = null;
	private View footerView = null;
	private boolean isLoading = false;
	private int curPage = 1,totalPage;
	private OrderListReq req = null;
	private MyInvestReqFramework mrf = null;
	private ProgressBar loadingBar = null;
	private ArrayList<UserOrder> list = null;
	
	@Override
	protected void setLayout() {
		setContentView(R.layout.layout_history_order);
		list = new ArrayList<UserOrder>();
		mrf = new MyInvestReqFramework(HistoryOrderActivity.this,null);
		req = new OrderListReq();
		req.head = Global.getReqHead();
		req.type = EFilterType.HISTORY;
	}

	@Override
	protected void findViews() {
		TextView title = (TextView) findViewById(R.id.titleTv);
		title.setText(R.string.history_invest);
		listView = (ListView)findViewById(R.id.listView);
		loadingBar = (ProgressBar)findViewById(R.id.loadingBar);
		listView.setVisibility(View.GONE);
		footerView = LayoutInflater.from(baseAct).inflate(R.layout.layout_footerview, null);
		listView.addFooterView(footerView);
	}

	@Override
	protected void setEvents() {
		findViewById(R.id.backImg).setOnClickListener(this);
		listView.setOnScrollListener(new AbsListView.OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				if (isLoading) {
					return;
				}
				if (curPage >= totalPage) {
					return;
				}
				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					curPage++;
					initDatas();
				}
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				if(list == null || list.size() <= 0 || list.get(position) == null){
					return;
				}
				Intent intent = new Intent(baseAct,OrderDetailActivity.class);
				intent.putExtra("orderId", list.get(position).orderId);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void initDatas() {
		isLoading = true;
		req.page = curPage;
		mrf.execute(req);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.backImg:
			baseAct.finish();
			break;
		}
	}

	public void responseData(Object data, int status) {
		isLoading = false;
		listView.setVisibility(View.VISIBLE);
		loadingBar.setVisibility(View.GONE);
		switch (status) {
		case Global.DATA_OK:
			OrderListResp resp = (OrderListResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			totalPage = resp.totalPage;
			if (curPage >= totalPage) {
				listView.removeFooterView(footerView);
				if (curPage != 1) {
					showToast("没有更多数据了");
				}
			}
			ArrayList<UserOrder> tempList = (ArrayList<UserOrder>) resp.orders;
			if (tempList == null) {
				showToast("您没有历史订单");
				return;
			}
			if (tempList.size() > 0) {
				list.addAll(tempList);
			}
			if (adapter == null) {
				adapter = new MyInvestAdapter(baseAct, list);
				listView.setAdapter(adapter);
			} else {
				adapter.notifyDataSetChanged();
			}
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			showToast(e.retMsg);
			if(listView.getFooterViewsCount() > 0){
				listView.removeFooterView(footerView);
			}
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			if(listView.getFooterViewsCount() > 0){
				listView.removeFooterView(footerView);
			}
			break;
		}
	}
	
	@Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        JPushInterface.onResume(this);
        MobclickAgent.onPageStart("历史订单页");
	    MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        JPushInterface.onPause(this);
        MobclickAgent.onPageEnd("历史订单页");
	    MobclickAgent.onPause(this);
    }

}
