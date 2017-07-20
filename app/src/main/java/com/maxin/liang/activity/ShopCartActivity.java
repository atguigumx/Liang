package com.maxin.liang.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.maxin.liang.R;
import com.maxin.liang.bean.GoodsInfo;
import com.maxin.liang.common.Modle;
import com.maxin.liang.shopcar.CartStorage;
import com.maxin.liang.shopcar.ShopCartAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class ShopCartActivity extends BaseActivity {

    private static final int EDIT_PAGER = 1;
    private static final int COMPLETE_PAGER = 0;

    @Bind(R.id.reach_discount_price_tv)
    TextView reachDiscountPriceTv;
    @Bind(R.id.reach_discount_fl)
    FrameLayout reachDiscountFl;
    @Bind(R.id.discount_discount_price_tv)
    TextView discountDiscountPriceTv;
    @Bind(R.id.discount_discount_fl)
    FrameLayout discountDiscountFl;
    @Bind(R.id.pack_price_tv)
    TextView packPriceTv;
    @Bind(R.id.pack_fl)
    FrameLayout packFl;
    @Bind(R.id.ship_price_tv)
    TextView shipPriceTv;
    @Bind(R.id.ship_fl)
    FrameLayout shipFl;
    @Bind(R.id.pay_tv)
    TextView payTv;
    @Bind(R.id.all_check)
    CheckBox allCheck;
    @Bind(R.id.pay_fee_tv)
    TextView payFeeTv;
    @Bind(R.id.save_fee_tv)
    TextView saveFeeTv;
    @Bind(R.id.saving_ll)
    LinearLayout savingLl;
    @Bind(R.id.bottom_bar_ll)
    LinearLayout bottomBarLl;
    @Bind(R.id.ib_back)
    ImageButton ibBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_edit)
    Button ivEdit;
    @Bind(R.id.iv_complete)
    Button ivComplete;
    @Bind(R.id.cart_lv)
    ListView cartLv;
    private CartStorage dao;
    private ShopCartAdapter adapter;

    @Override
    public void initView() {
        super.initView();
        dao = Modle.getInstance().getManager().getShoppingCarDao();
        List<GoodsInfo> allGoods = dao.getAllGoods();
        adapter = new ShopCartAdapter(ShopCartActivity.this, allGoods, allCheck, dao, COMPLETE_PAGER, payFeeTv, saveFeeTv);
        cartLv.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_cart;
    }

    @OnClick({R.id.ib_back, R.id.iv_edit, R.id.iv_complete, R.id.all_check,R.id.pay_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all_check:
                boolean checked = allCheck.isChecked();

                adapter.checkNone(checked);

                adapter.showTotalPrice();
                break;
            case R.id.ib_back:
                finish();
                break;
            case R.id.iv_edit:
                adapter.setViewType(EDIT_PAGER);
                adapter.notifyDataSetChanged();
                ivEdit.setVisibility(View.GONE);
                ivComplete.setVisibility(View.VISIBLE);
                adapter.checkNone(false);
                adapter.checkAll();
                adapter.showTotalPrice();
                break;
            case R.id.iv_complete:
                adapter.setViewType(COMPLETE_PAGER);
                adapter.notifyDataSetChanged();
                ivEdit.setVisibility(View.VISIBLE);
                ivComplete.setVisibility(View.GONE);
                adapter.checkNone(true);
                adapter.checkAll();
                adapter.showTotalPrice();
                break;
            case R.id.pay_tv:

                break;
        }
    }

}
