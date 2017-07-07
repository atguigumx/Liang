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
import com.maxin.liang.adapter.MasterFragmentAdapter;
import com.maxin.liang.bean.master.MasterBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

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
    private MasterFragmentAdapter adapter;

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
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("MasterFragment", "onError"+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        MasterBean masterBean = JSONObject.parseObject(response, MasterBean.class);
        List<MasterBean.DataBean.ItemsBean> items = masterBean.getData().getItems();
        if(items.size()>0&&items!=null) {
            adapter = new MasterFragmentAdapter(getActivity(),items);
            recyclerviewMasterfragment.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
            recyclerviewMasterfragment.setLayoutManager(manager);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
