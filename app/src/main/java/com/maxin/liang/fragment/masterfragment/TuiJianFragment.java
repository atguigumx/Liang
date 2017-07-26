package com.maxin.liang.fragment.masterfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bean.master.MasterItemBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/8.
 */

public class TuiJianFragment extends Fragment {


    private MasterItemBean.DataBean.ItemsBean items;


    @Bind(R.id.recyclerview_tuijian)
    RecyclerView recyclerviewLike;
    private LikeAdapter adapter;
    private Context context;

    public static TuiJianFragment newInstance( MasterItemBean.DataBean.ItemsBean items) {
        TuiJianFragment newFragment = new TuiJianFragment();
        Bundle bundle = new Bundle();
        //bundle.put("context", context);
        bundle.putSerializable("items", items);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args!=null) {
            items= (MasterItemBean.DataBean.ItemsBean) args.get("items");
            context=getActivity();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.fragment_tuijian, null);
        ButterKnife.bind(this, view);

        adapter = new LikeAdapter();
        recyclerviewLike.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(context, 2);
        recyclerviewLike.setLayoutManager(manager);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.MyViewHorlder> {
        @Override
        public MyViewHorlder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.item_like, null);
            return new MyViewHorlder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHorlder holder, int position) {
            Glide.with(context).load(items.getGoods().get(position).getGoods_image()).into(holder.ivItemLike);
        }

        @Override
        public int getItemCount() {
            return items.getGoods()==null?0:items.getGoods().size();
        }

        class MyViewHorlder extends RecyclerView.ViewHolder {
            @Bind(R.id.iv_item_tuijian)
            ImageView ivItemLike;
            public MyViewHorlder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}
