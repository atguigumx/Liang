package com.maxin.liang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.bilibili.adapter.PersonAdapter;
import com.maxin.liang.bilibili.bean.PersonBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/6.
 */

public class PersonalFragment extends Fragment {
    @Bind(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_title_shopcart)
    ImageView ivTitleShopcart;
    String biliUrl = "http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b";
    @Bind(R.id.person_recyclerview)
    RecyclerView personRecyclerview;
    private PersonAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_person, null);
        ButterKnife.bind(this, view);
        tvTitle.setText("直播");
        getDataFromNet(biliUrl);
        return view;
    }

    private void getDataFromNet(String biliUrl) {
        OkHttpUtils.get().url(biliUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("PersonalFragment", "onError" + e.getMessage());
            }
            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        PersonBean personBean = JSONObject.parseObject(response, PersonBean.class);

        if (personBean.getData() != null) {
            adapter = new PersonAdapter(getActivity(), personBean);
            personRecyclerview.setAdapter(adapter);
            personRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),1));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
