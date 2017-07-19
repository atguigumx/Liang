package com.maxin.liang.common;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

/**
 * Created by shkstart on 2017/7/6.
 */

public class MyApplication extends Application {
    private static Context context;
    private static Handler handler;
    private static int pid;
    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        pid = android.os.Process.myPid();
        context=this;
        initOkhttp();
        ImageLoaderConfiguration config = ImageLoaderConfiguration
                .createDefault(this);
        ImageLoader.getInstance().init(config);
        initHXsdk();
        Modle.getInstance().init(context);

        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }

    private void initOkhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    private void initHXsdk() {
        EMOptions options = new EMOptions();
        //是否自动接受邀请
        options.setAcceptInvitationAlways(false);
        //是否自动接受群邀请
        options.setAutoAcceptGroupInvitation(false);
        //始化EaseUI
        EaseUI.getInstance().init(this, options);
    }
    public static Context getContext() {
        return context;
    }
    public static Handler getHandler() {
        return handler;
    }

    public static int getPid() {
        return pid;
    }
}
