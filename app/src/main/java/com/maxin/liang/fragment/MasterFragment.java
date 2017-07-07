package com.maxin.liang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxin.liang.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/6.
 */

public class MasterFragment extends Fragment {
    @Bind(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_title_shopcart)
    ImageView ivTitleShopcart;
    @Bind(R.id.recyclerview_masterfragment)
    RecyclerView recyclerviewMasterfragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_master, null);
        ButterKnife.bind(this, view);
        tvTitle.setText("达人");
        getDataFromNet();
        return view;
    }

    private void getDataFromNet() {
        String url="http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&page=1&sig=BF287AF953103F390674E73DDA18CFD8|639843030233268&v=1.0";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
