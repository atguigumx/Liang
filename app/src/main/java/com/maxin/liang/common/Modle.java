package com.maxin.liang.common;

import android.content.Context;

import com.maxin.liang.login.AccountDAO;
import com.maxin.liang.login.UserInfo;
import com.maxin.liang.shopcar.DBHelperManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shkstart on 2017/7/1.
 */

public class Modle {
    private Context context;
    private AccountDAO accountDAO;

    private Modle(){}
    private static Modle modle=new Modle();
    private DBHelperManager manager;
    public static Modle getInstance(){
        return modle;
    }
    public void init(Context context){
        this.context=context;
        accountDAO=new AccountDAO(context);

        //new GlobalListener(context);
    }
    private ExecutorService service=Executors.newCachedThreadPool();
    public ExecutorService getGlobalThread(){
        return service;
    }
    //登录成功以后保存用户数据
    public void loginSuccess(UserInfo userInfo) {
        //添加用户
        accountDAO.addAccount(userInfo);
        if (manager != null) {
            manager.close();
        }
        manager = new DBHelperManager(context, userInfo.getUsername() + ".db");
    }

    public AccountDAO getAccountDAO(){
        return accountDAO;
    }
    public DBHelperManager getManager() {
        return manager;
    }
}
