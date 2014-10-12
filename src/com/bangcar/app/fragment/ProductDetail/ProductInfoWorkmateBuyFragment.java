package com.bangcar.app.fragment.ProductDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.adapter.StaffBuyAdapter;
import com.bangcar.app.customview.CustomListView;
import com.bangcar.app.customview.CustomListView.ICustomListViewListener;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.framework.StaffBuyRequestFramework;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.mapi.product.ProductStaffBuyRecord;
import com.bangcar.app.mapi.product.ProductStaffBuyReq;
import com.bangcar.app.mapi.product.ProductStaffBuyResp;
import com.bangcar.app.util.Global;
import com.umeng.analytics.MobclickAgent;

/**
 * 同事买
 *
 * @author andy
 */

public class ProductInfoWorkmateBuyFragment extends BaseFragment {

    private CustomListView listView = null;
    private ArrayList<ProductStaffBuyRecord> list = null;
    private int curPage = 1, totalPage = 0;
    // 是否正在请求
    private boolean isLoading = false;
    private View footerView;
    // 是否正在刷新
    private boolean isRefresh = false;
    private StaffBuyRequestFramework staffBuy = null;
    private ProductStaffBuyReq req = new ProductStaffBuyReq();
    private StaffBuyAdapter adapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        currentView = inflater.inflate(
                R.layout.layout_product_workmatebuy_sub_fragment, container);
        int pid = baseAct.getIntent().getIntExtra("pid", -1);
        staffBuy = new StaffBuyRequestFramework(baseAct,
                this);
        req.head = Global.getReqHead();
        req.pid = pid;
        findViews();
        setEvents();
        initData();
        return currentView;
    }

    private void findViews() {
        list = new ArrayList<ProductStaffBuyRecord>();
        listView = (CustomListView) currentView.findViewById(R.id.listView);
        footerView = LayoutInflater.from(baseAct).inflate(
                R.layout.layout_footerview, null);
        listView.addFooterView(footerView);
    }

    private void setEvents() {
        // 刷新
        listView.setCustomListViewListener(new ICustomListViewListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                curPage = 1;
                initData();
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
                // TODO Auto-generated method stub
                if (isLoading) {
                    return;
                }
                if (curPage >= totalPage) {
                    return;
                }
                if (firstVisibleItem + visibleItemCount == totalItemCount) {
                    curPage++;
                    initData();
                }
            }
        });
    }

    private void initData() {
        isLoading = true;
        req.page = curPage;
        staffBuy.execute(req);
        String date = new SimpleDateFormat(getResources().getString(R.string.pull_to_refresh_formatdate)).format(new Date());
        ((TextView) listView.getmHeaderTimeView()).setText(date);
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 同事买数据回调
     *
     * @param data
     * @param status
     */
    public void responseData(Object data, int status) {
        isLoading = false;
        switch (status) {
            case Global.DATA_OK:
                ProductStaffBuyResp response = (ProductStaffBuyResp) data;
                //ConfigUtil.saveSkey(response.head.skey);
                totalPage = response.totalPage;
                if (curPage >= totalPage) {
                    listView.removeFooterView(footerView);
                    if (curPage != 1) {
                        showToast("没有更多数据了");
                    }
                }
                if (isRefresh) {
                    if (list == null) {
                        list = new ArrayList<ProductStaffBuyRecord>();
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
                ArrayList<ProductStaffBuyRecord> tempList = (ArrayList<ProductStaffBuyRecord>) response.records;
                if (tempList != null && tempList.size() >= 0) { //vive empty exception
                    list.addAll(tempList);
                }
                if (adapter == null) {
                    adapter = new StaffBuyAdapter(baseAct, list);
                    listView.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
                break;
            case Global.DATA_LOGICEXCEPTION:
                MApiException e = (MApiException) data;
                //ConfigUtil.saveSkey(e.head.skey);
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
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MobclickAgent.onPageStart("同事买页");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPageEnd("同事买页");
	}
}
