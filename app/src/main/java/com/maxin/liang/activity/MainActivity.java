package com.maxin.liang.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

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
    public void initData() {
        initFragment();
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

}
