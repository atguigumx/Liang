package com.maxin.liang.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.maxin.liang.R;
import com.maxin.liang.fragment.MGZFragment;
import com.maxin.liang.fragment.MasterFragment;
import com.maxin.liang.fragment.PersonalFragment;
import com.maxin.liang.fragment.ShareFragment;
import com.maxin.liang.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import static com.maxin.liang.fragment.mgzfragment.MGZAuthorFragment.MGZAUTHORNAME;
import static com.maxin.liang.fragment.mgzfragment.MGZAuthorFragment.MGZCHEKID;
import static com.maxin.liang.fragment.mgzfragment.MGZAuthorFragment.MGZURL;

public class MainActivity extends BaseActivity {
    @Bind(R.id.main_fl)
    FrameLayout mainFl;
    @Bind(R.id.rb_main_shop)
    RadioButton rbMainShop;
    @Bind(R.id.rb_main_magzine)
    RadioButton rbMainMagzine;
    @Bind(R.id.rb_main_nb)
    RadioButton rbMainNb;
    @Bind(R.id.rb_main_share)
    RadioButton rbMainShare;
    @Bind(R.id.rb_main_my)
    RadioButton rbMainMy;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    private List<Fragment> fragments;
    private Fragment tempFragment;
    private int position;
    private String url;
    private String authorName;
    private EventHandler eventHandler;

    @Override
    public void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_main_shop :
                        position=0;
                        break;
                    case R.id.rb_main_magzine :
                        position=1;
                        break;
                    case R.id.rb_main_nb:
                        position=2;
                        break;
                    case R.id.rb_main_share :
                        position=3;
                        break;
                    case R.id.rb_main_my :
                        position=4;
                        break;
                }
                Fragment fragment = fragments.get(position);
                switchFragment(fragment);
            }

        });


        rgMain.check(R.id.rb_main_shop);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String urls = intent.getStringExtra(MGZURL);

        if(!TextUtils.isEmpty(urls)) {
            url=urls;
        }else {
            url=null;
        }

        String authorNames = intent.getStringExtra(MGZAUTHORNAME);
        if(!TextUtils.isEmpty(authorNames)) {
            authorName=authorNames;
        }else {
            authorName=null;
        }

        int checkedId = intent.getIntExtra(MGZCHEKID, R.id.rb_main_shop);
        if (checkedId == R.id.rb_main_magzine) {
            rgMain.check(R.id.rb_main_magzine);
        }
    }

    @Override
    public void initData() {
        initFragment();

        int checkedId = getIntent().getIntExtra("checkedId", R.id.rb_main_shop);
        if (checkedId == R.id.rb_main_magzine) {
            rgMain.check(R.id.rb_main_magzine);
        }
        initSSMS();
    }

    private void initSSMS() {
        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
        //SMSSDK.setAskPermisionOnReadContact(boolShowInDialog)

        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        @SuppressWarnings("unchecked") HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                        String country = (String) phoneMap.get("country");
                        String phone = (String) phoneMap.get("phone");
                      //  Log.d(TAG, "提交验证码成功--country=" + country + "--phone" + phone);
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        //获取验证码成功
                      //  Log.d(TAG, "获取验证码成功");
                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //返回支持发送验证码的国家列表
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                }
            }
        };

        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ShopFragment());
        fragments.add(new MGZFragment());
        fragments.add(new MasterFragment());
        fragments.add(new ShareFragment());
        fragments.add(new PersonalFragment());
        switchFragment(fragments.get(position));
    }

    private void switchFragment(Fragment currentFragment) {
        if (currentFragment != tempFragment) {

            if (currentFragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                //如果没有添加就添加
                if (!currentFragment.isAdded()) {
                    //隐藏之前的
                    if (tempFragment != null) {
                        ft.hide(tempFragment);
                    }

                    //添加Fragment
                    ft.add(R.id.main_fl, currentFragment);

                }
                //如果添加了就隐藏
                else {
                    //隐藏上次显示的
                    if (tempFragment != null) {
                        ft.hide(tempFragment);
                    }

                    //显示
                    ft.show(currentFragment);
                }

                //最后统一提交
                ft.commit();
                //重新赋值
                tempFragment = currentFragment;
            }

        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    //设置连续点击退出键两次退出应用
    private boolean isExit = false;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (isExit) {
                finish();
                return true;
            }
            Toast.makeText(this, "再次点击退出应用", Toast.LENGTH_SHORT).show();
            isExit = true;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);

            return true;
        }

        return super.onKeyUp(keyCode, event);
    }
    public String getUrl(){
        return url;
    }
    public String getAuthorName(){
        return authorName;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
