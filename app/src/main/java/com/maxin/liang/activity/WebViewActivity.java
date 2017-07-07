package com.maxin.liang.activity;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.maxin.liang.R;

import butterknife.Bind;

import static com.maxin.liang.adapter.SpecialAdapter.POSITIONURL;

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.webview)
    WebView webview;
    private String url;

    @Override
    public void initView() {
        super.initView();
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
        webview.loadUrl(url);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        url = getIntent().getStringExtra(POSITIONURL);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_view;
    }

}
