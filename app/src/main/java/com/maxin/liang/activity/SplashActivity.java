package com.maxin.liang.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;

import butterknife.Bind;

public class SplashActivity extends BaseActivity {

    @Bind(R.id.imageview)
    ImageView imageview;
    private CountDownTimer countDownTimer;

    @Override
    public void initView() {
        super.initView();
        Glide.with(this).load(R.drawable.loading_start).into(imageview);
    }

    @Override
    public void initListener() {
        countDownTimer = new CountDownTimer(4800, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //倒计时结束
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                        finish();
                    }
                });

            }
        }.start();
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


}
