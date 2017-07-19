package com.maxin.liang.shopcar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.maxin.liang.bean.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shkstart on 2017/7/19.
 */

public class CartStorage {
    private DBHelper helper;


    public CartStorage(DBHelper helper) {
        this.helper = helper;

    }
    public void addGoods(GoodsInfo info) {
        if (info != null) {
            ContentValues values = new ContentValues();
            values.put(TableConstant.GOODS_ID, info.getGoosId());
            values.put(TableConstant.GOODS_LOGO, info.getGoodsLogo());
            values.put(TableConstant.GOODS_NAME, info.getGoodsName());
            values.put(TableConstant.GOODS_PRICE, info.getGoodsPrice());
            values.put(TableConstant.GOODS_SHOP_ID, info.getGoodsShopId());
            values.put(TableConstant.GOODS_TYPE, info.getGoodsType());
            values.put(TableConstant.GOODS_URL, info.getGoodsUrl());
            values.put(TableConstant.GOODS_NUMBER, info.getGoodsNumber());
            values.put(TableConstant.GOODS_DISCOUNT_PRICE, info.getGoodsDiscountPrice());
            helper.getWritableDatabase().replace(TableConstant.TABLE_NAME, null, values);
        } else {
            throw new NullPointerException("添加数据异常, 传入的商品对象为空");
        }
    }
    public void deleteGoods(String goodsId) {
        if (!TextUtils.isEmpty(goodsId)) {
            String where = TableConstant.GOODS_ID + " =?";
            helper.getWritableDatabase().delete(TableConstant.TABLE_NAME, where, new String[]{goodsId});
        }
    }

    public GoodsInfo getGoods(String id) {
        if (TextUtils.isEmpty(id)) {
            throw new NullPointerException("从数据库获取数据异常, 传入的商品id为空");
        }

        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
        Cursor cursor = writableDatabase.query(TableConstant.TABLE_NAME, null, TableConstant.GOODS_ID + "=?",
                new String[]{id}, null, null, null);
        GoodsInfo goodsInfo = null;
        if (cursor != null) {
            goodsInfo = new GoodsInfo();
            String goodsId = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_ID));
            String goodsPrice = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_PRICE));
            String goodsType = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_TYPE));
            String goodsUrl = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_URL));
            String goodsLogo = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_LOGO));
            String goodsName = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_NAME));
            String goodsShopId = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_SHOP_ID));
            String goodsDiscountPrice = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_DISCOUNT_PRICE));
            int goodsNumber = cursor.getInt(cursor.getColumnIndex(TableConstant.GOODS_NUMBER));
            goodsInfo.setGoodsType(goodsType);
            goodsInfo.setGoodsLogo(goodsLogo);
            goodsInfo.setGoodsName(goodsName);
            goodsInfo.setGoodsNumber(goodsNumber);
            goodsInfo.setGoodsPrice(goodsPrice);
            goodsInfo.setGoodsShopId(goodsShopId);
            goodsInfo.setGoodsUrl(goodsUrl);
            goodsInfo.setSelected(true);
            goodsInfo.setGoosId(goodsId);
            goodsInfo.setGoosId(goodsDiscountPrice);
            cursor.close();
        }
        return goodsInfo;
    }

    public List<GoodsInfo> getAllGoods() {

        String sql = "select * from " + TableConstant.TABLE_NAME;
        Cursor cursor = helper.getWritableDatabase().rawQuery(sql, null);
        List<GoodsInfo> infos = new ArrayList<>();
        while (cursor.moveToNext()) {
            GoodsInfo goodsInfo = new GoodsInfo();
            String goodsId = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_ID));
            String goodsPrice = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_PRICE));
            String goodsType = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_TYPE));
            String goodsUrl = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_URL));
            String goodsLogo = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_LOGO));
            String goodsName = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_NAME));
            String goodsShopId = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_SHOP_ID));
            String goodsDiscountPrice = cursor.getString(cursor.getColumnIndex(TableConstant.GOODS_DISCOUNT_PRICE));
            int goodsNumber = cursor.getInt(cursor.getColumnIndex(TableConstant.GOODS_NUMBER));
            goodsInfo.setGoodsLogo(goodsLogo);
            goodsInfo.setGoodsName(goodsName);
            goodsInfo.setGoodsNumber(goodsNumber);
            goodsInfo.setGoodsPrice(goodsPrice);
            goodsInfo.setGoodsShopId(goodsShopId);
            goodsInfo.setGoodsUrl(goodsUrl);
            goodsInfo.setSelected(true);
            goodsInfo.setGoosId(goodsId);
            goodsInfo.setGoodsType(goodsType);
            goodsInfo.setGoodsDiscountPrice(goodsDiscountPrice);
            infos.add(goodsInfo);
        }
        cursor.close();
        return infos;
    }

    public void deleteAllGoods() {
        helper.getWritableDatabase().delete(TableConstant.TABLE_NAME, null, null);
    }

    public void updateGoods(String id, int number) {
        if (TextUtils.isEmpty(id)) {
            throw new NullPointerException("从数据库获取数据异常, 传入的商品id为空");
        }
        ContentValues values = new ContentValues();
        values.put(TableConstant.GOODS_NUMBER, number);
        helper.getWritableDatabase().update(TableConstant.TABLE_NAME,
                values,
                TableConstant.GOODS_ID + "=?", new String[]{id});
    }
}
