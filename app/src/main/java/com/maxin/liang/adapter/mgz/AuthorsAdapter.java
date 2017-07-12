package com.maxin.liang.adapter.mgz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class AuthorsAdapter extends BaseAdapter {
    private final Context context;
    private final List<AuthorBean.DataBean.ItemsBean> items;

    public AuthorsAdapter(Context context, List<AuthorBean.DataBean.ItemsBean> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public AuthorBean.DataBean.ItemsBean getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_author, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }{
            viewHolder = (ViewHolder) view.getTag();
        }
        AuthorBean.DataBean.ItemsBean itemsBean = items.get(i);
        viewHolder.tvAuthor.setText(itemsBean.getAuthor_name());
        viewHolder.tvNote.setText(itemsBean.getNote());
        //Glide.with(context).load(itemsBean.getThumb()).into(holder.ivAuthor);

        RequestManager glideRequest;
        glideRequest = Glide.with(context);
        glideRequest.load(itemsBean.getThumb()).transform(new GlideCircleTransform(context)).into(viewHolder.ivAuthor);
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.iv_author)
        ImageView ivAuthor;
        @Bind(R.id.tv_author)
        TextView tvAuthor;
        @Bind(R.id.tv_note)
        TextView tvNote;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
