package com.maxin.liang.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.hyphenate.chat.EMClient;
import com.maxin.liang.R;
import com.maxin.liang.bean.shop.GoodsInfosBean;
import com.maxin.liang.common.Modle;
import com.maxin.liang.login.UserInfo;
import com.maxin.liang.utils.AdapterUtils;
import com.maxin.liang.utils.VirtualkeyboardHeight;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;

import static com.maxin.liang.fragment.shopfragment.BrandFragment.BRANDID;
import static com.maxin.liang.fragment.shopfragment.TypeFragment.POSITION;

public class GoodsInfoActivity extends BaseActivity {


    @Bind(R.id.tv_goods_name)
    TextView tvGoodsName;
    @Bind(R.id.tv_like_count)
    TextView tvLikeCount;
    @Bind(R.id.tv_desc)
    TextView tvDesc;
    @Bind(R.id.tv_com)
    TextView tvCom;
    @Bind(R.id.iv_share)
    ImageView ivShare;
    @Bind(R.id.discount_price)
    TextView discountPrice;
    @Bind(R.id.pre_price)
    TextView prePrice;
    @Bind(R.id.ll_select_size)
    LinearLayout llSelectSize;
    @Bind(R.id.iv_logo)
    ImageView ivLogo;
    @Bind(R.id.tv_brand_name)
    TextView tvBrandName;
    @Bind(R.id.ll_logo)
    LinearLayout llLogo;
    @Bind(R.id.rb_goods_details)
    RadioButton rbGoodsDetails;
    @Bind(R.id.rb_buy_note)
    RadioButton rbBuyNote;
    @Bind(R.id.rg_goods_details)
    RadioGroup rgGoodsDetails;
    @Bind(R.id.tv_buy_know)
    TextView tvBuyKnow;
    @Bind(R.id.ll_goods_details_iv)
    LinearLayout llGoodsDetailsIv;
    @Bind(R.id.ib_back)
    ImageButton ibBack;
    @Bind(R.id.ib_cart)
    ImageButton ibCart;
    @Bind(R.id.rb_service)
    RadioButton rbService;
    @Bind(R.id.rb_add_cart)
    RadioButton rbAddCart;
    @Bind(R.id.rb_buy)
    RadioButton rbBuy;
    @Bind(R.id.rg_buy_cart)
    RadioGroup rgBuyCart;
    @Bind(R.id.activity_goods_detail)
    RelativeLayout activityGoodsDetail;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.rl_price)
    RelativeLayout rlPrice;
    private String goods_url;
    private GoodsInfosBean.DataBean.ItemsBean items;

    @Override
    public void initListener() {

        llLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoodsInfoActivity.this, BrandInfoActivity.class);
                intent.putExtra(BRANDID, Integer.parseInt(items.getBrand_info().getBrand_id()));
                Log.e("GoodsInfoActivity", "" + items.getBrand_info().getBrand_id());
                startActivity(intent);
            }
        });

        rgGoodsDetails.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_goods_details:
                        llGoodsDetailsIv.setVisibility(View.VISIBLE);
                        tvBuyKnow.setVisibility(View.GONE);
                        setDetails();
                        break;
                    case R.id.rb_buy_note:
                        tvBuyKnow.setText(items.getGood_guide().getContent());
                        tvBuyKnow.setVisibility(View.VISIBLE);
                        llGoodsDetailsIv.setVisibility(View.GONE);
                        break;
                }
            }
        });
        rgGoodsDetails.check(R.id.rb_goods_details);
        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });


        llSelectSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopWindow();
            }
        });

        rbAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopWindow();
            }
        });

        rbBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopWindow();
            }
        });
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ibCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectChageActivity();
            }
        });
    }

    private void showPopWindow() {
        //是否登录过环信服务器
        boolean loggedInBefore = EMClient.getInstance().isLoggedInBefore();
        if (loggedInBefore) {
            //登录过
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.popupwindow_add_product, null);

            final PopupWindow window = new PopupWindow(view,
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT);

            window.setFocusable(true);

            window.setAnimationStyle(R.style.AnimBottom);
            ImageView goodsPicture = (ImageView) view.findViewById(R.id.iv_popgoods_picture);
            ImageView chahao = (ImageView) view.findViewById(R.id.pop_chahao);
            TextView name = (TextView) view.findViewById(R.id.tv_popgoods_name);
            TextView desc = (TextView) view.findViewById(R.id.tv_popgoods_desc);
            TextView price = (TextView) view.findViewById(R.id.tv_popgoods_price);
            Button queren = (Button) view.findViewById(R.id.btn_popqueren);

            Glide.with(GoodsInfoActivity.this).load(items.getGoods_image()).into(goodsPicture);
            desc.setText(items.getGoods_name());
            name.setText(items.getOwner_name());
            if (items.getDiscount_price().equals("")) {
                price.setText("￥ " + items.getPrice());
            } else {
                price.setText("￥ " + items.getDiscount_price());
            }

            chahao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    window.dismiss();
                }
            });
            queren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(GoodsInfoActivity.this, "加入购物车", Toast.LENGTH_SHORT).show();
                    window.dismiss();
                }
            });

            window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    window.dismiss();
                }
            });
            //在底部显示
            window.showAtLocation(GoodsInfoActivity.this.findViewById(R.id.rg_buy_cart),
                    Gravity.BOTTOM, 0, VirtualkeyboardHeight.getBottomStatusHeight(GoodsInfoActivity.this));

        } else {
            //没有登录过
            startActivity(new Intent(GoodsInfoActivity.this, LoginActivity.class));

        }





    }

    private void setDetails() {
        List<GoodsInfosBean.DataBean.ItemsBean.GoodsInfoBean> goods_info = items.getGoods_info();
        llGoodsDetailsIv.removeAllViews();

        String goods_desc = items.getGoods_desc();
        if (goods_desc.length() > 2) {
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.topMargin = AdapterUtils.dip2px(this, 15);
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(AdapterUtils.px2sp(this, AdapterUtils.dip2px(this, 16)));
            textView.setLineSpacing(0, 1.5F);
            textView.setTextColor(Color.parseColor("#727678"));
            textView.setText(goods_desc);
            llGoodsDetailsIv.addView(textView);

        }
        for (int i = 0; i < goods_info.size(); i++) {
            GoodsInfosBean.DataBean.ItemsBean.GoodsInfoBean goodsInfoBean = goods_info.get(i);
            GoodsInfosBean.DataBean.ItemsBean.GoodsInfoBean.ContentBean content = goodsInfoBean.getContent();
            String text = content.getText();
            String img = content.getImg();
            if (!TextUtils.isEmpty(img)) {
                ImageView imageView = new ImageView(this);
                Glide.with(this).load(img).into(imageView);
                llGoodsDetailsIv.addView(imageView);
            } else if (!TextUtils.isEmpty(text)) {
                Log.e("TAG", "contentx--" + text);
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.topMargin = AdapterUtils.dip2px(this, 15);
                layoutParams.bottomMargin = AdapterUtils.dip2px(this, 10);
                textView.setLayoutParams(layoutParams);
                textView.setTextSize(AdapterUtils.px2sp(this, AdapterUtils.dip2px(this, 16)));
                textView.setLineSpacing(0, 1.5F);
                if (goodsInfoBean.getType() == 0) {
                    textView.setTextColor(Color.parseColor("#727678"));
                } else if (goodsInfoBean.getType() == 2) {
                    textView.setTextColor(Color.WHITE);
                }
                textView.setText(text);
                llGoodsDetailsIv.addView(textView);
            }
        }
    }

    @Override
    public void initData() {
        String goodsId = getIntent().getStringExtra(POSITION);
        String goodsUrl = "http://mobile.iliangcang.com/goods/goodsDetail?app_key=Android&goods_id=" + goodsId + "&sig=430BD99E6C913B8B8C3ED109737ECF15|830952120106768&v=1.0";
        getDataFromNet(goodsUrl);

    }

    private void getDataFromNet(String goodsInfoIdurl) {

        OkHttpUtils.get().url(goodsInfoIdurl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("GoodsInfoActivity", "onError" + e.getMessage());

            }

            @Override
            public void onResponse(String response, int id) {
                //Log.e("GoodsInfoActivity", "onResponse" + response);
                processData(response);

            }
        });

    }


    private void processData(String response) {
        GoodsInfosBean goodsInfosBean = JSONObject.parseObject(response, GoodsInfosBean.class);
        items = goodsInfosBean.getData().getItems();

        if (items != null) {
            if (items.getDiscount_price().equals("")) {
                rlPrice.setVisibility(View.GONE);
                discountPrice.setText("￥ " + items.getPrice());
            } else {
                discountPrice.setText("￥ " + items.getDiscount_price());
                prePrice.setText("￥ " + items.getPrice());
            }
            banner.setImages(items.getImages_item())
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load((String) path).into(imageView);
                        }
                    })
                    .isAutoPlay(false)
                    .start();
            tvLikeCount.setText(items.getLike_count());
            tvGoodsName.setText(items.getBrand_info().getBrand_name());
            tvDesc.setText(items.getGoods_name());
            tvCom.setText(items.getPromotion_note());

            Glide.with(this).load(items.getBrand_info().getBrand_logo()).into(ivLogo);
            tvBrandName.setText(items.getBrand_info().getBrand_name());
            tvBuyKnow.setText(items.getGood_guide().getContent());


            setDetails();
        }

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_info;
    }


    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

    public void selectChageActivity() {

        Modle.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                //是否登录过环信服务器
                boolean loggedInBefore = EMClient.getInstance().isLoggedInBefore();
                if (loggedInBefore) {
                    //登录过
                    //初始化登录成功后的操作
                    String currentUser = EMClient.getInstance().getCurrentUser();
                    Modle.getInstance().loginSuccess(new UserInfo(currentUser, currentUser));
                    startActivity(new Intent(GoodsInfoActivity.this, ShopCartActivity.class));

                } else {
                    //没有登录过
                    startActivity(new Intent(GoodsInfoActivity.this, LoginActivity.class));

                }
            }
        });
    }
}
