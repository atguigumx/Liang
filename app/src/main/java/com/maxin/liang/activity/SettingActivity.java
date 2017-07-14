package com.maxin.liang.activity;

import android.view.View;
import android.widget.Button;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.maxin.liang.R;
import com.maxin.liang.common.Modle;
import com.maxin.liang.utils.UiUtils;

import butterknife.Bind;

public class SettingActivity extends BaseActivity {

    @Bind(R.id.setting_btn_exit)
    Button settingBtnExit;


    @Override
    public void initListener() {
        String currentUser = EMClient.getInstance().getCurrentUser();
        // 更新button显示
        settingBtnExit.setText("退出登录(" + currentUser.toLowerCase() + ")");

        settingBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modle.getInstance().getGlobalThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        boolean loggedInBefore = EMClient.getInstance().isLoggedInBefore();
                        if (loggedInBefore){
                            //登录过
                            EMClient.getInstance().logout(false, new EMCallBack() {
                                @Override
                                public void onSuccess() {

                                    //清除个人数据
                                    UiUtils.showToast("退出成功");
                                    //跳转到登录界面
                                    //startActivity(new Intent(this, LoginActivity.class));
                                    //把当前界面finsh
                                    finish();
                                }

                                @Override
                                public void onError(int i, String s) {
                                    UiUtils.showToast(s);
                                }

                                @Override
                                public void onProgress(int i, String s) {

                                }
                            });

                        }else{
                            //没有登录过
                            UiUtils.showToast("还没有登录");

                        }


                    }
                });
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }
}
