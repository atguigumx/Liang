package com.maxin.liang.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shkstart on 2017/7/6.
 */

public class MGZFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TAG", "ShopFragment");
        TextView textView=new TextView(getActivity());
        textView.setText("杂志");
        textView.setTextColor(Color.BLACK);
        return textView;
    }
}
