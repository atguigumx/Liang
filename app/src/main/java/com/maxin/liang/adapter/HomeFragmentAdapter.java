package com.maxin.liang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bean.HomeBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/7.
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final List<HomeBean.DataBean.ItemsBean.ListBean> items;
    private final LayoutInflater inflater;




    public HomeFragmentAdapter(Context context, List<HomeBean.DataBean.ItemsBean.ListBean> list) {
        this.context = context;
        this.items = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new OneTypeViewHolder(context, inflater.inflate(R.layout.one_homefragment, null));
        } else if (viewType == 4) {
            return new FourTypeViewHolder(context, inflater.inflate(R.layout.four_homefragment, null));
        } else if (viewType == 2) {
            return new TwoTypeViewHolder(context, inflater.inflate(R.layout.two_homefragment, null));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.ItemsBean.ListBean listBean = items.get(position);
        if (getItemViewType(position) == 1) {
            OneTypeViewHolder oneTypeViewHolder = (OneTypeViewHolder) holder;
            //设置数据
            oneTypeViewHolder.setData(listBean);
        } else if (getItemViewType(position) == 4) {
            FourTypeViewHolder fourTypeViewHolder = (FourTypeViewHolder) holder;
            //设置数据
            fourTypeViewHolder.setData(listBean);
        } else if (getItemViewType(position) == 2) {
            TwoTypeViewHolder twoTypeViewHolder = (TwoTypeViewHolder) holder;
            twoTypeViewHolder.setData(listBean);
        }
    }

    @Override
    public int getItemViewType(int position) {
        String home_type = items.get(position).getHome_type();
        int currentType = Integer.parseInt(home_type);
        return currentType;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class OneTypeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.onehomefragment_iv)
        ImageView onehomefragmentIv;
        private final Context context;
        private String topic_url;

        public OneTypeViewHolder(final Context context, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;

        }

        public void setData(HomeBean.DataBean.ItemsBean.ListBean listBean) {
            topic_url = listBean.getOne().getTopic_url();
            Glide.with(context).load(listBean.getOne().getPic_url()).into(onehomefragmentIv);
            onehomefragmentIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "点击", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    class FourTypeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.fourhome_one)
        ImageView fourhomeOne;
        @Bind(R.id.fourhome_two)
        ImageView fourhomeTwo;
        @Bind(R.id.fourhome_three)
        ImageView fourhomeThree;
        @Bind(R.id.fourhome_four)
        ImageView fourhomeFour;
        private final Context context;

        public FourTypeViewHolder(Context context, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;
        }

        public void setData(HomeBean.DataBean.ItemsBean.ListBean listBean) {
            Glide.with(context).load(listBean.getOne().getPic_url()).into(fourhomeOne);
            Glide.with(context).load(listBean.getTwo().getPic_url()).into(fourhomeTwo);
            Glide.with(context).load(listBean.getThree().getPic_url()).into(fourhomeThree);
            Glide.with(context).load(listBean.getFour().getPic_url()).into(fourhomeFour);

        }
    }

    class TwoTypeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.two_fragment_one)
        ImageView twoFragmentOne;
        @Bind(R.id.two_fragment_two)
        ImageView twoFragmentTwo;
        private final Context context;

        public TwoTypeViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this,itemView);
        }

        public void setData(HomeBean.DataBean.ItemsBean.ListBean listBean) {
            Glide.with(context).load(listBean.getOne().getPic_url()).into(twoFragmentOne);
            Glide.with(context).load(listBean.getTwo().getPic_url()).into(twoFragmentTwo);
        }
    }
}
