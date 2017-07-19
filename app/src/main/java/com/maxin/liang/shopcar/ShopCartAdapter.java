package com.maxin.liang.shopcar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.GoodsInfoActivity;
import com.maxin.liang.bean.GoodsInfo;
import com.maxin.liang.view.AddSubView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.maxin.liang.fragment.shopfragment.TypeFragment.POSITION;

/**
 * Created by shkstart on 2017/7/19.
 */

public class ShopCartAdapter extends BaseAdapter {
    private final Context context;
    private final CheckBox allCheck;
    private final CartStorage dao;
    private int viewType;
    private final TextView payFeeTv;
    private final TextView saveFeeTv;
    private final List<GoodsInfo> items;



    public ShopCartAdapter(Context context, List<GoodsInfo> items, CheckBox allCheck, CartStorage dao, int viewType, TextView payFeeTv, TextView saveFeeTv) {
        this.context = context;
        this.items = items;
        this.allCheck = allCheck;
        this.dao = dao;
        this.viewType = viewType;
        this.payFeeTv = payFeeTv;
        this.saveFeeTv = saveFeeTv;
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = initView(items.get(i), viewType, view);
        return view;
    }

    private View initView(GoodsInfo goodsInfo, int viewType, View view) {
        if (viewType == 0) {
            view = View.inflate(context, R.layout.shopping_car_item, null);
            DefultHorlder defultHorlder = new DefultHorlder(context, view);
            defultHorlder.setData(goodsInfo);
        } else if (viewType == 1) {
            view = View.inflate(context, R.layout.shopping_car_edit_item, null);
            EditHorlder editHorlder = new EditHorlder(context, view);
            editHorlder.setData(goodsInfo);
        }
        return view;
    }

