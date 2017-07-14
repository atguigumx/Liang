package com.maxin.liang.common;

import android.content.Context;

import com.maxin.liang.login.AccountDAO;
import com.maxin.liang.login.UserInfo;

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
        /*if(manager!=null) {
            manager.close();
        }
        //创建manager
        manager = new HelperManager(context, userInfo.getUsername() + ".db");

        //初始化SPUtils
        SPUtils.getSPUtils().init(context,userInfo.getUsername());*/
    }

    public AccountDAO getAccountDAO(){
        return accountDAO;
    }
    //返回manager
   /* public HelperManager getHelperManager(){
        return manager;
    }*/
}
