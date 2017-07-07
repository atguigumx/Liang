package com.maxin.liang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bean.master.MasterBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/7.
 */

public class MasterFragmentAdapter extends RecyclerView.Adapter<MasterFragmentAdapter.MyViewHorlder> {

    private final Context context;
    private final List<MasterBean.DataBean.ItemsBean> items;

    public MasterFragmentAdapter(Context context, List<MasterBean.DataBean.ItemsBean> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_masterfagment, null);
        return new MyViewHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHorlder holder, int position) {
        MasterBean.DataBean.ItemsBean itemsBean = items.get(position);
        holder.tvNameMasterfragment.setText(itemsBean.getUsername());
        holder.tvNickMasterfragment.setText(itemsBean.getDuty());
        Glide.with(context).load(itemsBean.getUser_images().getOrig()).into(holder.ivItemmasterfragment);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_itemmasterfragment)
        ImageView ivItemmasterfragment;
        @Bind(R.id.tv_name_masterfragment)
        TextView tvNameMasterfragment;
        @Bind(R.id.tv_nick_masterfragment)
        TextView tvNickMasterfragment;
        public MyViewHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
