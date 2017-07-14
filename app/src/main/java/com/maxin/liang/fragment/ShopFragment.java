package com.maxin.liang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.chat.EMClient;
import com.maxin.liang.R;
import com.maxin.liang.activity.LoginActivity;
import com.maxin.liang.activity.SettingActivity;
import com.maxin.liang.activity.ShopCartActivity;
import com.maxin.liang.common.Modle;
import com.maxin.liang.fragment.shopfragment.BrandFragment;
import com.maxin.liang.fragment.shopfragment.GiftFragment;
import com.maxin.liang.fragment.shopfragment.HomeFragment;
import com.maxin.liang.fragment.shopfragment.SpecialFragment;
import com.maxin.liang.fragment.shopfragment.TypeFragment;
import com.maxin.liang.login.UserInfo;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/6.
 */

public class ShopFragment extends Fragment {
    @Bind(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_title_shopcart)
    ImageView ivTitleShopcart;
    @Bind(R.id.tabpage_invest)
    TabPageIndicator tabpageInvest;
    @Bind(R.id.vp_invest)
    ViewPager vpInvest;
    private ArrayList<Fragment> alist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.shop_fragment, null);
        ButterKnife.bind(this, view);
        tvTitle.setText("商店");
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        ivTitleShopcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectChageActivity();
            }
        });
        ivTitleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SettingActivity.class));
            }
        });
    }

    private void initData() {
        initFragment();
        vpInvest.setAdapter(new ViewPagerAdapter(getFragmentManager()));
        tabpageInvest.setViewPager(vpInvest);
        vpInvest.setCurrentItem(2);
    }

    private void initFragment() {
        alist = new ArrayList<>();
        alist.add(new TypeFragment());
        alist.add(new BrandFragment());
        alist.add(new HomeFragment());
        alist.add(new SpecialFragment());
        alist.add(new GiftFragment());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return alist.get(position);
        }

        @Override
        public int getCount() {
            return alist==null?0:alist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0) {
                return "分类";
            }else if(position==1) {
                return "品牌";
            }else if(position==2) {
                return "首页";
            }else if(position==3) {
                return "专题";
            }else if(position==4) {
                return "礼物";
            }
            return super.getPageTitle(position);
        }
    }
    public void selectChageActivity() {

        Modle.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                //是否登录过环信服务器
                boolean loggedInBefore = EMClient.getInstance().isLoggedInBefore();
                if (loggedInBefore){
                    //登录过
                    //初始化登录成功后的操作
                    String currentUser = EMClient.getInstance().getCurrentUser();
                    Modle.getInstance().loginSuccess(new UserInfo(currentUser,currentUser));
                    startActivity(new Intent(getActivity(),ShopCartActivity.class));

                }else{
                    //没有登录过
                    startActivity(new Intent(getActivity(),LoginActivity.class));

                }
            }
        });
    }
}
