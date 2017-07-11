package com.maxin.liang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.tuijian.TuiJianImageInfoActivity;
import com.maxin.liang.activity.tuijian.TuiJianTextInfoActivity;
import com.maxin.liang.activity.tuijian.TuiJianVideoInfoActivity;
import com.maxin.liang.bean.share.TuiJianBean;
import com.maxin.liang.utils.TimeUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by shkstart on 2017/7/10.
 */

public class TuiJianAdapter extends RecyclerView.Adapter {
    public static final String TUIJIANID = "tuijian_id";
    public static final String VIDEOURL = "video_url";
    public static final String PLAYCOUNT = "play_count";
    public static final String UP = "up";
    public static final String PASSTIME = "passtime";
    public static final String CONTEXT = "context";
    private final Context context;
    private final List<TuiJianBean.ListBean> items;
    private final LayoutInflater inflater;



    public TuiJianAdapter(Context context, List<TuiJianBean.ListBean> list) {
        this.context = context;
        this.items = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new TextViewHolder(context, inflater.inflate(R.layout.item_duanzi, null));
        } else if (viewType == 2) {
            return new ImageViewHolder(context, inflater.inflate(R.layout.item_image, null));
        } else if (viewType == 3) {
            return new GifViewHolder(context, inflater.inflate(R.layout.item_gif, null));
        } else if (viewType == 4) {
            return new VideoViewHolder(context, inflater.inflate(R.layout.item_video, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TuiJianBean.ListBean listBean = items.get(position);

        if (getItemViewType(position) == 1) {
            TextViewHolder textViewHolder = (TextViewHolder) holder;
            textViewHolder.setData(listBean);
        } else if (getItemViewType(position) == 2) {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            imageViewHolder.setData(listBean);
        } else if (getItemViewType(position) == 3) {
            GifViewHolder gifViewHolder = (GifViewHolder) holder;
            gifViewHolder.setData(listBean);
        } else if (getItemViewType(position) == 4) {
            VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
            videoViewHolder.setData(listBean);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    int itemViewType = 0;

    @Override
    public int getItemViewType(int position) {
        String type = items.get(position).getType();
        if ("video".equals(type)) {
            itemViewType = 4;
        } else if ("image".equals(type)) {
            itemViewType = 2;
        } else if ("text".equals(type)) {
            itemViewType = 1;
        } else if ("gif".equals(type)) {
            itemViewType = 3;
        }
        return itemViewType;
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_headpic)
        ImageView ivHeadpic;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_time_refresh)
        TextView tvTimeRefresh;
        @Bind(R.id.ll_video_user_info)
        LinearLayout llVideoUserInfo;
        @Bind(R.id.tv_context)
        TextView tvContext;
        @Bind(R.id.tv_ding)
        TextView tvDing;
        @Bind(R.id.tv_shenhe_ding_number)
        TextView tvShenheDingNumber;
        @Bind(R.id.ll_ding)
        LinearLayout llDing;
        @Bind(R.id.iv_cai)
        TextView ivCai;
        @Bind(R.id.tv_shenhe_cai_number)
        TextView tvShenheCaiNumber;
        @Bind(R.id.ll_cai)
        LinearLayout llCai;
        @Bind(R.id.tv_posts_number)
        TextView tvPostsNumber;
        @Bind(R.id.ll_share)
        LinearLayout llShare;
        @Bind(R.id.tv_download_number)
        TextView tvDownloadNumber;
        @Bind(R.id.ll_download)
        LinearLayout llDownload;
        @Bind(R.id.listview)
        ListView listview;
        private final Context context;

        public TextViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this, itemView);
        }
        private void initListener(final TuiJianBean.ListBean listBean) {
            llDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TuiJianTextInfoActivity.class);
                    intent.putExtra(TUIJIANID,listBean.getId());
                    intent.putExtra(CONTEXT,listBean.getText());
                    intent.putExtra(UP,listBean.getUp());
                    intent.putExtra(PASSTIME,listBean.getPasstime());
                    context.startActivity(intent);
                }
            });
        }
        public void setData(TuiJianBean.ListBean listBean) {
            tvContext.setText(listBean.getText());
            tvName.setText(listBean.getU().getName());
            Glide.with(context).load(listBean.getU().getHeader().get(0)).into(ivHeadpic);
            tvTimeRefresh.setText(listBean.getPasstime());
            tvPostsNumber.setText("" + listBean.getForward());
            tvShenheCaiNumber.setText("" + listBean.getDown());
            tvDownloadNumber.setText(listBean.getComment());
            tvShenheDingNumber.setText(listBean.getUp());

            initListener(listBean);
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private final Context context;
        @Bind(R.id.iv_headpic)
        ImageView ivHeadpic;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_time_refresh)
        TextView tvTimeRefresh;
        @Bind(R.id.ll_video_user_info)
        LinearLayout llVideoUserInfo;
        @Bind(R.id.tv_context)
        TextView tvContext;
        @Bind(R.id.iv_image_icon)
        PhotoView ivImageIcon;
        @Bind(R.id.tv_ding)
        TextView tvDing;
        @Bind(R.id.tv_shenhe_ding_number)
        TextView tvShenheDingNumber;
        @Bind(R.id.ll_ding)
        LinearLayout llDing;
        @Bind(R.id.iv_cai)
        TextView ivCai;
        @Bind(R.id.tv_shenhe_cai_number)
        TextView tvShenheCaiNumber;
        @Bind(R.id.ll_cai)
        LinearLayout llCai;
        @Bind(R.id.tv_posts_number)
        TextView tvPostsNumber;
        @Bind(R.id.ll_share)
        LinearLayout llShare;
        @Bind(R.id.tv_download_number)
        TextView tvDownloadNumber;
        @Bind(R.id.ll_download)
        LinearLayout llDownload;

        public ImageViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this, itemView);
        }
        private void initListener(final TuiJianBean.ListBean listBean) {
            llDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TuiJianImageInfoActivity.class);
                    intent.putExtra(TUIJIANID,listBean.getId());
                    intent.putExtra(CONTEXT,listBean.getText());
                    intent.putExtra(VIDEOURL,listBean.getImage().getDownload_url().get(0));
                    intent.putExtra(UP,listBean.getUp());
                    intent.putExtra(PASSTIME,listBean.getPasstime());
                    context.startActivity(intent);
                }
            });
        }

        public void setData(TuiJianBean.ListBean listBean) {
            Glide.with(context).load(listBean.getU().getHeader().get(0)).into(ivHeadpic);
            tvName.setText(listBean.getU().getName());
            tvTimeRefresh.setText(listBean.getPasstime());
            tvContext.setText(listBean.getText());
//            Glide.with(context).load(listBean.getImage().getDownload_url().get(0)).into(ivImageIcon);
            ImageLoader loader = ImageLoader.getInstance();
            loader.displayImage(listBean.getImage().getDownload_url().get(0), ivImageIcon);
            tvShenheDingNumber.setText(listBean.getUp());
            tvShenheCaiNumber.setText(listBean.getDown() + "");
            tvPostsNumber.setText(listBean.getForward() + " ");
            tvDownloadNumber.setText(listBean.getDown()+"");

            initListener(listBean);
        }
    }

    class GifViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        @Bind(R.id.iv_headpic)
        ImageView ivHeadpic;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_time_refresh)
        TextView tvTimeRefresh;
        @Bind(R.id.ll_video_user_info)
        LinearLayout llVideoUserInfo;
        @Bind(R.id.tv_context)
        TextView tvContext;
        @Bind(R.id.iv_image_gif)
        ImageView ivImageGif;
        @Bind(R.id.tv_ding)
        TextView tvDing;
        @Bind(R.id.tv_shenhe_ding_number)
        TextView tvShenheDingNumber;
        @Bind(R.id.ll_ding)
        LinearLayout llDing;
        @Bind(R.id.iv_cai)
        TextView ivCai;
        @Bind(R.id.tv_shenhe_cai_number)
        TextView tvShenheCaiNumber;
        @Bind(R.id.ll_cai)
        LinearLayout llCai;
        @Bind(R.id.tv_posts_number)
        TextView tvPostsNumber;
        @Bind(R.id.ll_share)
        LinearLayout llShare;
        @Bind(R.id.tv_download_number)
        TextView tvDownloadNumber;
        @Bind(R.id.ll_download)
        LinearLayout llDownload;
        public GifViewHolder(Context context, View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.context=context;
        }
        private void initListener(final TuiJianBean.ListBean listBean) {
            llDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TuiJianImageInfoActivity.class);
                    intent.putExtra(TUIJIANID,listBean.getId());
                    intent.putExtra(CONTEXT,listBean.getText());
                    intent.putExtra(VIDEOURL,listBean.getGif().getDownload_url().get(0));
                    intent.putExtra(UP,listBean.getUp());
                    intent.putExtra(PASSTIME,listBean.getPasstime());
                    context.startActivity(intent);
                }
            });
        }
        public void setData(TuiJianBean.ListBean listBean) {
            Glide.with(context).load(listBean.getU().getHeader().get(0)).into(ivHeadpic);

            tvName.setText(listBean.getU().getName());
            tvTimeRefresh.setText(listBean.getPasstime());
            tvContext.setText(listBean.getText());
            Glide.with(context).load(listBean.getGif().getImages().get(0)).asGif().into(ivImageGif);
            tvShenheDingNumber.setText(listBean.getUp());
            tvShenheCaiNumber.setText(listBean.getDown() + "");
            tvPostsNumber.setText(listBean.getForward() + " ");
            tvDownloadNumber.setText(listBean.getDown()+"");

            initListener(listBean);

        }
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private final TimeUtils timeUtils;
        @Bind(R.id.iv_headpic)
        ImageView ivHeadpic;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_time_refresh)
        TextView tvTimeRefresh;
        @Bind(R.id.tv_context)
        TextView tvContext;
        @Bind(R.id.jcv_videoplayer)
        JCVideoPlayerStandard jcvVideoplayer;
        @Bind(R.id.tv_play_nums)
        TextView tvPlayNums;
        @Bind(R.id.tv_video_duration)
        TextView tvVideoDuration;
        @Bind(R.id.rl_holder)
        RelativeLayout rlHolder;
        @Bind(R.id.tv_ding)
        TextView tvDing;
        @Bind(R.id.tv_shenhe_ding_number)
        TextView tvShenheDingNumber;
        @Bind(R.id.ll_ding)
        LinearLayout llDing;
        @Bind(R.id.iv_cai)
        TextView ivCai;
        @Bind(R.id.tv_shenhe_cai_number)
        TextView tvShenheCaiNumber;
        @Bind(R.id.ll_cai)
        LinearLayout llCai;
        @Bind(R.id.tv_posts_number)
        TextView tvPostsNumber;
        @Bind(R.id.ll_share)
        LinearLayout llShare;
        @Bind(R.id.tv_download_number)
        TextView tvDownloadNumber;
        @Bind(R.id.ll_download)
        LinearLayout llDownload;
        @Bind(R.id.listview)
        ListView listview;

        public VideoViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this, itemView);
            timeUtils = new TimeUtils();

        }

        private void initListener(final TuiJianBean.ListBean listBean) {
            llDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TuiJianVideoInfoActivity.class);
                    intent.putExtra(TUIJIANID,listBean.getId());
                    intent.putExtra(CONTEXT,listBean.getText());
                    intent.putExtra(VIDEOURL,listBean.getVideo().getVideo().get(0));
                    intent.putExtra(PLAYCOUNT,listBean.getVideo().getPlaycount() + "次播放");
                    intent.putExtra(UP,listBean.getUp());
                    intent.putExtra(PASSTIME,listBean.getPasstime());
                    context.startActivity(intent);
                }
            });
        }

        public void setData(TuiJianBean.ListBean listBean) {
            Glide.with(context).load(listBean.getU().getHeader().get(0)).into(ivHeadpic);
            tvName.setText(listBean.getU().getName());
            tvTimeRefresh.setText(listBean.getPasstime());
            tvContext.setText(listBean.getText());
            tvPlayNums.setText(listBean.getVideo().getPlaycount() + "次播放");
            tvVideoDuration.setText(timeUtils.stringForTime(listBean.getVideo().getDuration() * 1000) + "");
            tvShenheDingNumber.setText(listBean.getUp());
            tvShenheCaiNumber.setText(listBean.getDown() + "");
            tvPostsNumber.setText(listBean.getForward() + " ");
            tvDownloadNumber.setText(listBean.getDown()+"");

            jcvVideoplayer.setUp(listBean.getVideo().getVideo().get(0), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
            Glide.with(context).load(listBean.getVideo().getThumbnail().get(0)).into(jcvVideoplayer.thumbImageView);

            initListener(listBean);
        }
    }

}
