package com.maxin.liang.bilibili.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.BaseActivity;
import com.maxin.liang.bilibili.bean.PersonBean;
import com.maxin.liang.media.widget.media.IjkVideoView;
import com.maxin.liang.utils.GlideCircleTransform;

import butterknife.Bind;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

import static com.maxin.liang.bilibili.adapter.PartitionLiveAdapter.LIVE;


public class LiveActivity extends BaseActivity {


    @Bind(R.id.iv_live_photo)
    ImageView ivLivePhoto;
    @Bind(R.id.tv_live_top)
    TextView tvLiveTop;
    @Bind(R.id.tv_count)
    TextView tvCount;
    @Bind(R.id.videoplayer)
    IjkVideoView videoplayer;
    private PersonBean.DataBean.PartitionsBean.LivesBean items;

    @Override
    public void initView() {
        super.initView();

        //videoplayer.setUp(items.getPlayurl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, items.getTitle());

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        if (items.getPlayurl() != null) {
            videoplayer.setVideoPath(items.getPlayurl());
        }
        videoplayer.start();

        Glide.with(this).load(items.getOwner().getFace()).transform(new GlideCircleTransform(LiveActivity.this)).into(ivLivePhoto);
        tvLiveTop.setText(items.getTitle());
        tvCount.setText(items.getOnline() + "");
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
