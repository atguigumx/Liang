package com.maxin.liang.shopcar;


public class TableConstant {
    public final static String TABLE_NAME = "goodsList";
    public final static String GOODS_ID = "_goodsId";
    public final static String GOODS_TYPE = "goodsType";
    public final static String GOODS_NAME = "goodsName";
    public final static String GOODS_SHOP_ID = "goodsShopId";
    public final static String GOODS_URL = "goodsUrl";
    public final static String GOODS_LOGO = "goodsLogo";
    public final static String GOODS_PRICE = "goodsPrice";
    public final static String GOODS_NUMBER = "goodsNumber";
    public final static String GOODS_DISCOUNT_PRICE = "goodsDiscountPrice";

    public final static String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + GOODS_ID + " text primary key, "
            + GOODS_NUMBER + " integer, "
            + GOODS_TYPE + " text, "
            + GOODS_DISCOUNT_PRICE + " text, "
            + GOODS_NAME + " text, "
            + GOODS_SHOP_ID + " text, "
            + GOODS_URL + " text, "
            + GOODS_PRICE + " text, "
            + GOODS_LOGO + " text)";


}
