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

import com.alibaba.fastjson.JSON;
import com.maxin.liang.R;
import com.maxin.liang.adapter.HomeFragmentAdapter;
import com.maxin.liang.bean.HomeBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/6.
 */

public class HomeFragment extends Fragment {
    @Bind(R.id.recyclerview_home)
    RecyclerView recyclerviewHome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.home_fragment, null);
        ButterKnife.bind(this, view);
        getDataFromNet();
        return view;
    }

    private void getDataFromNet() {
        String url="http://mobile.iliangcang.com/goods/newShopHome?app_key=Android&sig=3780CB0808528F7CE99081D295EE8C0F%7C116941220826768&uid=626138098&user_token=0516ed9429352c8e1e3bd11c63ba6f54&v=1.0";
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("HomeFragment", "onError"+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
               // Log.e("HomeFragment", "HomeFragment联网成功"+ response);
                processData(response);
            }
        });
    }

    private void processData(String response) {
        HomeBean homeBean = JSON.parseObject(response, HomeBean.class);
        List<HomeBean.DataBean.ItemsBean.ListBeanX> list = homeBean.getData().getItems().getList();
        if(list !=null&& list.size()>0) {
            HomeFragmentAdapter homeFragmentAdapter = new HomeFragmentAdapter(getActivity(),list);
            recyclerviewHome.setAdapter(homeFragmentAdapter);
            GridLayoutManager manager = new GridLayoutManager(getActivity(),1);
            recyclerviewHome.setLayoutManager(manager);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
