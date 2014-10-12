package com.bangcar.app.fragment.ProductDetail;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bangcar.app.R;
import com.bangcar.app.activity.ProductDetailHtmlActivity;
import com.bangcar.app.fragment.BaseFragment;
import com.bangcar.app.mapi.common.KV;
import com.umeng.analytics.MobclickAgent;

import android.view.ViewGroup.LayoutParams;

import java.util.List;

/**
 * Created by xus5985 on 2014/6/24.
 */
public class ProductInfoFragment extends BaseFragment {

    private LinearLayout productDetailHtmlLinearLayoutView, productBaseInfoLayoutView;
    private LinearLayout htmlLayoutItem = null;
    private View divderLine = null;
    private Intent intent = null;
    private LayoutInflater inflate;

    private int product_detail_base_info_margintop;
    private int product_detail_base_info_marginright;
    private int product_detail_base_info_textsize;
    private int product_detail_base_info_textnamecolor;
    private int product_detail_base_info_textvaluecolor;
    private int product_detail_base_info_marginleft;
    private int product_detail_base_info_marginbottom;
    private int product_detail_base_info_title_minilength;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        intent = new Intent(baseAct, ProductDetailHtmlActivity.class);
        currentView = inflater.inflate(R.layout.layout_product_detail_sub_fragment, null);
        productDetailHtmlLinearLayoutView = (LinearLayout) currentView.findViewById(R.id.productDetailHtmlLinearLayoutView);
        product_detail_base_info_margintop = getResources().getDimensionPixelSize(R.dimen.product_detail_base_info_margintop);
        product_detail_base_info_marginright = getResources().getDimensionPixelOffset(R.dimen.product_detail_base_info_marginright);
        product_detail_base_info_textsize = getResources().getDimensionPixelOffset(R.dimen.product_detail_base_info_textsize);
        product_detail_base_info_textnamecolor = getResources().getColor(R.color.product_detail_base_info_textnamecolor);
        product_detail_base_info_textvaluecolor = getResources().getColor(R.color.product_detail_base_info_textvaluecolor);
        product_detail_base_info_marginleft = getResources().getDimensionPixelSize(R.dimen.product_detail_base_info_marginleft);
        product_detail_base_info_marginbottom = getResources().getDimensionPixelOffset(R.dimen.product_detail_base_info_marginbottom);
        productBaseInfoLayoutView = (LinearLayout) currentView.findViewById(R.id.productBaseInfoLayoutView);
        product_detail_base_info_title_minilength = getResources().getDimensionPixelSize(R.dimen.product_detail_base_info_title_minilength);
        inflate = inflater;
        return currentView;
    }

    @Override
    public void onClick(View view) {
    }

    //显示base内容的显示列表
    public void updateProductBaseInfo(List<KV> productDetailItemList) {

        if (!this.isAdded()) {
            return;
        }
        int index = 0;
        for (KV entry : productDetailItemList) {
            String key = entry.getK();//用于排序的key值
            String value = entry.getV();

            LinearLayout layout = new LinearLayout(baseAct);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            if (productDetailItemList.size() == index + 1) {
                params.setMargins(product_detail_base_info_marginleft, product_detail_base_info_margintop, product_detail_base_info_marginright, getResources().getDimensionPixelSize(R.dimen.product_detail_base_info_last_margintail));
            } else {
                if(index == 0){
                    params.setMargins(product_detail_base_info_marginleft, getResources().getDimensionPixelSize(R.dimen.product_detail_base_info_first_margintop), product_detail_base_info_marginright, 0);
                }else
                params.setMargins(product_detail_base_info_marginleft, product_detail_base_info_margintop, product_detail_base_info_marginright, 0);
            }
            layout.setLayoutParams(params);

            TextView textNameView = new TextView(baseAct);
            textNameView.setTextSize(TypedValue.COMPLEX_UNIT_PX, product_detail_base_info_textsize);
            LinearLayout.LayoutParams textNameViewLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT);
            textNameViewLayoutParams.weight = 2;
            textNameView.setTextColor(product_detail_base_info_textnamecolor);
            textNameView.setLayoutParams(textNameViewLayoutParams);
            textNameView.setMinWidth(product_detail_base_info_title_minilength);
            TextView textValueView = new TextView(baseAct);
            textValueView.setTextSize(TypedValue.COMPLEX_UNIT_PX, product_detail_base_info_textsize);
            LinearLayout.LayoutParams textValueViewLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT);
            textValueViewLayoutParams.weight = 4;
            textValueView.setGravity(Gravity.RIGHT);
            textValueView.setLayoutParams(textValueViewLayoutParams);
            textValueView.setTextColor(product_detail_base_info_textvaluecolor);
            layout.addView(textNameView);
            layout.addView(textValueView);
            textNameView.setText(key);
            textValueView.setText(value);
            productBaseInfoLayoutView.addView(layout);
            index++;
        }
    }


    //显示htmllist列表
    public void updateHtmlList(List<KV> htmlList, final int pid) {

        if (!this.isAdded()) {
            return;
        }
        if (pid <= 0)
            return;

        int marginSides = (int) getResources().getDimension(R.dimen.product_detail_html_list_margins_to_side);
        int marginTop = (int) getResources().getDimension(R.dimen.product_detail_html_list_height);
        int divderHeght = (int) getResources().getDimension(R.dimen.product_detail_html_list_divder_height);
        for (KV entry : htmlList) {
            final String key = entry.getK();//用于排序的key值
            final String value = entry.getV();
            htmlLayoutItem = (LinearLayout) inflate.inflate(R.layout.adatper_product_detail_html_item, null);
            TextView htmlItemName = (TextView) htmlLayoutItem.findViewById(R.id.htmlItemName);
            htmlItemName.setText(key);
            LinearLayout.LayoutParams htmlItemNameparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            htmlItemNameparams.setMargins(marginSides, marginTop, marginSides, marginTop);
            productDetailHtmlLinearLayoutView.addView(htmlLayoutItem, htmlItemNameparams);
            htmlLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra(ProductDetailHtmlActivity.HTML_REQUEST_NAME, key);
                    intent.putExtra(ProductDetailHtmlActivity.HTML_REQUEST_TYPE, value);
                    intent.putExtra(ProductDetailHtmlActivity.PIDACTION, pid);
                    startActivity(intent);
                }
            });
            divderLine = (View) inflate.inflate(R.layout.divider_line, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, divderHeght);
            productDetailHtmlLinearLayoutView.addView(divderLine, params);
        }
    }
    
    @Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MobclickAgent.onPageStart("产品详细信息页");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MobclickAgent.onPageEnd("产品详细信息页");
	}


}
