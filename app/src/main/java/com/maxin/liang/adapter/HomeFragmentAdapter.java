package com.maxin.liang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.WebViewActivity;
import com.maxin.liang.bean.HomeBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.maxin.liang.adapter.SpecialAdapter.POSITIONURL;

/**
 * Created by shkstart on 2017/7/7.
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final LayoutInflater inflater;
    private final List<HomeBean.DataBean.ItemsBean.ListBeanX> items;



    public HomeFragmentAdapter(Context context, List<HomeBean.DataBean.ItemsBean.ListBeanX> list) {
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
        } else if (viewType == 6) {
            return new SixTypeViewHolder(context, inflater.inflate(R.layout.six_homefragment, null));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.ItemsBean.ListBeanX listBean = items.get(position);
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
        } else if (getItemViewType(position) == 6) {
            SixTypeViewHolder sixTypeViewHolder= (SixTypeViewHolder) holder;
            sixTypeViewHolder.setData(listBean);

        }
    }

    @Override
    public int getItemViewType(int position) {
        int home_type = items.get(position).getHome_type();
        int currentType = home_type;
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


        public OneTypeViewHolder(final Context context, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;

        }

        public void setData(final HomeBean.DataBean.ItemsBean.ListBeanX listBean) {
            Glide.with(context).load(listBean.getOne().getPic_url()).into(onehomefragmentIv);
            onehomefragmentIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,listBean.getOne().getTopic_url());
                    context.startActivity(intent);
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

        public void setData(final HomeBean.DataBean.ItemsBean.ListBeanX listBean) {
            Glide.with(context).load(listBean.getOne().getPic_url()).into(fourhomeOne);
            Glide.with(context).load(listBean.getTwo().getPic_url()).into(fourhomeTwo);
            Glide.with(context).load(listBean.getThree().getPic_url()).into(fourhomeThree);
            Glide.with(context).load(listBean.getFour().getPic_url()).into(fourhomeFour);
            fourhomeOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,listBean.getOne().getTopic_url());
                    context.startActivity(intent);
                }
            });
            fourhomeTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,listBean.getTwo().getTopic_url());
                    context.startActivity(intent);
                }
            });
            fourhomeThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,listBean.getThree().getTopic_url());
                    context.startActivity(intent);
                }
            });
            fourhomeFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,listBean.getFour().getTopic_url());
                    context.startActivity(intent);
                }
            });
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
            ButterKnife.bind(this, itemView);
        }

        public void setData(final HomeBean.DataBean.ItemsBean.ListBeanX listBean) {
            Glide.with(context).load(listBean.getOne().getPic_url()).into(twoFragmentOne);
            Glide.with(context).load(listBean.getTwo().getPic_url()).into(twoFragmentTwo);

            twoFragmentOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,listBean.getOne().getTopic_url());
                    context.startActivity(intent);
                }
            });
            twoFragmentTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra(POSITIONURL,listBean.getTwo().getTopic_url());
                    context.startActivity(intent);
                }
            });
        }
    }

    class SixTypeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.sixhomefragment_iv)
        ImageView sixhomefragmentIv;
        private final Context context;

        public SixTypeViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this, itemView);
        }

        public void setData(HomeBean.DataBean.ItemsBean.ListBeanX listBean) {
            Glide.with(context).load(listBean.getPic_url()).into(sixhomefragmentIv);

        }
    }
}
