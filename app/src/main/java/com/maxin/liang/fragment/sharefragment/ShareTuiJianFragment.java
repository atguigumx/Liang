package com.maxin.liang.fragment.sharefragment;

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
import com.maxin.liang.adapter.TuiJianAdapter;
import com.maxin.liang.bean.share.TuiJianBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/10.  text video image gif
 */

public class ShareTuiJianFragment extends Fragment {
    @Bind(R.id.recyclerview_tuijian)
    RecyclerView recyclerviewTuijian;
    String url="http://s.budejie.com/topic/list/jingxuan/1/budejie-android-6.6.3/0-20.json";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.tuijian_fragment, null);
        ButterKnife.bind(this, view);
        getDataFromNet(url);
        return view;
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("ShareTuiJianFragment", "onError="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        TuiJianBean tuiJianBean = JSONObject.parseObject(response, TuiJianBean.class);
        List<TuiJianBean.ListBean> list = tuiJianBean.getList();
        if(list!=null&&list.size()>0) {
            TuiJianAdapter adapter = new TuiJianAdapter(getActivity(), list);
            recyclerviewTuijian.setAdapter(adapter);
            recyclerviewTuijian.setLayoutManager(new GridLayoutManager(getActivity(),1));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
