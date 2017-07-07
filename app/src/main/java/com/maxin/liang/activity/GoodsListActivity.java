package com.maxin.liang.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.maxin.liang.R;
import com.maxin.liang.adapter.GoodsListAdapter;
import com.maxin.liang.bean.shop.GoodsListBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

import static com.maxin.liang.fragment.shopfragment.TypeFragment.POSITION;

public class GoodsListActivity extends BaseActivity {


    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.iv_title_back)
    ImageView ivTitleBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_title_shopcart)
    ImageView ivTitleShopcart;


    private List<GoodsListBean.DataBean.ItemsBean> items;
    private GoodsListAdapter adapter;
    private String murl;


    @Override
    public void initView() {
        super.initView();
        tvTitle.setText("商店");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getData();
        getDataFromNet(murl);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("GoodsListActivity", "onError" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("GoodsListActivity", "onResponse");
                processData(response);
            }
        });
    }

    private void processData(String response) {
        GoodsListBean goodsBean = JSON.parseObject(response, GoodsListBean.class);
        items = goodsBean.getData().getItems();
        if (items.size() > 0 && items != null) {
            adapter=new GoodsListAdapter(this,items);
            GridLayoutManager manager = new GridLayoutManager(this, 2);
            recyclerview.setLayoutManager(manager);
            recyclerview.setAdapter(adapter);
        }

    }

    private void getData() {
        murl = getIntent().getStringExtra(POSITION);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_list;
    }
}
