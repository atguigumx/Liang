package com.maxin.liang.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class PersosAdapter extends BaseAdapter {
    private final Context context;
    private final List<PersonBean.DataBean.PartitionsBean> items;

    public PersosAdapter(Context context, PersonBean.DataBean data) {
        this.context = context;
        items = data.getPartitions();
    }

    @Override
    public int getCount() {
        return items==null?0:items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.person_item, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        if(items!=null&&items.size()>0) {
            Glide.with(context).load(items.get(position).getPartition().getSub_icon().getSrc()).into(holder.ivPersonItem);
            holder.tvTypePersonItem.setText(items.get(position).getPartition().getName());
            holder.tvCount.setText(items.get(position).getPartition().getCount()+"");

            PersonItemAdapter personItemAdapter = new PersonItemAdapter(context, items.get(position).getLives());
            holder.personItemRecyclerview.setAdapter(personItemAdapter);
            holder.personItemRecyclerview.setLayoutManager(new GridLayoutManager(context,2));

        }
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.iv_person_item)
        ImageView ivPersonItem;
        @Bind(R.id.tv_type_person_item)
        TextView tvTypePersonItem;
        @Bind(R.id.tv_count)
        TextView tvCount;
        @Bind(R.id.person_item_recyclerview)
        RecyclerView personItemRecyclerview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
