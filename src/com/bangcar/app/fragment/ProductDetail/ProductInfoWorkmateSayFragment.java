package com.bangcar.app.fragment.ProductDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.adapter.WorkmateSayAdapter;
import com.bangcar.app.customview.CustomListView;
import com.bangcar.app.customview.CustomListView.ICustomListViewListener;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.framework.TopicReplyRequestFramework;
import com.bangcar.app.framework.TopicSayRequestFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.product.Comment;
import com.bangcar.app.mapi.product.CommentListReq;
import com.bangcar.app.mapi.product.CommentListResp;
import com.bangcar.app.mapi.product.CommentReplyReq;
import com.bangcar.app.mapi.product.CommentReplyResp;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * 同事说fragment 发表同事说，展示同事说
 */
public class ProductInfoWorkmateSayFragment extends BaseFragment {

	private CustomListView listView;
	private EditText replyEt;
	private ImageView sendImg;
	private CommentListResp detailResp;
	private TopicSayRequestFramework topicSay = null;
	private CommentListReq topicSayReq = null;
	private int curPage = 1;
	private int totalPage = 0;
	private boolean isLoading = false;
	private View footerView;
	private ArrayList<Comment> postList = null;
	private WorkmateSayAdapter adapter = null;
	private boolean isRefresh = false;
	private InputMethodManager imm;
	private int productId = -1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		currentView = inflater.inflate(
				R.layout.layout_product_workmatesay_sub_fragment, container);
		imm = (InputMethodManager) baseAct
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		topicSay = new TopicSayRequestFramework(baseAct, this);
		productId = baseAct.getIntent().getIntExtra("pid", -1);
		topicSayReq = new CommentListReq();
		topicSayReq.head = Global.getReqHead();
		topicSayReq.pid = productId;
		topicSayReq.page = curPage;
		findViews();
		setEvents();
		initDatas();
		return currentView;
	}

	private void findViews() {
		listView = (CustomListView) currentView.findViewById(R.id.listView);
		replyEt = (EditText) currentView.findViewById(R.id.replyEt);
		sendImg = (ImageView) currentView.findViewById(R.id.sendTv);
		postList = new ArrayList<Comment>();
		adapter = new WorkmateSayAdapter(baseAct, postList);
		footerView = LayoutInflater.from(baseAct).inflate(
				R.layout.layout_footerview, null);
		listView.addFooterView(footerView);
		listView.setAdapter(adapter);

	}

	private void setEvents() {
		sendImg.setOnClickListener(this);
		listView.setCustomListViewListener(new ICustomListViewListener() {

			@Override
			public void onRefresh() {
				isRefresh = true;
				curPage = 1;
				initDatas();
			}
		});
		listView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
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

	private void initDatas() {
		isLoading = true;
		topicSayReq.page = curPage;
		topicSay.execute(topicSayReq);
		String date = new SimpleDateFormat(getResources().getString(
				R.string.pull_to_refresh_formatdate)).format(new Date());
		((TextView) listView.getmHeaderTimeView()).setText(date);
	}

	/**
	 * 同事说返回数据
	 * 
	 * @param data
	 * @param status
	 */
	public void responseData(Object data, int status) {
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
		isLoading = false;
		switch (status) {
		case Global.DATA_OK:
			detailResp = (CommentListResp) data;
			//ConfigUtil.saveSkey(detailResp.head.skey);
			totalPage = detailResp.totalPage;
			if (curPage >= totalPage) {
				listView.removeFooterView(footerView);
				if (curPage != 1) {
					showToast("没有更多数据了");
				}
			}
			if (isRefresh) {
				if (postList == null) {
					postList = new ArrayList<Comment>();
				} else {
					postList.clear();
				}
				if (curPage < totalPage && listView.getFooterViewsCount() <= 0) {
					listView.addFooterView(footerView);
				}
				isRefresh = false;
				listView.onRefreshComplete();
				showToast("刷新成功");
			}
			ArrayList<Comment> tempList = (ArrayList<Comment>) detailResp.comments;
			if (tempList != null && tempList.size() >= 0) {
				postList.addAll(tempList);
			}
			if (adapter == null) {
				adapter = new WorkmateSayAdapter(baseAct, postList);
				listView.setAdapter(adapter);
			} else {
				adapter.notifyDataSetChanged();
			}
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			if (e.head != null)
				//ConfigUtil.saveSkey(e.head.skey);
			curPage = totalPage;
//			showToast(e.retMsg);
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

	/**
	 * 返回回复同事说response
	 * 
	 * @param data
	 * @param status
	 */
	public void responseReplyData(Object data, int status) {
		if (dialog != null && dialog.isShowing()) {
			dialog.cancel();
		}
		switch (status) {
		case Global.DATA_OK:
			replyEt.setText("");
			CommentReplyResp resp = (CommentReplyResp) data;
			//ConfigUtil.saveSkey(resp.head.skey);
			curPage = 1;
			if (postList == null) {
				postList = new ArrayList<Comment>();
			} else {
				postList.clear();
			}
			initDatas();
			if (listView.getFooterViewsCount() <= 0) {
				listView.addFooterView(footerView);
			}
			break;
		case Global.DATA_LOGICEXCEPTION:
			MApiException e = (MApiException) data;
			//ConfigUtil.saveSkey(e.head.skey);
			showToast(e.getRetMsg());
			break;
		case Global.DATA_SYSTEMEXCEPTION:
			showToast("获取失败");
			break;
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.sendTv:
			if (detailResp == null || productId == -1) {
				showToast("数据异常");
				return;
			}
			if (replyEt.getText().toString().trim().length() > 140) {
				showToast("您回复的内容过长，请限制在140个字以内");
			}
			showProgressDialog("正在发表...");
			CommentReplyReq req = new CommentReplyReq();
			req.head = Global.getReqHead();
			req.pid = productId;
			req.message = replyEt.getText().toString().trim();
			new TopicReplyRequestFramework(baseAct,
					ProductInfoWorkmateSayFragment.this, req);
			imm.hideSoftInputFromWindow(replyEt.getWindowToken(), 0);
			break;
		}
	}
	
	 @Override
		public void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			MobclickAgent.onPageStart("同事说页");
		}

		@Override
		public void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			MobclickAgent.onPageEnd("同事说页");
		}
}
