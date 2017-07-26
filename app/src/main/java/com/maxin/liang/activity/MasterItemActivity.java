package com.maxin.liang.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.bean.master.MasterItemBean;
import com.maxin.liang.fragment.masterfragment.GuanZhuFragment;
import com.maxin.liang.fragment.masterfragment.LikeFragment;
import com.maxin.liang.fragment.masterfragment.TuiJianFragment;
import com.viewpagerindicator.TabPageIndicator;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

import static com.maxin.liang.adapter.MasterFragmentAdapter.MASTER_ID;

public class MasterItemActivity extends BaseActivity {


    @Bind(R.id.iv_title_back)
    ImageView ivTitleBack;
    @Bind(R.id.tv_master_name)
    TextView tvMasterName;
    @Bind(R.id.iv_master_photo)
    ImageView ivMasterPhoto;
    @Bind(R.id.tv_master_name2)
    TextView tvMasterName2;
    @Bind(R.id.tv_master_desc)
    TextView tvMasterDesc;
    @Bind(R.id.btn_guanzhu)
    Button btnGuanzhu;
    @Bind(R.id.btn_sixin)
    Button btnSixin;
    @Bind(R.id.indictor_master)
    TabPageIndicator indictorMaster;
    @Bind(R.id.vp_master)
    ViewPager vpMaster;
    private List<Fragment> list;
    private MasterItemBean.DataBean.ItemsBean items;
    private String likeUrl;
    private String tuijianUrl;
    private String guanzhuUrl;
    private String fansUrl;

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        String masterId = getIntent().getStringExtra(MASTER_ID);

        String masterUrl = "http://mobile.iliangcang.com/user/masterListInfo?app_key=Android&count=10&owner_id=" + masterId + "&page=1&sig=5715DFAE35D85EA29846D090DBBF8753%7C557744010558468&v=1.0";
        likeUrl="http://mobile.iliangcang.com/user/masterLike?app_key=Android&count=10&owner_id=" + masterId + "&page=1&sig=CD0E234053E25DD6111E3DBD450A4B85%7C954252010968868&v=1.0";
        tuijianUrl="http://mobile.iliangcang.com/user/masterListInfo?app_key=Android&count=10&owner_id=" + masterId + "&page=1&sig=CD0E234053E25DD6111E3DBD450A4B85%7C954252010968868&v=1.0";
        guanzhuUrl="http://mobile.iliangcang.com/user/masterFollow?app_key=Android&count=12&owner_id="+masterId+"&page=1&sig=CD0E234053E25DD6111E3DBD450A4B85%7C954252010968868&v=1.0";
        fansUrl="http://mobile.iliangcang.com/user/masterFollowed?app_key=Android&count=12&owner_id="+masterId+"&page=1&sig=CD0E234053E25DD6111E3DBD450A4B85%7C954252010968868&v=1.0";
        Log.e("TAG", "" + masterUrl);
        getDataFromNet(masterUrl);
    }

    private void getDataFromNet(String masterUrl) {
        OkHttpUtils.get().url(masterUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("MasterFragment", "onError" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                // Log.e("TAG", "response==" +response);
                processData(response);
            }
        });

    }

    private void processData(String response) {
        MasterItemBean masterItemBean = JSONObject.parseObject(response, MasterItemBean.class);
        items = masterItemBean.getData().getItems();
        initViews(items);
    }

    private void initViews(MasterItemBean.DataBean.ItemsBean items) {
        initFragment();
        vpMaster.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        indictorMaster.setVisibility(View.VISIBLE);
        indictorMaster.setViewPager(vpMaster);
        vpMaster.setCurrentItem(1);

        Glide.with(MasterItemActivity.this).load(items.getUser_image().getOrig()).into(ivMasterPhoto);
        tvMasterName.setText(items.getUser_name());
        tvMasterName2.setText(items.getUser_name());
        tvMasterDesc.setText(items.getUser_desc());
    }

    private void initFragment() {
        list=new ArrayList<>();
        list.add(LikeFragment.newInstance(likeUrl));
        list.add(TuiJianFragment.newInstance(items));
        list.add(GuanZhuFragment.newInstance(guanzhuUrl));
        list.add(GuanZhuFragment.newInstance(fansUrl));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_master_item;
    }
    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0) {
                return "喜欢"+items.getLike_count();
            }else if(position==1) {
                return "推荐"+items.getRecommendation_count();
            }else if(position==2) {
                return "关注"+items.getFollowing_count();
            }else if(position==3) {
                return "粉丝"+items.getFollowed_count();
            }
            return super.getPageTitle(position);
        }
    }
}
