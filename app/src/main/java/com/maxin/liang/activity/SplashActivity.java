package com.maxin.liang.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.maxin.liang.R;

import butterknife.Bind;

public class SplashActivity extends BaseActivity {

    private static final int MESSAGE_SUCCESS = 1;
    @Bind(R.id.imageview)
    ImageView imageview;

    private int durations;
    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MESSAGE_SUCCESS :
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                    finish();
                    break;
            }
        }
    };

    @Override
    public void initView() {
        super.initView();
        Glide.with(this).load(R.drawable.loading_start)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer integer, Target<GlideDrawable> target, boolean b) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer integer, Target<GlideDrawable> target, boolean b, boolean b1) {
                        // 计算动画时长
                        GifDrawable drawable = (GifDrawable) resource;
                        GifDecoder decoder = drawable.getDecoder();
                        for (int i = 0; i < drawable.getFrameCount(); i++) {
                            durations += decoder.getDelay(i);
                        }
                        //发送延时消息，通知动画结束
                        handler.sendEmptyMessageDelayed(MESSAGE_SUCCESS,
                                durations);
                        return false;
                    }
                })
                .into(imageview);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


}
