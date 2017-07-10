package com.maxin.liang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.maxin.liang.R;
import com.maxin.liang.bean.share.DuanZiBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/10.
 */

public class TextAdapter extends BaseAdapter {
    private final Context context;
    private final List<DuanZiBean.ListBean.TopCommentsBean> items;

    public TextAdapter(Context context, List<DuanZiBean.ListBean.TopCommentsBean> top_comments) {
        this.context = context;
        this.items = top_comments;
    }

    @Override
    public int getCount() {
        return items.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_text, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.text.setText(items.get(i).getContent());
        viewHolder.name.setText(items.get(i).getU().getName());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.text)
        TextView text;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
