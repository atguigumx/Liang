package com.maxin.liang.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.adapter.BrandInfoAdapter;
import com.maxin.liang.bean.shop.BrandInfosBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

import static com.maxin.liang.fragment.shopfragment.BrandFragment.BRANDID;

public class BrandInfoActivity extends BaseActivity {


    @Bind(R.id.iv_title_search)
    ImageView ivTitleSearch;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_title_shopcart)
    ImageView ivTitleShopcart;
    @Bind(R.id.brand_logo)
    ImageView brandLogo;
    @Bind(R.id.brand_name)
    TextView brandName;
    @Bind(R.id.brand_story_tv)
    RadioButton brandStoryTv;
    @Bind(R.id.brand_goods_tv)
    RadioButton brandGoodsTv;
    @Bind(R.id.brand_story_content_tv)
    TextView brandStoryContentTv;
    @Bind(R.id.recycle)
    RecyclerView recycle;

    @Override
    public void initListener() {
        brandStoryTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brandStoryContentTv.setVisibility(View.VISIBLE);
                recycle.setVisibility(View.GONE);

            }
        });
        brandGoodsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brandStoryContentTv.setVisibility(View.GONE);
                recycle.setVisibility(View.VISIBLE);
            }
        });
        ivTitleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void initView() {
        super.initView();
        ivTitleSearch.setImageResource(R.drawable.actionbar_navigation_back);
        tvTitle.setVisibility(View.GONE);
        ivTitleShopcart.setVisibility(View.GONE);
    }

    @Override
    public void initData() {
        int brandId = getIntent().getIntExtra(BRANDID,-1);

       //             http://mobile.iliangcang.com/brand/brandShopList?app_key=Android&brand_id=844&count=20&page=1&sig=430BD99E6C913B8B8C3ED109737ECF15|830952120106768&v=1.0
        String url = "http://mobile.iliangcang.com/brand/brandShopList?app_key=Android&brand_id="+brandId+"&count=20&page=1&sig=430BD99E6C913B8B8C3ED109737ECF15|830952120106768&v=1.0";
        //Log.e("TAG"+brandId, ""+url);
        getDataFromNet(url);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("BrandInfoActivity", "onError=" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        BrandInfosBean brandInfo = JSONObject.parseObject(response, BrandInfosBean.class);
        List<BrandInfosBean.DataBean.ItemsBean> itemsBean = brandInfo.getData().getItems();
        if(itemsBean!=null&&itemsBean.size()>0) {
            Glide.with(BrandInfoActivity.this).load(itemsBean.get(0).getBrand_info().getBrand_logo()).into(brandLogo);
            brandName.setText(itemsBean.get(0).getBrand_info().getBrand_name());
            brandStoryContentTv.setText(itemsBean.get(0).getBrand_info().getBrand_desc());
            BrandInfoAdapter adapter = new BrandInfoAdapter(this, itemsBean);
            recycle.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(this, 2);
            recycle.setLayoutManager(manager);
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_info;
    }


}
