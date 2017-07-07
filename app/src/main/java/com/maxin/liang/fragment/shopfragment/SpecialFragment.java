package com.maxin.liang.fragment.shopfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.adapter.SpecialAdapter;
import com.maxin.liang.bean.shop.SpecialBean;
import com.maxin.liang.utils.NetConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/6.
 */

public class SpecialFragment extends Fragment {

    @Bind(R.id.recyclerView_specialfragment)
    RecyclerView recyclerViewSpecialfragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.special_fragment, null);
        ButterKnife.bind(this, view);
        getDataFromNet();
        return view;
    }

    private void getDataFromNet() {
        OkHttpUtils.get().url(NetConfig.TOPIC_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("SpecialFragment", "onError" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        SpecialBean specialBean = JSONObject.parseObject(response, SpecialBean.class);
        List<SpecialBean.DataBean.ItemsBean> items = specialBean.getData().getItems();
        if (items != null && items.size() > 0) {
            SpecialAdapter adapter = new SpecialAdapter(getActivity(), items);
            recyclerViewSpecialfragment.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
            recyclerViewSpecialfragment.setLayoutManager(manager);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