    public void checkNone(boolean checked) {
        if (items != null && items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                GoodsInfo goodsInfo = items.get(i);
                goodsInfo.setSelected(checked);

            }
        }
    }

    public void setViewType(int editPager) {
        this.viewType=editPager;
    }

    class DefultHorlder {
        @Bind(R.id.cb_gov)
        CheckBox cbGov;
        @Bind(R.id.iv_gov)
        ImageView ivGov;
        @Bind(R.id.tv_desc_gov)
        TextView tvDescGov;
        @Bind(R.id.ll_size)
        TextView llSize;
        @Bind(R.id.tv_price_gov)
        TextView tvPriceGov;
        @Bind(R.id.tv_discount_price)
        TextView tvDiscountPrice;
        @Bind(R.id.tv_goods_number)
        TextView tvGoodsNumber;
        @Bind(R.id.ll_goods_car)
        LinearLayout llGoodsCar;

        private final Context context;

        public DefultHorlder(Context context, View view) {
            this.context = context;
            ButterKnife.bind(this, view);
        }

        public void setData(final GoodsInfo goodsInfo) {
            String goodsType = goodsInfo.getGoodsType();
            if (!TextUtils.isEmpty(goodsType)) {
                llSize.setText(goodsType);
            }
            cbGov.setChecked(goodsInfo.isSelected());
            cbGov.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goodsInfo.setSelected(!goodsInfo.isSelected());
                    notifyDataSetChanged();
                    showTotalPrice();
                    checkAll();
                }
            });
            tvDescGov.setText(goodsInfo.getGoodsName());
            Glide.with(context).load(goodsInfo.getGoodsLogo()).into(ivGov);

            tvGoodsNumber.setText("x " + goodsInfo.getGoodsNumber());
            if (TextUtils.isEmpty(goodsInfo.getGoodsDiscountPrice())) {
                tvDiscountPrice.setVisibility(View.GONE);
                tvPriceGov.setText("￥" + goodsInfo.getGoodsPrice());
            } else {
                tvPriceGov.setText("￥" + goodsInfo.getGoodsDiscountPrice());
                tvDiscountPrice.setText("￥" + goodsInfo.getGoodsPrice());
                tvDiscountPrice.getPaint().
                        setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
            }
            llGoodsCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, GoodsInfoActivity.class).putExtra(POSITION, goodsInfo.getGoosId()));
                }
            });
        }
    }

    public void checkAll() {
        if (items != null && items.size() > 0) {
            int num = 0;
            for (int i = 0; i < items.size(); i++) {
                if (!items.get(i).isSelected()) {
                    allCheck.setChecked(false);
                } else {
                    num++;
                }
            }
            if (num == items.size()) {
                allCheck.setChecked(true);
            }
        } else {
            allCheck.setChecked(false);
        }
    }

    private double getTotalFee() {
        double value = 0;
        double preValue = 0;
        if (items != null && items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).isSelected()) {
                    preValue += Double.parseDouble(items.get(i).getGoodsPrice());
                    if (TextUtils.isEmpty(items.get(i).getGoodsDiscountPrice())) {
                        value += Double.parseDouble(items.get(i).getGoodsPrice()) * items.get(i).getGoodsNumber();
                    } else {
                        value += Double.parseDouble(items.get(i).getGoodsDiscountPrice()) * items.get(i).getGoodsNumber();
                    }
                }
            }
            saveFeeTv.setText("￥" + (preValue - value));
        }
        return value;
    }

    public void showTotalPrice() {
        payFeeTv.setText("￥" + getTotalFee() + "");
    }

    class EditHorlder {
        @Bind(R.id.cb_gov)
        CheckBox cbGov;
        @Bind(R.id.iv_gov)
        ImageView ivGov;
        @Bind(R.id.AddSubView)
        com.maxin.liang.view.AddSubView addSubView;
        @Bind(R.id.tv_desc_gov_edit)
        TextView tvDescGovEdit;
        @Bind(R.id.tv_price_gov)
        TextView tvPriceGov;
        @Bind(R.id.tv_discount_price)
        TextView tvDiscountPrice;
        @Bind(R.id.ll_goods_car)
        LinearLayout llGoodsCar;
        @Bind(R.id.bt_delete)
        Button btDelete;
        private final Context context;

        public EditHorlder(Context context, View view) {
            this.context = context;
            ButterKnife.bind(this,view);
        }

        public void setData(final GoodsInfo goodsInfo) {
            cbGov.setChecked(goodsInfo.isSelected());
            cbGov.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goodsInfo.setSelected(!goodsInfo.isSelected());
                    notifyDataSetChanged();
                    showTotalPrice();
                    checkAll();
                }
            });
            addSubView.setMaxValue(Integer.MAX_VALUE);
            addSubView.setValue(goodsInfo.getGoodsNumber());

            addSubView.setOnNumberChangeListener(new AddSubView.OnNumberChangeListener() {
                @Override
                public void numberChange(int number) {
                    goodsInfo.setGoodsNumber(number);
                    dao.updateGoods(goodsInfo.getGoosId(), number);

                    showTotalPrice();
                }
            });
            btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    items.remove(goodsInfo);
                    dao.deleteGoods(goodsInfo.getGoosId());
                    notifyDataSetChanged();
                }
            });
            tvDescGovEdit.setText(goodsInfo.getGoodsName());
            Glide.with(context).load(goodsInfo.getGoodsLogo()).into(ivGov);

            if (TextUtils.isEmpty(goodsInfo.getGoodsDiscountPrice())) {
                tvDiscountPrice.setVisibility(View.GONE);
                tvPriceGov.setText("￥" + goodsInfo.getGoodsPrice());
            } else {
                tvPriceGov.setText("￥" + goodsInfo.getGoodsDiscountPrice());
                tvDiscountPrice.setText("￥" + goodsInfo.getGoodsPrice());
                tvDiscountPrice.getPaint().
                        setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
            }
            llGoodsCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, GoodsInfoActivity.class).putExtra(POSITION, goodsInfo.getGoosId()));
                }
            });
        }
    }


}
