package com.bangcar.app.fragment.RootFragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.bangcar.app.R;
import com.bangcar.app.YGBApp;
import com.bangcar.app.activity.LoginActivity;
import com.bangcar.app.activity.TeacherDetailActivity;
import com.bangcar.app.adapter.ProductListAdapter;
import com.bangcar.app.customview.CustomListView;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.framework.SignOutFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.product.ProductListField;
import com.bangcar.app.mapi.product.ProductListReq;
import com.bangcar.app.mapi.product.ProductListResp;
import com.bangcar.app.mapi.user.SignOutReq;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by 9020MT on 2014/9/9.
 */
public class TeacherListFragment extends BaseFragment {
	private TextView titleTv;
	private ProductListReq listReq;
	private CustomListView listView = null;
	private ProductListAdapter adapter = null;
//	private ProductListRequestFramework client = null;
	private LayoutInflater inflater = null;
	private Thread refreshThread = null;
	private View footerView = null;
	private boolean isRun = false;
	private boolean isLoading = false;
	private ArrayList<ProductListField> list;
	private boolean isRefresh;
	private int curPage = 1;
	private int totalPage = 0;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (adapter == null) {
				return;
			}
			adapter.notifyDataSetChanged();
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;
		currentView = inflater.inflate(
				R.layout.layout_root_activity_teacherlistfragment, null);
		findViews(currentView);
		setEvents();
		initDatas();
		return currentView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		isRun = false;
		handler.removeCallbacksAndMessages(null);
	}

	private void findViews(View view) {
		titleTv = (TextView) view.findViewById(R.id.titleTv);
		listView = (CustomListView) view.findViewById(R.id.listView);
		list = new ArrayList<ProductListField>();
		footerView = inflater.inflate(R.layout.layout_footerview, null);
		listView.addFooterView(footerView);
		titleTv.setText("找师傅");
		listReq = new ProductListReq();
		listReq.head = Global.getReqHead();
//		client = new ProductListRequestFramework(baseAct, this);
		showProgressDialog(getStr(R.string.loading_data));
		refreshThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (isRun) {
					if (adapter == null) {
						return;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					handler.obtainMessage().sendToTarget();
				}
			}
		});

	}

	private void setEvents() {
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long l) {
				Intent intent = new Intent(baseAct, TeacherDetailActivity.class);
				startActivity(intent);
			}
		});
		// 刷新
		listView.setCustomListViewListener(new CustomListView.ICustomListViewListener() {
			@Override
			public void onRefresh() {
				isRefresh = true;
				curPage = 1;
				initDatas();
			}
		});

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
	}

	protected void initDatas() {
		isLoading = true;
		listReq.page = curPage;
//		client.request(listReq);
        ProductListResp resp  = new ProductListResp();
        resp.totalPage = 1;
        receiveData(resp,0);
	}

	public void receiveData(Object data, int status) {
		isLoading = false;
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
		switch (status) {
		case Global.DATA_OK:
			ProductListResp response = (ProductListResp) data;
//			ConfigUtil.saveRTime(response.head.time);
			// ConfigUtil.saveSkey(response.head.skey);
//			listView.SetCorpUserCountAndCorpName(response.getCorpUserCount(),
//					response.getCorpName());
			totalPage = response.totalPage;
			if (curPage >= totalPage) {
				listView.removeFooterView(footerView);
				if (curPage != 1) {
					showToast("没有更多数据了");
				}
			}
			if (isRefresh) {
				if (list == null) {
					list = new ArrayList<ProductListField>();
				} else {
					list.clear();
				}
				if (curPage < totalPage && listView.getFooterViewsCount() <= 0) {
					listView.addFooterView(footerView);
				}
				isRefresh = false;
				listView.onRefreshComplete();
				showToast("刷新成功");
			}
//			ArrayList<ProductListField> tempList = (ArrayList<ProductListField>) response
//					.getFieldList();
//			if (tempList == null) {
//				showToast("产品列表为空");
//				return;
//			}
//			if (tempList.size() > 0) {
//				list.addAll(tempList);
//			}
			if (adapter == null) {
				adapter = new ProductListAdapter(baseAct, list);
				listView.setAdapter(adapter);
				isRun = true;
//				refreshThread.start();
			} else {
				adapter.notifyDataSetChanged();
			}
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			// ConfigUtil.saveSkey(e.head.skey);
			curPage = totalPage;
			showToast(e.retMsg);
			if (listView.getFooterViewsCount() > 0) {
				listView.removeFooterView(footerView);
			}
			if (isRefresh) {
				isRefresh = false;
				listView.onRefreshComplete();
			}
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast(R.string.system_exception);
			curPage = totalPage;
			if (listView.getFooterViewsCount() > 0) {
				listView.removeFooterView(footerView);
			}
			if (isRefresh) {
				isRefresh = false;
				listView.onRefreshComplete();
			}
			break;
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case 1325:// 代码保留，为了可以直接被退出的操作代码复用9-10
			String registerId = YGBApp.getConfigSp()
					.getString("registerId", "");
			if (TextUtils.isEmpty(registerId)) {
				ConfigUtil.clearSkey();
				startActivity(new Intent(baseAct, LoginActivity.class));
				baseAct.finish();
				return;
			}
			showProgressDialog("正在退出登录...");
			SignOutReq req = new SignOutReq();
			req.head = Global.getReqHead();
			req.deviceToken = registerId;
			new SignOutFramework(baseAct, this, req);
			break;
		}
	}

	/**
	 * 退出登录回调
	 * 
	 * @param data
	 * @param status
	 */
	public void signOutCallback(Object data, int status) {
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
		switch (status) {
		case Global.DATA_OK:
			ConfigUtil.clearSkey();
			startActivity(new Intent(baseAct, LoginActivity.class));
			baseAct.finish();
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
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MobclickAgent.onPageStart("产品列表页");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPageEnd("产品列表页");
	}
}
