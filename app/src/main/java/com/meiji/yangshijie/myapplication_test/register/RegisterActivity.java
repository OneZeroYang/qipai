package com.meiji.yangshijie.myapplication_test.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.BaseActivity;
import com.meiji.yangshijie.myapplication_test.R;

import static android.content.ContentValues.TAG;

/**
  *  描述：注册界面
  *  时间：2018/8/1 9:39
  **/

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private EditText registerEd1;
    private EditText registerEd2;
    private EditText registerEd3;
    private EditText registerEd4;
    private EditText registerEd5;
    private TextView registerTv1;
    private CheckBox registerCb1;
    private TextView registerTv2;
    private TextView registerTv3;
    private Button registerBt1;
    private int[] b=new int[4];//随机验证码




    @Override
    protected int setView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initViews() {
        registerEd1 = (EditText) findViewById(R.id.register_ed1);//手机邮箱
        registerEd2 = (EditText) findViewById(R.id.register_ed2);//第一次输入密码
        registerEd3 = (EditText) findViewById(R.id.register_ed3);//再次输入的密码
        registerEd4 = (EditText) findViewById(R.id.register_ed4);//代理邀请码
        registerEd5 = (EditText) findViewById(R.id.register_ed5);//随机验证码
        registerTv1 = (TextView) findViewById(R.id.register_tv1);//随机验证码显示处
        registerCb1 = (CheckBox) findViewById(R.id.register_cb1);//注册协议勾选框
        registerTv2 = (TextView) findViewById(R.id.register_tv2);//注册协议
        registerTv3 = (TextView) findViewById(R.id.register_tv3);//去登陆
        registerBt1 = (Button) findViewById(R.id.register_bt1);//注册按钮
        registerTv1.setOnClickListener(this);
        registerTv2.setOnClickListener(this);
        registerTv3.setOnClickListener(this);
        registerBt1.setOnClickListener(this);


        inityzm();



    }
/**
  *  描述：初始化验证码
  *  时间：2018/8/1 10:18
  **/
    private void inityzm() {


        for (int a=0;a<4;a++){
            b[a]=(int)(Math.random()*9);
        }
        registerTv1.setText(""+b[0]+b[1]+b[2]+b[3]);
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
            case R.id.register_tv1://更换验证码
                inityzm();
                break;
            case R.id.register_tv2://注册条约
                startActivity(new Intent(getApplicationContext(),AgreementActivity.class));

                break;
            case R.id.register_tv3://去登陆
                finish();
                break;
            case R.id.register_bt1://注册
                register();
                break;
        }

    }
/**
  *  描述：注册函数
  *  时间：2018/8/1 10:35
  **/
    private void register() {
        String phone = registerEd1.getText().toString();
        String password = registerEd2.getText().toString();
        String password2 = registerEd3.getText().toString();
        String daili = registerEd4.getText().toString();
        String yzm = registerEd5.getText().toString();//随机验证码
         if (!phone.equals("")&&phone!=null){
             
             if (!password.equals("")&&password!=null){
                 if (!password2.equals("")&&password2!=null){
                     if (password.equals(password2)){
                         if (!daili.equals("")&&daili!=null){//代理可能要验证长度
                             if (yzm.equals(new String(""+b[0]+b[1]+b[2]+b[3]))){
                                 if (registerCb1.isChecked()){
                                     //验证通过。。。。注册逻辑
                                     Log.i(TAG, "register: ");
                                     
                                 }else {
                                     //用户没有同意注册协议
                                 }
                             }else {
                                 //随机验证码不对
                             }
                         }else {
                             //代理码出问题了
                         }
                         
                     }else {
                         //先后密码不一致
                     }
                     
                 }else {
                     //第二次密码空了
                 }
                 
                 
             }else {
                 //密码空了
             }
         }else {
             //手机号码空
         }

    }


}
