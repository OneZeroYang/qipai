package com.meiji.yangshijie.myapplication_test.register;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.meiji.yangshijie.myapplication_test.BaseActivity;
import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.utils.DialogUtil;
import com.meiji.yangshijie.myapplication_test.utils.ToastUtils;

/**
 * 描述：登录Activity
 * 时间：2018/7/31 13:43
 **/
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText loginEdName;
    private EditText loginEdPassword;
    private LinearLayout loginLi1;
    private LinearLayout loginLi2;
    private LinearLayout loginLi3;
    private Button loginBt1;

    @Override
    protected int setView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        loginEdName = (EditText) findViewById(R.id.login_ed_name);
        loginEdPassword = (EditText) findViewById(R.id.login_ed_password);
        loginLi1 = (LinearLayout) findViewById(R.id.login_li1);
        loginLi2 = (LinearLayout) findViewById(R.id.login_li2);
        loginLi3 = (LinearLayout) findViewById(R.id.login_li3);
        loginBt1 = (Button) findViewById(R.id.login_bt1);
        loginEdName.setOnClickListener(this);
        loginEdPassword.setOnClickListener(this);
        loginLi1.setOnClickListener(this);
        loginLi2.setOnClickListener(this);
        loginLi3.setOnClickListener(this);
        loginBt1.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void Error(String s) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_ed_name:
                break;
            case R.id.login_ed_password:
                break;
            case R.id.login_li1://注册
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.login_li2://忘记密码
                startActivity(new Intent(getApplicationContext(), ForgetpasswordActivity.class));
                break;
            case R.id.login_li3://客服
                break;
            case R.id.login_bt1://登录
                login();
                break;
        }
    }

    /**
     * 描述：登录函数
     * 时间：2018/7/31 15:35
     **/
    private void login() {
        String name = loginEdName.getText().toString().trim();
        String password = loginEdPassword.getText().toString().trim();
        if (name.equals("") || password.equals("")) {
            ToastUtils.showToast(this, getString(R.string.login_tishi1));
        } else {
            //登录逻辑



            //正在登录时的对话框
            DialogUtil dialog = new DialogUtil(LoginActivity.this);
            dialog.CreateProgressDialg();
            dialog.ShowProgressDialg();
        }
    }


}
