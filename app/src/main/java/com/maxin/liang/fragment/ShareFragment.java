package com.maxin.liang.fragment;

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

import com.maxin.liang.R;
import com.maxin.liang.fragment.sharefragment.ShareDuanZiFragment;
import com.maxin.liang.fragment.sharefragment.ShareTuiJianFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/6.
 */

public class ShareFragment extends Fragment {
    @Bind(R.id.iv_share_title_back)
    ImageView ivShareTitleBack;
    @Bind(R.id.share_indicator)
    TabPageIndicator shareIndicator;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private ArrayList<Fragment> mlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_share, null);
        ButterKnife.bind(this, view);
        initFragment();
        viewpager.setAdapter(new MyPagerAdapter(getFragmentManager()));
        shareIndicator.setViewPager(viewpager);
        return view;
    }

    private void initFragment() {
        mlist=new ArrayList<>();
        mlist.add(new ShareTuiJianFragment());
        mlist.add(new ShareDuanZiFragment());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public int getCount() {
            return mlist==null?0:mlist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0) {
                return "推荐";
            }else if(position==1) {
                return "段子";
            }
            return super.getPageTitle(position);
        }
    }
}
