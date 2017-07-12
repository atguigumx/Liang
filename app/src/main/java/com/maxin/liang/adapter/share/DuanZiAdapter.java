package com.maxin.liang.adapter.share;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.tuijian.TuiJianTextInfoActivity;
import com.maxin.liang.bean.share.DuanZiBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.maxin.liang.R.id.listview;
import static com.maxin.liang.adapter.share.TuiJianAdapter.CONTEXT;
import static com.maxin.liang.adapter.share.TuiJianAdapter.PASSTIME;
import static com.maxin.liang.adapter.share.TuiJianAdapter.TUIJIANID;
import static com.maxin.liang.adapter.share.TuiJianAdapter.UP;

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
        final DuanZiBean.ListBean listBean = items.get(position);
        holder.tvContext.setText(listBean.getText());
        holder.tvName.setText(listBean.getU().getName());
        Glide.with(context).load(listBean.getU().getHeader().get(0)).into(holder.ivHeadpic);
        holder.tvTimeRefresh.setText(listBean.getPasstime());
        holder.tvPostsNumber.setText("" + listBean.getForward());
        holder.tvShenheCaiNumber.setText("" + listBean.getDown());
        holder.tvDownloadNumber.setText(listBean.getComment());
        holder.tvShenheDingNumber.setText(listBean.getUp());
        TextAdapter adapter = new TextAdapter(context, items.get(position).getTop_comments());
        holder.listView.setAdapter(adapter);

        setListViewHeight(holder.listView);
        adapter.notifyDataSetChanged();

        holder.llDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TuiJianTextInfoActivity.class);
                intent.putExtra(TUIJIANID,listBean.getId());
                intent.putExtra(CONTEXT,listBean.getText());
                intent.putExtra(UP,listBean.getUp());
                intent.putExtra(PASSTIME,listBean.getPasstime());
                context.startActivity(intent);
            }
        });

    }



    //为listview动态设置高度（有多少条目就显示多少条目）
    public void setListViewHeight(ListView listView) {
        //获取listView的adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        //listAdapter.getCount()返回数据项的数目
        for (int i = 0,len = listAdapter.getCount(); i < len; i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() *  (listAdapter .getCount() - 1));
        listView.setLayoutParams(params);
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
        @Bind(listview)
        ListView listView;
        public MyHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
