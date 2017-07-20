package com.maxin.liang.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bilibili.adapter.LlAdapter;
import com.maxin.liang.bilibili.adapter.PersonAdapter;
import com.maxin.liang.bilibili.bean.PersonBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

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
    @Bind(R.id.person_recyclerview)
    RecyclerView personRecyclerview;
    String biliUrl = "http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b";
    @Bind(R.id.person_banner)
    Banner personBanner;
    @Bind(R.id.ll_recyclerview)
    RecyclerView llRecyclerview;
    private PersonAdapter adapter;
    private List<String> urlList;
    private LlAdapter ladapter;

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
        urlList = new ArrayList<>();
        PersonBean personBean = JSONObject.parseObject(response, PersonBean.class);
        PersonBean.DataBean data = personBean.getData();
        if (personBean.getData() != null) {
            for (int i = 0; i < data.getBanner().size(); i++) {
                String img = data.getBanner().get(i).getImg();
                urlList.add(img);
            }
            personBanner.setImages(urlList)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load((String) path).into(imageView);
                        }
                    })
                    .start();
            ladapter=new LlAdapter(getActivity(),data.getEntranceIcons());
            llRecyclerview.setAdapter(ladapter);
            llRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

            adapter = new PersonAdapter(getActivity(), data);
            personRecyclerview.setAdapter(adapter);
            personRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
