package com.maxin.liang.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.maxin.liang.R;
import com.maxin.liang.common.Modle;
import com.maxin.liang.login.UserInfo;
import com.maxin.liang.utils.CountDownTimerUtils;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

import static com.maxin.liang.utils.UiUtils.showToast;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.login_back)
    ImageView loginBack;
    @Bind(R.id.et_zhanghao)
    EditText etZhanghao;
    @Bind(R.id.et_mima)
    EditText etMima;
    @Bind(R.id.btn_zhuce)
    Button btnZhuce;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.iv_qq_login)
    ImageView ivQqLogin;
    @Bind(R.id.tv_yanzhengma)
    TextView tvYanzhengma;

    @Override
    public void initView() {
        super.initView();

    }

    @Override
    public void initListener() {
        tvYanzhengma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(tvYanzhengma, 60000, 1000);
                mCountDownTimerUtils.start();


                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
                        // 解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked") HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");
                           // Log.d(TAG, "opeRegisterPager()--country=" + country + "--phone" + phone);
                        }
                    }
                });
                //registerPage.show(LoginActivity.this);
                SMSSDK.getVerificationCode("+86", etZhanghao.getText()+"");
            }


        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.login_back, R.id.btn_zhuce, R.id.btn_login, R.id.iv_qq_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.btn_zhuce:
                final String username = etZhanghao.getText().toString().trim();
                final String pwd = etMima.getText().toString().trim();

                //校验
                if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(username)) {
                    showToast("用户名或密码不能为空");
                    return;
                }

                Modle.getInstance().getGlobalThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            EMClient.getInstance().createAccount(username, pwd);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (final HyphenateException e) {
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showToast(e.getMessage());
                                }
                            });
                        }
                    }
                });

                break;
            case R.id.btn_login:
                //获取输入的值
                final String pwds = etMima.getText().toString().trim();
                final String usernames = etZhanghao.getText().toString().trim();

                if (TextUtils.isEmpty(pwds) || TextUtils.isEmpty(usernames)) {
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //连网
                Modle.getInstance().getGlobalThread().execute(new Runnable() {
                    @Override
                    public void run() {

                        EMClient.getInstance().login(usernames, pwds, new EMCallBack() {
                            @Override
                            public void onSuccess() {
                                //登录成功 处理一些特殊的信息
                                String currentUser = EMClient.getInstance().getCurrentUser();

                                Modle.getInstance().loginSuccess(new UserInfo(currentUser, currentUser));
                                //跳转界面
                                // startActivity(new Intent(LoginActivity.this, MainActivity.class));

                                //结束当前页面
                                finish();
                            }

                            @Override
                            public void onError(int i, final String s) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onProgress(int i, String s) {

                            }
                        });
                    }
                });
                break;

            case R.id.iv_qq_login:
                Platform weibo = ShareSDK.getPlatform(QQ.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                weibo.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        arg0.getDb().exportData();
                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
                //authorize与showUser单独调用一个即可
                weibo.authorize();//单独授权,OnComplete返回的hashmap是空的
                weibo.showUser(null);//授权并获取用户信息
                //移除授权
                //weibo.removeAccount(true);

                finish();
                break;
        }
    }



}
