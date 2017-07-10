package com.maxin.liang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bean.share.DuanZiBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/10.
 */

public class DuanZiAdapter extends RecyclerView.Adapter<DuanZiAdapter.MyHorlder> {


    private final Context context;
    private final List<DuanZiBean.ListBean> items;


    public DuanZiAdapter(Context context, List<DuanZiBean.ListBean> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_duanzi, null);
        return new MyHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyHorlder holder, int position) {
        DuanZiBean.ListBean listBean = items.get(position);
        holder.tvContext.setText(listBean.getText());
        holder.tvName.setText(listBean.getU().getName());
        Glide.with(context).load(listBean.getU().getRoom_icon()).into(holder.ivHeadpic);
        holder.tvTimeRefresh.setText(listBean.getPasstime());
        holder.tvPostsNumber.setText("" + listBean.getForward());
        holder.tvShenheCaiNumber.setText("" + listBean.getDown());
        holder.tvDownloadNumber.setText(listBean.getComment());
        holder.tvShenheDingNumber.setText(listBean.getUp());

        //holder.listView.setAdapter(new TextAdapter(context,listBean.getTop_comments()));

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    class MyHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_headpic)
        ImageView ivHeadpic;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_time_refresh)
        TextView tvTimeRefresh;
        @Bind(R.id.ll_video_user_info)
        LinearLayout llVideoUserInfo;
        @Bind(R.id.tv_context)
        TextView tvContext;
        @Bind(R.id.tv_ding)
        TextView tvDing;
        @Bind(R.id.tv_shenhe_ding_number)
        TextView tvShenheDingNumber;
        @Bind(R.id.ll_ding)
        LinearLayout llDing;
        @Bind(R.id.iv_cai)
        TextView ivCai;
        @Bind(R.id.tv_shenhe_cai_number)
        TextView tvShenheCaiNumber;
        @Bind(R.id.ll_cai)
        LinearLayout llCai;
        @Bind(R.id.tv_posts_number)
        TextView tvPostsNumber;
        @Bind(R.id.ll_share)
        LinearLayout llShare;
        @Bind(R.id.tv_download_number)
        TextView tvDownloadNumber;
        @Bind(R.id.ll_download)
        LinearLayout llDownload;
        @Bind(R.id.listview)
        ListView listView;
        public MyHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
