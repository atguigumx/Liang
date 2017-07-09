package com.maxin.liang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/6.
 */

public class MGZFragment extends Fragment {
    @Bind(R.id.recyclerview_mgz)
    RecyclerView recyclerviewMgz;
    String url="http://mobile.iliangcang.com/topic/magazineList?app_key=Android&author_id=1&sig=2FA0974FFF1BC3DFA562AA63C8B5A84F%7C118265010131868&v=1.0";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_mgz, null);
        ButterKnife.bind(this, view);
        getDataFromNet(url);
        return view;
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("MGZFragment", "onError"+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }


        });
    }

    private void processData(String response) {
        JSONObject.parseObject(response);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
