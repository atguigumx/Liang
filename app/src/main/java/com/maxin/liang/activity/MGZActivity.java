package com.maxin.liang.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxin.liang.R;
import com.maxin.liang.fragment.mgzfragment.MGZAuthorFragment;
import com.maxin.liang.fragment.mgzfragment.MGZTypeFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MGZActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.mgz_titile)
    LinearLayout mgzTitile;
    @Bind(R.id.mgz_indicator)
    TabPageIndicator Indicator;
    @Bind(R.id.viewpager_mgz)
    ViewPager viewpagerMgz;
    private List<Fragment> list;

    @Override
    public void initListener() {
        mgzTitile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
            }
        });
    }

    @Override
    public void initData() {
        initFragment();
    }

    private void initFragment() {
        list = new ArrayList<>();
        list.add(new MGZTypeFragment());
        list.add(new MGZAuthorFragment());
        viewpagerMgz.setAdapter(new ViewpagerMgz(getSupportFragmentManager()));
        Indicator.setViewPager(viewpagerMgz);
        viewpagerMgz.setCurrentItem(1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mgz;
    }


    class ViewpagerMgz extends FragmentPagerAdapter{

        public ViewpagerMgz(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list==null?0:list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0) {
                return "分类";
            }else if(position==1) {
                return "作者";
            }
            return super.getPageTitle(position);
        }
    }
}
