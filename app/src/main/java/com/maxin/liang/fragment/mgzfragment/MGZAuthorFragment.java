package com.maxin.liang.fragment.mgzfragment;

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
import com.maxin.liang.adapter.mgz.AuthorAdapter;
import com.maxin.liang.bean.mgz.AuthorBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/12.
 */

public class MGZAuthorFragment extends Fragment {
    @Bind(R.id.recyclerview_author)
    RecyclerView recyclerviewAuthor;
    String authorUrl="http://mobile.iliangcang.com/topic/magazineAuthorList?app_key=Android&sig=2FA0974FFF1BC3DFA562AA63C8B5A84F%7C118265010131868&v=1.0";
    private AuthorAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.author_fragment, null);
        ButterKnife.bind(this, view);
        getDateFromNet();
        return view;
    }

    private void getDateFromNet() {
        OkHttpUtils.get().url(authorUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("MGZAuthorFragment", "onError="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        AuthorBean authorBean = JSONObject.parseObject(response, AuthorBean.class);
        List<AuthorBean.DataBean.ItemsBean> items = authorBean.getData().getItems();
        if(items!=null&&items.size()>0) {
            adapter = new AuthorAdapter(getActivity(), items);
            recyclerviewAuthor.setAdapter(adapter);
            recyclerviewAuthor.setLayoutManager(new GridLayoutManager(getActivity(),1));
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
