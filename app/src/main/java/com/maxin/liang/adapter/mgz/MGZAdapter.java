package com.maxin.liang.adapter.mgz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.WebViewActivity;
import com.maxin.liang.bean.mgz.MGZBean;
import com.maxin.liang.utils.DateChange;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.maxin.liang.adapter.SpecialAdapter.POSITIONURL;

/**
 * Created by shkstart on 2017/7/11.
 */

public class MGZAdapter extends RecyclerView.Adapter<MGZAdapter.MyViewHorlder> {
    private final Context context;
    private final List<MGZBean> items;

    public MGZAdapter(Context context, List beans) {
        this.context = context;
        this.items = beans;
    }

    @Override
    public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_mgz, null);
        return new MyViewHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHorlder holder, int position) {
        MGZBean beans = items.get(position);
        holder.setData(beans);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
    public String getDate(int position) {
        String addtime = items.get(position).getAddtime();
        return DateChange.dateFormat(addtime.substring(5,7)) + "." + addtime.substring(8, 10);
    }

    class MyViewHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_icon)
        ImageView ivIcon;
        @Bind(R.id.tv_topic)
        TextView tvTopic;
        @Bind(R.id.tv_cart)
        TextView tvCart;
        @Bind(R.id.rl_item)
        RelativeLayout rlItem;
        @Bind(R.id.ll_mgz)
        LinearLayout llMgz;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.rl)
        RelativeLayout rl;
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

        public void setData(final MGZBean beans) {
            if (getLayoutPosition() < items.size() - 2) {
                String substring = items.get(getLayoutPosition() + 1).getAddtime();
                String date = beans.getAddtime();
                if (!substring.equals(date)) {
                    String month = date.substring(5, 7);
                    String time = DateChange.dateFormat(month) + "." + date.substring(8, 10);
                    tvTime.setVisibility(View.VISIBLE);
                    tvTime.setText("- " + time + " -");
                } else {
                    tvTime.setVisibility(View.GONE);
                }
            }
            String cover_img_new = beans.getCover_img_new();
            if (!TextUtils.isEmpty(cover_img_new)) {
                Glide.with(context).load(beans.getCover_img_new()).into(ivIcon);
            }

            tvTopic.setText(beans.getTopic_name());

            tvCart.setText("- " + beans.getCat_name() + " -");



        }
    }
}
