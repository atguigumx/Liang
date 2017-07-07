package com.maxin.liang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bean.shop.GoodsListBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/6.
 */
public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.MyviewHorlder>{
    private final Context context;
    private final List<GoodsListBean.DataBean.ItemsBean> items;

    public GoodsListAdapter(Context context, List<GoodsListBean.DataBean.ItemsBean> items){
        this.context=context;
        this.items=items;
    }
    @Override
    public MyviewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_goodslist, null);
        return new MyviewHorlder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHorlder holder, int position) {
        GoodsListBean.DataBean.ItemsBean itemsBean = items.get(position);
        holder.tvLikeItemGoodslist.setText(itemsBean.getLike_count());
        Glide.with(context).load(itemsBean.getGoods_image()).into(holder.ivItemGoodslist);
        holder.tvPriceItemGoodslist.setText(itemsBean.getPrice());
        holder.tvJieshaoItemGoodslist.setText(itemsBean.getGoods_name());
        holder.tvNameItemGoodslist.setText(itemsBean.getBrand_info().getBrand_name());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyviewHorlder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_item_goodslist)
        ImageView ivItemGoodslist;
        @Bind(R.id.tv_jieshao_item_goodslist)
        TextView tvJieshaoItemGoodslist;
        @Bind(R.id.tv_name_item_goodslist)
        TextView tvNameItemGoodslist;
        @Bind(R.id.tv_like_item_goodslist)
        TextView tvLikeItemGoodslist;
        @Bind(R.id.tv_price_item_goodslist)
        TextView tvPriceItemGoodslist;

        public MyviewHorlder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
