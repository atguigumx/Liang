package com.maxin.liang.bilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bilibili.activity.LiveActivity;
import com.maxin.liang.bilibili.bean.PersonBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/21.
 */

public class PartitionLiveAdapter extends RecyclerView.Adapter<PartitionLiveAdapter.Viewholder> {

    public static final String LIVE = "live_url";
    private final Context context;
    private final List<PersonBean.DataBean.PartitionsBean.LivesBean> items;


    public PartitionLiveAdapter(Context context, List<PersonBean.DataBean.PartitionsBean.LivesBean> partitionsBean) {
        this.context = context;
        this.items = partitionsBean;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.live_item, null);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        PersonBean.DataBean.PartitionsBean.LivesBean livesBean = items.get(position);
        Glide.with(context).load(livesBean.getCover().getSrc()).into(holder.ivLive);
        holder.tvLiveTitle.setText(livesBean.getTitle());
        holder.tvLiveName.setText(livesBean.getOwner().getName());
        holder.tvLiveCount.setText(livesBean.getOnline()+"");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class Viewholder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_live)
        ImageView ivLive;
        @Bind(R.id.tv_live_title)
        TextView tvLiveTitle;
        @Bind(R.id.tv_live_name)
        TextView tvLiveName;
        @Bind(R.id.tv_live_count)
        TextView tvLiveCount;
        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PersonBean.DataBean.PartitionsBean.LivesBean livesBean = items.get(getLayoutPosition());
                    Intent intent = new Intent(context, LiveActivity.class);
                    intent.putExtra(LIVE,livesBean);
                    context.startActivity(intent);
                }
            });
        }
    }
}
