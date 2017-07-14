package com.maxin.liang.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.hyphenate.chat.EMClient;
import com.maxin.liang.R;
import com.maxin.liang.adapter.GoodsListAdapter;
import com.maxin.liang.bean.shop.GoodsListBean;
import com.maxin.liang.common.Modle;
import com.maxin.liang.login.UserInfo;
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
        ivTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ivTitleShopcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectChageActivity();
            }
        });
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
                    startActivity(new Intent(GoodsListActivity.this,ShopCartActivity.class));

                }else{
                    //没有登录过
                    startActivity(new Intent(GoodsListActivity.this,LoginActivity.class));

                }
            }
        });
    }
}
