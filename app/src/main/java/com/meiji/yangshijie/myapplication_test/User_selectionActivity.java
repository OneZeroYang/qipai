package com.meiji.yangshijie.myapplication_test;


import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.meiji.yangshijie.myapplication_test.View.Dialoglogin;
import com.meiji.yangshijie.myapplication_test.View.ForgetPasswordDialog;
import com.meiji.yangshijie.myapplication_test.View.RegisterDialog;


public class User_selectionActivity extends BaseActivity implements View.OnClickListener {

    private ImageView loginLog;
    private Button loginBt1;
    private Button loginBt2;

    RegisterDialog registerDialog=null;//注册对口框

    Dialoglogin dialoglogin=null;//登录对话框


    public static Activity activity;



    @Override
    protected int setView() {
        return R.layout.activity_user_selection;
    }

    @Override
    protected void initViews() {
        activity=User_selectionActivity.this;
        loginLog = (ImageView) findViewById(R.id.login_log);
        loginBt1 = (Button) findViewById(R.id.login_bt1);
        loginBt2 = (Button) findViewById(R.id.login_bt2);
        loginBt1.setOnClickListener(this);
        loginBt2.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void Error(String s) {

    }

    /**
     * 描述：点击事件
     * 时间：2018/7/31 12:01
     **/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_bt1:
//                ToastUtils.showToast(getApplicationContext(), getResources().getString(R.string.login));
//                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                finish();
                showloginDialog();



                break;
            case R.id.login_bt2:
//                ToastUtils.showToast(getApplicationContext(), getResources().getString(R.string.register));
//                startActivity(new Intent(this, RegisterActivity.class));
//                finish();

                showRegisterDialog();
                break;
        }
    }
/**
  *  描述：注册对话框
  *  时间：2018/8/8 14:12
  **/
    private void showRegisterDialog() {
//        ForgetPasswordDialog registerDialog=new ForgetPasswordDialog(User_selectionActivity.this);
//        registerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        registerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
//        registerDialog.show();


        registerDialog=new RegisterDialog(User_selectionActivity.this);
        registerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        registerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        registerDialog.show();
    }

    /**
      *  描述：登录对话框
      *  时间：2018/8/8 11:18
      **/
    private void showloginDialog() {
        dialoglogin=new Dialoglogin(User_selectionActivity.this);
        dialoglogin.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialoglogin.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialoglogin.show();

    }
}
