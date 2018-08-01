package com.meiji.yangshijie.myapplication_test.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.meiji.yangshijie.myapplication_test.BaseActivity;
import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.utils.ToastUtils;

/**
 *  描述：忘记密码界面
 *  时间：2018/7/31 15:44
 **/

public class ForgetpasswordActivity extends BaseActivity implements View.OnClickListener {

    private EditText forgetPswEd1;
    private EditText forgetPswEd2;
    private Button forgetPswBt1;
    private EditText forgetPswEd3;
    private EditText forgetPswEd4;
    private LinearLayout forgetPswLi1;
    private LinearLayout forgetPswLi2;
    private Button forgetPswBt2;




    @Override
    protected int setView() {
        return R.layout.activity_forgetpassword;
    }

    @Override
    protected void initViews() {
        forgetPswEd1 = (EditText) findViewById(R.id.forget_psw_ed1);
        forgetPswEd2 = (EditText) findViewById(R.id.forget_psw_ed2);
        forgetPswBt1 = (Button) findViewById(R.id.forget_psw_bt1);
        forgetPswEd3 = (EditText) findViewById(R.id.forget_psw_ed3);
        forgetPswEd4 = (EditText) findViewById(R.id.forget_psw_ed4);
        forgetPswLi1 = (LinearLayout) findViewById(R.id.forget_psw_li1);
        forgetPswLi2 = (LinearLayout) findViewById(R.id.forget_psw_li2);
        forgetPswBt2 = (Button) findViewById(R.id.forget_psw_bt2);
        forgetPswBt1.setOnClickListener(this);
        forgetPswLi1.setOnClickListener(this);
        forgetPswLi2.setOnClickListener(this);
        forgetPswBt2.setOnClickListener(this);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void Error(String s) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forget_psw_bt1:
                //发送验证码

                /**
                  *  描述：模拟发送成功
                  *  时间：2018/7/31 16:39
                  **/


                updataUI();
                break;
            case R.id.forget_psw_li1:
                finish();
                break;
            case R.id.forget_psw_li2:
                break;
            case R.id.forget_psw_bt2:
                break;
        }

    }
/**
  *  描述：发送成功的UI更新
  *  时间：2018/7/31 16:42
  **/
    private void updataUI() {


        ToastUtils.showToast(getApplicationContext(),"发送成功！注意查收");
        forgetPswBt1.setEnabled(false);
        new Thread(){
            @Override
            public void run() {
                for (int a=60;a>0;a--){
                   final int b=a-1;
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (b+1==1){
                                    forgetPswBt1.setText(getString(R.string.forget_bt1));
                                    forgetPswBt1.setEnabled(true);

                                }else {
                                    forgetPswBt1.setText(""+b);
                                }


                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }
}
