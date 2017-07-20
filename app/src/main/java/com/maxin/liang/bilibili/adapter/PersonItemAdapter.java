package com.maxin.liang.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.maxin.liang.R;
import com.maxin.liang.bilibili.bean.PersonBean;

import java.util.List;

/**
 * Created by shkstart on 2017/7/20.
 */

public class PersonItemAdapter extends RecyclerView.Adapter<PersonItemAdapter.MyViewHolder> {
    private final Context context;
    private final List<PersonBean.DataBean.PartitionsBean.LivesBean> items;

    public PersonItemAdapter(Context context, List<PersonBean.DataBean.PartitionsBean.LivesBean> lives) {
        this.context=context;
        items=lives;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_play,null);
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
