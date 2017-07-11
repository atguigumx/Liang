package com.maxin.liang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxin.liang.R;
import com.maxin.liang.bean.share.InfoBean.VideoInfoBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/11.
 */

public class InfoTextAdapter extends RecyclerView.Adapter<InfoTextAdapter.MyViewHorlder> {
    private final Context context;
    private final List<VideoInfoBean.NormalBean.ListBean> items;


    public InfoTextAdapter(Context context, List<VideoInfoBean.NormalBean.ListBean> list) {
        this.context = context;
        this.items = list;
    }

    @Override
    public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_text, null);
        return new MyViewHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHorlder holder, int position) {
        VideoInfoBean.NormalBean.ListBean bean = items.get(position);
        holder.name.setText(bean.getUser().getUsername());
        holder.text.setText(bean.getContent());
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    class MyViewHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.text)
        TextView text;
        public MyViewHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
