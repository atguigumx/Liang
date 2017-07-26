package com.maxin.liang.fragment.masterfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bean.master.LikeBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/8.
 */

public class LikeFragment extends Fragment {

    private Context context;
    private String url;

    @Bind(R.id.recyclerview_tuijian)
    RecyclerView recyclerviewLike;
    private TuiJianAdapter adapter;
    public static LikeFragment newInstance( String guanzhuUrl) {
        LikeFragment newFragment = new LikeFragment();
        Bundle bundle = new Bundle();
        //bundle.put("context", context);
        bundle.putString("likezhuUrl", guanzhuUrl);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args!=null) {
            url= (String) args.get("likezhuUrl");
            context=getActivity();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.fragment_tuijian, null);
        ButterKnife.bind(this, view);
        getDataFromNet(url);

        return view;
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }


        });
    }

    private void processData(String response) {
        LikeBean bean = JSONObject.parseObject(response, LikeBean.class);
        List<LikeBean.DataBean.ItemsBean.GoodsBean> goods = bean.getData().getItems().getGoods();
        if(goods!=null&&goods.size()>0) {
            adapter = new TuiJianAdapter(goods);
            recyclerviewLike.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(context, 2);
            recyclerviewLike.setLayoutManager(manager);
        }
    }

    class TuiJianAdapter extends RecyclerView.Adapter<TuiJianAdapter.MyViewHorlder> {


        private final List<LikeBean.DataBean.ItemsBean.GoodsBean> items;

        public TuiJianAdapter(List<LikeBean.DataBean.ItemsBean.GoodsBean> goods) {
            this.items=goods;
        }

        @Override
        public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.item_like, null);
            return new MyViewHorlder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHorlder holder, int position) {
            Glide.with(context).load(items.get(position).getGoods_image()).into(holder.ivItemLike);
        }

        @Override
        public int getItemCount() {
            return items==null?0:items.size();
        }

        class MyViewHorlder extends RecyclerView.ViewHolder {
            @Bind(R.id.iv_item_tuijian)
            ImageView ivItemLike;
            public MyViewHorlder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}
