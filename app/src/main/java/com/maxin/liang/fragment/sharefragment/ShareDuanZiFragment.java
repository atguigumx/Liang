package com.maxin.liang.fragment.sharefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.adapter.DuanZiAdapter;
import com.maxin.liang.bean.share.DuanZiBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/10.
 */

public class ShareDuanZiFragment extends Fragment {
    @Bind(R.id.recyclerview_duanzi)
    RecyclerView recyclerviewDuanzi;
    String url="http://s.budejie.com/topic/tag-topic/64/hot/budejie-android-6.6.3/0-20.json";
    private DuanZiAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.duanzi_fragment, null);
        ButterKnife.bind(this, view);
        getDataFromNet(url);
        return view;
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("ShareDuanZiFragment", "onError="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        DuanZiBean duanZiBean = JSONObject.parseObject(response, DuanZiBean.class);
        List<DuanZiBean.ListBean> items = duanZiBean.getList();
        if(items!=null&&items.size()>0) {
            adapter = new DuanZiAdapter(getActivity(), items);
            recyclerviewDuanzi.setAdapter(adapter);
            recyclerviewDuanzi.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
