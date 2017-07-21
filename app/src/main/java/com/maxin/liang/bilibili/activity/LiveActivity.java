package com.maxin.liang.bilibili.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.BaseActivity;
import com.maxin.liang.bilibili.bean.PersonBean;
import com.maxin.liang.utils.GlideCircleTransform;

import butterknife.Bind;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static com.maxin.liang.bilibili.adapter.PartitionLiveAdapter.LIVE;


public class LiveActivity extends BaseActivity {

    @Bind(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;
    @Bind(R.id.iv_live_photo)
    ImageView ivLivePhoto;
    @Bind(R.id.tv_live_top)
    TextView tvLiveTop;
    @Bind(R.id.tv_count)
    TextView tvCount;
    private PersonBean.DataBean.PartitionsBean.LivesBean items;

    @Override
    public void initView() {
        super.initView();
//        jcvVideoplayer.setUp(listBean.getVideo().getVideo().get(0), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
//        Glide.with(context).load(listBean.getVideo().getThumbnail().get(0)).into(jcvVideoplayer.thumbImageView);
        videoplayer.setUp(items.getPlayurl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, items.getTitle());
        Glide.with(this).load(items.getOwner().getFace()).transform(new GlideCircleTransform(LiveActivity.this)).into(ivLivePhoto);
        tvLiveTop.setText(items.getTitle());
        tvCount.setText(items.getOnline()+"");
    }

    public void getData() {
        items = (PersonBean.DataBean.PartitionsBean.LivesBean) getIntent().getSerializableExtra(LIVE);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_live;
    }


}
