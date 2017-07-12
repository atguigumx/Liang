package com.maxin.liang.adapter.mgz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.maxin.liang.R;
import com.maxin.liang.bean.mgz.AuthorBean;
import com.maxin.liang.utils.GlideCircleTransform;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/12.
 */

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.MyViewHorlder> {
    private final Context context;
    private final List<AuthorBean.DataBean.ItemsBean> items;


    public AuthorAdapter(Context context, List<AuthorBean.DataBean.ItemsBean> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_author, null);
        return new MyViewHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHorlder holder, int position) {
        AuthorBean.DataBean.ItemsBean itemsBean = items.get(position);
        holder.tvAuthor.setText(itemsBean.getAuthor_name());
        holder.tvNote.setText(itemsBean.getNote());
        //Glide.with(context).load(itemsBean.getThumb()).into(holder.ivAuthor);

        RequestManager glideRequest;
        glideRequest = Glide.with(context);
        glideRequest.load(itemsBean.getThumb()).transform(new GlideCircleTransform(context)).into(holder.ivAuthor);
    }

    @Override
    public int getItemCount() {
        return items==null?0:items.size();
    }

    class MyViewHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_author)
        ImageView ivAuthor;
        @Bind(R.id.tv_author)
        TextView tvAuthor;
        @Bind(R.id.tv_note)
        TextView tvNote;
        public MyViewHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            if(getLayoutPosition()<11) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        }
    }
}
