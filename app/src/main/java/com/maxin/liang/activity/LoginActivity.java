package com.maxin.liang.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.maxin.liang.R;
import com.maxin.liang.common.Modle;
import com.maxin.liang.login.UserInfo;

import butterknife.Bind;
import butterknife.OnClick;

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

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.login_back, R.id.btn_zhuce, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.btn_zhuce:
                final String username = etZhanghao.getText().toString().trim();
                final String pwd = etMima.getText().toString().trim();

                //校验
                if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(username)){
                    showToast("用户名或密码不能为空");
                    return;
                }

                Modle.getInstance().getGlobalThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            EMClient.getInstance().createAccount(username,pwd);
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
        }
    }
}
