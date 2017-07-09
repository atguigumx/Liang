package com.maxin.liang.fragment.masterfragment;

import android.content.Context;
import android.content.Intent;
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
import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.MasterItemActivity;
import com.maxin.liang.bean.master.GuanzhuBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

import static com.maxin.liang.adapter.MasterFragmentAdapter.MASTER_ID;

/**
 * Created by shkstart on 2017/7/8.
 */

public class GuanZhuFragment extends Fragment {
    private final Context context;
    private final String url;
    @Bind(R.id.recyclerview_guanzhu)
    RecyclerView recyclerviewGuanzhu;
    private GuanZhuAdapter adapter;


    public GuanZhuFragment(Context context, String guanzhuUrl) {
        this.context = context;
        url = guanzhuUrl;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.fragment_guanzhu, null);
        ButterKnife.bind(this, view);
        getDataFromNet(url);

        return view;
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("GuanZhuFragment", "onError" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        GuanzhuBean bean = JSONObject.parseObject(response, GuanzhuBean.class);
        List<GuanzhuBean.DataBean.ItemsBean.UsersBean> users = bean.getData().getItems().getUsers();

        adapter = new GuanZhuAdapter(context, users);
        recyclerviewGuanzhu.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(context, 3);
        recyclerviewGuanzhu.setLayoutManager(manager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class GuanZhuAdapter extends RecyclerView.Adapter<GuanZhuAdapter.MyViewHorlder> {
        private final List<GuanzhuBean.DataBean.ItemsBean.UsersBean> items;
        private final Context context;

        public GuanZhuAdapter(Context context, List<GuanzhuBean.DataBean.ItemsBean.UsersBean> users) {
            this.context = context;
            this.items = users;
        }

        @Override
        public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.item_guanzhu, null);
            return new MyViewHorlder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHorlder holder, int position) {
            holder.tvItemGuanzhu.setText(items.get(position).getUser_name());
            Glide.with(context).load(items.get(position).getUser_image().getOrig()).into(holder.ivItemGuanzhu);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class MyViewHorlder extends RecyclerView.ViewHolder {
            @Bind(R.id.iv_item_guanzhu)
            ImageView ivItemGuanzhu;
            @Bind(R.id.tv_item_guanzhu)
            TextView tvItemGuanzhu;
            public MyViewHorlder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, MasterItemActivity.class);
                        intent.putExtra(MASTER_ID,items.get(getLayoutPosition()).getUser_id());
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
