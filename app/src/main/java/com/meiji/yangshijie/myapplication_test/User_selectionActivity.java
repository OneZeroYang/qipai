package com.meiji.yangshijie.myapplication_test;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.meiji.yangshijie.myapplication_test.register.LoginActivity;
import com.meiji.yangshijie.myapplication_test.utils.ToastUtils;


public class User_selectionActivity extends BaseActivity implements View.OnClickListener {

    private ImageView loginLog;
    private Button loginBt1;
    private Button loginBt2;




    @Override
    protected int setView() {
        return R.layout.activity_user_selection;
    }

    @Override
    protected void initViews() {
        loginLog = (ImageView) findViewById(R.id.login_log);
        loginBt1 = (Button) findViewById(R.id.login_bt1);
        loginBt2 = (Button) findViewById(R.id.login_bt2);
        loginBt1.setOnClickListener(this);
        loginBt2.setOnClickListener(this);

    }

    @Override
    protected void initData() {



    }


    /**
      *  描述：点击事件
      *  时间：2018/7/31 12:01
      **/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_bt1:
                ToastUtils.showToast(getApplicationContext(),getResources().getString(R.string.login));
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
                break;
            case R.id.login_bt2:
                ToastUtils.showToast(getApplicationContext(),getResources().getString(R.string.register));
                //startActivity(new Intent());
                break;
        }
    }
}
