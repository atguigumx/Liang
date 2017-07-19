package com.maxin.liang.shopcar;

import android.content.Context;


public class DBHelperManager {
    private DBHelper helper;
    private CartStorage shoppingCarDao;

    public DBHelperManager(Context mContext, String name) {
        helper = new DBHelper(mContext, name);
        shoppingCarDao = new CartStorage(helper);
    }

    public CartStorage getShoppingCarDao() {
        return shoppingCarDao;
    }

    public void close() {
        if (helper != null) {
            helper.close();
        }
    }
}
