package com.maxin.liang.activity;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.bean.shop.GoodsInfosBean;
import com.maxin.liang.utils.NetConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

import static com.maxin.liang.adapter.GoodsListAdapter.POSITIONID;

public class GoodsInfoActivity extends BaseActivity {


    private String goodsInfoId;

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getData();
        getDataFromNet();
    }

    private void getDataFromNet() {
        String url= NetConfig.BRAND_GOODS_DETAILS_URL+goodsInfoId;
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("GoodsInfoActivity", "onError"+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("GoodsInfoActivity", "onResponse"+response);
                processData(response);
            }
        });
    }

    private void processData(String response) {
        JSONObject.parseObject(response, GoodsInfosBean.class);
    }

    private void getData() {
        goodsInfoId = getIntent().getStringExtra(POSITIONID);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_info;
    }
}
