package com.maxin.liang.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bilibili.bean.PersonBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/20.
 */

public class LlAdapter extends RecyclerView.Adapter<LlAdapter.MyViewHorlder> {


    private final Context context;
    private final List<PersonBean.DataBean.EntranceIconsBean> items;


    public LlAdapter(Context context, List<PersonBean.DataBean.EntranceIconsBean> entranceIcons) {
        this.context = context;
        items = entranceIcons;
    }

    @Override
    public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_ll, null);
        return new MyViewHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHorlder holder, int position) {
        Glide.with(context).load(items.get(position).getEntrance_icon().getSrc()).into(holder.ivLl);
        holder.tvLl.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    class MyViewHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_ll)
        ImageView ivLl;
        @Bind(R.id.tv_ll)
        TextView tvLl;
        public MyViewHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
