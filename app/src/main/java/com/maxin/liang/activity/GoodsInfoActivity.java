package com.maxin.liang.activity;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.bean.shop.GoodsInfosBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import okhttp3.Call;

import static com.maxin.liang.fragment.shopfragment.TypeFragment.POSITION;

public class GoodsInfoActivity extends BaseActivity {


    @Bind(R.id.webview_goodsinfo)
    WebView webview;

    private GoodsInfosBean goodsInfosBean;
    private String goods_url;

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        String goodsInfoIdurl = getIntent().getStringExtra(POSITION);
       // Log.e("TAG", "goodsInfoIdurl=="+goodsInfoIdurl);
        getDataFromNet(goodsInfoIdurl);
    }

    private void getDataFromNet(String goodsInfoIdurl) {

        OkHttpUtils.get().url(goodsInfoIdurl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("GoodsInfoActivity", "onError" + e.getMessage());

            }

            @Override
            public void onResponse(String response, int id) {
              //  Log.e("GoodsInfoActivity", "onResponse" + response);
                processData(response);
                initWebView();
            }
        });

    }

    private void initWebView() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webview.loadUrl(goods_url);

    }

    private void processData(String response) {
        goodsInfosBean = JSONObject.parseObject(response, GoodsInfosBean.class);
        goods_url = goodsInfosBean.getData().getItems().getGoods_url();
    }



    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_info;
    }

}
