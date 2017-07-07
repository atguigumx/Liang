package com.maxin.liang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.WebViewActivity;
import com.maxin.liang.bean.shop.SpecialBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/7.
 */

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.MyViewHorlder> {
    public static final String POSITIONURL = "position_url";
    private final Context context;
    private final List<SpecialBean.DataBean.ItemsBean> items;

    public SpecialAdapter(Context context, List<SpecialBean.DataBean.ItemsBean> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_special, null);
        return new MyViewHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHorlder holder, int position) {
        holder.tvItemSpecial.setText(items.get(position).getTopic_name());
        Glide.with(context).load(items.get(position).getCover_img()).into(holder.ivItemSpecial);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_item_special)
        ImageView ivItemSpecial;
        @Bind(R.id.tv_item_special)
        TextView tvItemSpecial;

        public MyViewHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,items.get(getLayoutPosition()).getTopic_url());
                    context.startActivity(intent);
                }
            });
        }
    }
}
