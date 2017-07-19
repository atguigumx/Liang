package com.maxin.liang.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxin.liang.view.FlowLayout;


public class LayoutUtils {

    private Context mContext;

    private LayoutUtils() {
    }

    private static LayoutUtils layoutUtils = new LayoutUtils();

    public static LayoutUtils getInstance() {
        return layoutUtils;
    }

    public void init(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    public LinearLayout getLinearLayout() {
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return linearLayout;
    }

    @NonNull
    public TextView getTextView(String text) {
        TextView textView = new TextView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = AdapterUtils.dip2px(mContext, 10);
        textView.setLayoutParams(params);
        textView.setTextColor(Color.WHITE);
        textView.setText(text);
        textView.setTextSize(10);
        textView.setGravity(Gravity.CENTER);
        textView.setClickable(true);

        return textView;
    }

    public FlowLayout getFlowLayout() {
        FlowLayout flowLayout = new FlowLayout(mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = AdapterUtils.dip2px(mContext, 15);
        flowLayout.setLayoutParams(layoutParams);
        flowLayout.setHorizontal_space(AdapterUtils.dip2px(mContext, 15));
        flowLayout.setVertical_space(AdapterUtils.dip2px(mContext, 15));
        return flowLayout;
    }

}
