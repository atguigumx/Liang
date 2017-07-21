package com.maxin.liang.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bilibili.bean.PersonBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/20.
 */

public class PersonAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final PersonBean.DataBean items;

    private static final int TYPE_PARTITION = 2;
    private static final int TYPE_BANNER = 0;
    private static final int TYPE_LIVE_ITEM = 1;
    private static final int TYPE_ENTRANCE = 3;

    public PersonAdapter(Context context, PersonBean data) {
        this.context = context;
        items = data.getData();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER) {
            return new BannerHolder(View.inflate(context, R.layout.banner_item, null));
        } else if (viewType == TYPE_ENTRANCE) {
            return new EntranceHolder(View.inflate(context, R.layout.entrance_item, null));
        } else if (viewType == TYPE_PARTITION) {
            return new PartitionHolder(View.inflate(context, R.layout.partition_item, null));
        } else if (viewType == TYPE_LIVE_ITEM) {
            // return new LiveItemHolder(View.inflate(context, R.layout.live_item, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_BANNER) {
            BannerHolder bannerHolder = (BannerHolder) holder;
            bannerHolder.setData(items.getBanner());
        } else if (getItemViewType(position) == TYPE_ENTRANCE) {
            EntranceHolder entranceHolder = (EntranceHolder) holder;
            entranceHolder.setData();
        } else if (getItemViewType(position) == TYPE_PARTITION) {
            PartitionHolder partitionHolder = (PartitionHolder) holder;
            partitionHolder.setData(items.getPartitions());
        } /*else if (getItemViewType(position) == TYPE_LIVE_ITEM) {
            LiveItemHolder liveItemHolder = (LiveItemHolder) holder;
            liveItemHolder.setData(items.getPartitions(), position);
        }*/
    }

    @Override
    public int getItemCount() {
        return 2 + items.getPartitions().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        } else if (position == 1) {
            return TYPE_ENTRANCE;
        } else {
            return TYPE_PARTITION;
        }

    }

    /*private boolean isPartitionTitle(int pos) {
        pos -= entranceSize;
        return (pos % 5 == 0);
    }

    private int getItemPosition(int pos) {
        pos -= entranceSize;
        return pos / 5;
    }*/

    class PartitionHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_partiton_item)
        ImageView ivPartitonItem;
        @Bind(R.id.tv_type_person_item)
        TextView tvTypePersonItem;
        @Bind(R.id.tv_count)
        TextView tvCount;
        @Bind(R.id.partion_item_recyclerview)
        RecyclerView partionItemRecyclerview;
        @Bind(R.id.lartion_more)
        RelativeLayout lartionMore;
        public PartitionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setData(List<PersonBean.DataBean.PartitionsBean> partitions) {
            PersonBean.DataBean.PartitionsBean.PartitionBean partition = partitions.get(getLayoutPosition() - 2).getPartition();
            Glide.with(context).load(partition.getSub_icon().getSrc()).into(ivPartitonItem);
            tvTypePersonItem.setText(partition.getName());
            tvCount.setText(partition.getCount() + "");
            PartitionLiveAdapter adapter = new PartitionLiveAdapter(context, partitions.get(getLayoutPosition() - 2).getLives());
            partionItemRecyclerview.setAdapter(adapter);
            partionItemRecyclerview.setLayoutManager(new GridLayoutManager(context, 2));


            lartionMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    class BannerHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_live_banner)
        Banner itemLiveBanner;

        public BannerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private List list = new ArrayList();

        public void setData(List<PersonBean.DataBean.BannerBean> banner) {
            for (int i = 0; i < banner.size(); i++) {
                String img = banner.get(i).getImg();
                list.add(img);
            }
            itemLiveBanner.setImages(list)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load((String) path).into(imageView);
                        }
                    })
                    .start();
        }
    }

    class EntranceHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.entrance_guanzhu)
        LinearLayout entranceGuanzhu;
        @Bind(R.id.entrance_zhongxin)
        LinearLayout entranceZhongxin;
        @Bind(R.id.entrance_video)
        LinearLayout entranceVideo;
        @Bind(R.id.entrance_search)
        LinearLayout entranceSearch;
        @Bind(R.id.entrance_type)
        LinearLayout entranceType;

        public EntranceHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData() {

        }
    }

    /*class LiveItemHolder extends RecyclerView.ViewHolder {

        public LiveItemHolder(View itemView) {
            super(itemView);
        }

        public void setData(List<PersonBean.DataBean.PartitionsBean> partitions, int position) {

        }
    }*/
}
