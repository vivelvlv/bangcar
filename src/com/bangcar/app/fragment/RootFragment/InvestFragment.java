package com.bangcar.app.fragment.RootFragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.activity.HistoryOrderActivity;
import com.bangcar.app.activity.OrderDetailActivity;
import com.bangcar.app.adapter.MyInvestAdapter;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.framework.MyInvestReqFramework;
import com.bangcar.app.framework.UnpayOrderRequestFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.common.User;
import com.bangcar.app.mapi.order.EFilterType;
import com.bangcar.app.mapi.order.OrderListReq;
import com.bangcar.app.mapi.order.OrderListResp;
import com.bangcar.app.mapi.order.UnPaidReq;
import com.bangcar.app.mapi.order.UnPaidResp;
import com.bangcar.app.mapi.order.UserOrder;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.ViewHolder;
import com.umeng.analytics.MobclickAgent;

/**
 * 我的投资Fragment，该页面有两个请求，未支付订单和投资信息及列表.
 * 
 * @author andy
 * 
 */
public class InvestFragment extends BaseFragment {

	private TextView titleTv;
	private LayoutInflater mInflater = null;
	private ListView listView = null;
	private MyInvestAdapter adapter = null;
	private OrderListReq req = null;
	private MyInvestReqFramework mrf = null;
	private TextView amountTv, incomeTv, dayTv, expireTv;
	private ArrayList<UserOrder> list = null;
	private View footerView = null;
	private boolean isLoading = false;
	private int curPage = 1;
	private int totalPage = 0;
	private TextView historyTv;
	private RelativeLayout loadingLayout;
	private UnpayOrderRequestFramework unpayReqFramework = null;
	private UnPaidReq unpayReq = null;
	private TextView unpayNoticeTv = null;
	private UnPaidResp unpayResp = null;
	private RelativeLayout noInvestLayout;
	private TextView cropInfoTv;
	private User user = null;
	private RelativeLayout recentOrderLayout = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		currentView = inflater.inflate(
				R.layout.layout_root_activity_investfragment, null);
		this.mInflater = inflater;
		mrf = new MyInvestReqFramework(baseAct, InvestFragment.this);
		list = new ArrayList<UserOrder>();
		req = new OrderListReq();
		req.head = Global.getReqHead();
		req.type = EFilterType.CURRENT;
		unpayReqFramework = new UnpayOrderRequestFramework(baseAct,
				InvestFragment.this);
		unpayReq = new UnPaidReq();
		unpayReq.head = Global.getReqHead();
		findViews();
		initDatas();
		setEvents();
		return currentView;
	}

	private void findViews() {
		user = ConfigUtil.getUser();
		footerView = mInflater.inflate(R.layout.layout_footerview, null);
		historyTv = ViewHolder.get(footerView, R.id.historyTv);
		loadingLayout = ViewHolder.get(footerView, R.id.loadingLayout);
		currentView.findViewById(R.id.backImg).setVisibility(View.GONE);
		listView = ViewHolder.get(currentView, R.id.listView);
		noInvestLayout = ViewHolder.get(currentView, R.id.noInvestLayout);
		cropInfoTv = ViewHolder.get(currentView, R.id.cropInfoTv);
		titleTv = ViewHolder.get(currentView, R.id.titleTv);
		titleTv.setText(R.string.my_invest);
		unpayNoticeTv = ViewHolder.get(currentView, R.id.unpayNoticeTv);
		View headView = mInflater.inflate(R.layout.layout_invest_list_head,
				null);
		amountTv = ViewHolder.get(headView, R.id.amountTv);
		incomeTv = ViewHolder.get(headView, R.id.incomeTv);
		recentOrderLayout = ViewHolder.get(headView, R.id.recentOrderLayout);
		dayTv = ViewHolder.get(headView, R.id.dayTv);
		expireTv = ViewHolder.get(headView, R.id.expireTv);
		listView.addHeaderView(headView);
		listView.addFooterView(footerView);
	}

	private void initDatas() {
		isLoading = true;
		req.page = curPage;
//		mrf.execute(req);
	}

	private void setEvents() {
		historyTv.setOnClickListener(this);
		unpayNoticeTv.setOnClickListener(this);
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
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if (list == null || list.size() <= 0 || position <= 0
						|| list.get(position - 1) == null) {
					return;
				}
				Intent intent = new Intent(baseAct, OrderDetailActivity.class);
				intent.putExtra("orderId", list.get(position - 1).orderId);
				startActivity(intent);
			}
		});

	}

	@Override
	public void onResume() {
		super.onResume();
		MobclickAgent.onPageStart("我的投资页");
//		unpayReqFramework.execute(unpayReq);
		if (Global.needRefreshInvest) {
			Global.needRefreshInvest = false;
			if (listView.getFooterViewsCount() > 0) {
				listView.removeFooterView(footerView);
			}
			listView.addFooterView(footerView);
			historyTv.setVisibility(View.GONE);
			loadingLayout.setVisibility(View.VISIBLE);
			if (list == null) {
				list = new ArrayList<UserOrder>();
			} else {
				list.clear();
			}
			curPage = 1;
			adapter = null;
			initDatas();
		}
	}

	/**
	 * 我的投资列表及信息返回
	 * 
	 * @param data
	 * @param status
	 */
	public void responseData(Object data, int status) {
		isLoading = false;
		switch (status) {
		case Global.DATA_OK:
			OrderListResp resp = (OrderListResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			initViewData(resp);
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			showToast(e.retMsg);
			if (listView.getFooterViewsCount() > 0) {
				listView.removeFooterView(footerView);
			}
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			if (listView.getFooterViewsCount() > 0) {
				listView.removeFooterView(footerView);
			}
			break;
		}
	}

	private void initViewData(OrderListResp resp) {
		if (resp == null) {
			return;
		}
		if (resp.page == 1) {
			// 首页会带回投资信息
			if (!resp.totalPrice.equals("0")) {
				listView.setVisibility(View.VISIBLE);
				noInvestLayout.setVisibility(View.GONE);
				cropInfoTv.setVisibility(View.GONE);
				amountTv.setText(resp.totalPrice);
				incomeTv.setText(resp.exceptIncome);
				if(resp.inRecentSettlingOrder != null){
					recentOrderLayout.setVisibility(View.VISIBLE);
					expireTv.setText("预计"
							+ resp.inRecentSettlingOrder.incomeEndTime + "到期，交易金额"
							+ resp.inRecentSettlingOrder.orderTotalPrice);
					dayTv.setText(resp.inRecentSettlingOrder.day + "");
				}else{
					recentOrderLayout.setVisibility(View.GONE);
				}
			} else {
				// 暂无投资
				listView.setVisibility(View.GONE);
				noInvestLayout.setVisibility(View.VISIBLE);
				if (resp.corpInfo != null) {
					cropInfoTv.setVisibility(View.VISIBLE);
					cropInfoTv.setText(Html
							.fromHtml("<font color=#f05141>"
									+ resp.corpInfo.userCount + "</font>位"
									+ user.corpName
									+ "的同事<br/>已累计投资<font color=#f05141>"
									+ resp.corpInfo.totalPrice
									+ "</font><br/>快去加入他们吧!"));
				}
				return;
			}
		}
		totalPage = resp.totalPage;
		list.addAll(resp.orders);
		if (curPage >= totalPage || totalPage == 0) {
			if (resp.isHaveHistoryOrder) {
				// 有历史订单
				loadingLayout.setVisibility(View.GONE);
				historyTv.setVisibility(View.VISIBLE);
			} else {
				listView.removeFooterView(footerView);
				showToast("没有更多数据了");
			}
		}
		if (adapter == null) {
			adapter = new MyInvestAdapter(baseAct, list);
			listView.setAdapter(adapter);
		} else {
			adapter.notifyDataSetChanged();
		}
	}

	/**
	 * 未支付
	 * 
	 * @param data
	 * @param status
	 */
	public void responseUnpayData(Object data, int status) {
		switch (status) {
		case Global.DATA_OK:
			unpayResp = (UnPaidResp) data;
			//ConfigUtil.saveSkey(unpayResp.head.skey);
			if (TextUtils.isEmpty(unpayResp.orderId)) {
				unpayNoticeTv.setVisibility(View.GONE);
			} else {
				unpayNoticeTv.setVisibility(View.VISIBLE);
				unpayNoticeTv.setText("您有一单" + unpayResp.productName
						+ "产品未支付,去支付");
			}
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			showToast(e.retMsg);
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			break;
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.historyTv:
			// 历史投资
			startActivity(new Intent(baseAct, HistoryOrderActivity.class));
			break;
		case R.id.unpayNoticeTv:
			if (unpayResp == null || TextUtils.isEmpty(unpayResp.orderId)) {
				unpayNoticeTv.setVisibility(View.GONE);
			} else {
				Intent intent = new Intent(baseAct, OrderDetailActivity.class);
				intent.putExtra("orderId", unpayResp.orderId);
				startActivity(intent);
			}
			break;
		}
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPageEnd("我的投资页");
	}
}
