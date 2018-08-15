package com.meiji.yangshijie.myapplication_test.View;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.MainActivity;
import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.User_selectionActivity;
import com.meiji.yangshijie.myapplication_test.utils.MsgUtils;
import com.meiji.ysj.youxidating.Game1Activity;
import com.meiji.ysj.youxidating.GameActivity;

import static com.meiji.yangshijie.myapplication_test.MainActivity.startGameActivity;

/**
  *  描述：登录自定义对话框
  *  时间：2018/8/3 17:39
  **/

public class Dialoglogin extends Dialog implements View.OnClickListener {
    private Context context;




    private EditText edLoginName;
    private EditText edLoginPassword;
    private TextView tvLoginTv1;
    private TextView tvLoginTv2;
    private TextView tvLoginTv3;
    private Button tbLoginLogin;
    private ImageView btLoginXx;


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    ProgressDialog.Stop();
                    User_selectionActivity.activity.startActivity(new Intent(context,Game1Activity.class));
                    User_selectionActivity.activity.finish();
                    dismiss();
                    break;

            }
        }
    };






    public Dialoglogin(@NonNull Context context) {





        super(context);
        this.context=context;
    }

    public Dialoglogin(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected Dialoglogin(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);
        init();
    }

    /**
      *  描述：初始化一些配置
      *  时间：2018/8/3 17:48
      **/
    private void init() {

        /**
         *  描述：设置对话框大小
         *  时间：2018/8/3 17:39
         *
         **/

        edLoginName = (EditText) findViewById(R.id.ed_login_name);//账号
        edLoginPassword = (EditText) findViewById(R.id.ed_login_password);//密码
        tvLoginTv1 = (TextView) findViewById(R.id.tv_login_tv1);//立即注册
        tvLoginTv2 = (TextView) findViewById(R.id.tv_login_tv2);//忘记密码
        tvLoginTv3 = (TextView) findViewById(R.id.tv_login_tv3);//在线客服
        tbLoginLogin = (Button) findViewById(R.id.tb_login_login);//登录
        btLoginXx = (ImageView) findViewById(R.id.bt_login_xx);//关闭
        tvLoginTv1.setOnClickListener(this);
        tvLoginTv2.setOnClickListener(this);
        tvLoginTv3.setOnClickListener(this);
        btLoginXx.setOnClickListener(this);
        tbLoginLogin.setOnClickListener(this);


        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay(); //获取屏幕宽高
        Point point = new Point();
        display.getSize(point);

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes(); //获取当前对话框的参数值
        layoutParams.width = (int) (point.x * 0.8); //宽度设置为屏幕宽度的0.5
        layoutParams.height = (int) (point.y * 0.8); //高度设置为屏幕高度的0.5
//        layoutParams.width = (int) (display.getWidth() * 0.5);
//        layoutParams.height = (int) (display.getHeight() * 0.5);
        window.setAttributes(layoutParams);





    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_login_tv1://立即注册
                ShowRegisterDialog();
                break;
            case R.id.tv_login_tv2://忘记密码
                ShowForgetPasswordDialog();
                break;
            case R.id.tv_login_tv3://在线客服
                //
                break;
            case R.id.tb_login_login://登录
                login();
                break;
            case R.id.bt_login_xx://关闭
                this.dismiss();
                break;
        }
    }

    /**
      *  描述：登录逻辑
      *  时间：2018/8/8 16:28
      **/

    private void login() {


        /**
          *  描述：加载登录界面
          *  时间：2018/8/9 10:50
          **/
        ProgressDialog.Show(context);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendMessage(MsgUtils.getmsg(1,null));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }.start();


        /**
          *  描述：登录后的跳转
          *  时间：2018/8/9 10:51
          **/

        //startGameActivity();




    }

    /**
      *  描述：隐藏登录对话框，显示注册对话框
      *  时间：2018/8/8 16:26
      **/

    private void ShowRegisterDialog(){
        this.dismiss();
        RegisterDialog registerDialog=new RegisterDialog(context);
        registerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        registerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        registerDialog.show();
    }

    /**
      *  描述：隐藏登录对话框，显示忘记密码对话框
      *  时间：2018/8/8 16:27
      **/

    private void ShowForgetPasswordDialog(){
        this.dismiss();
        ForgetPasswordDialog forgetPasswordDialog=new ForgetPasswordDialog(context);
        forgetPasswordDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        forgetPasswordDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        forgetPasswordDialog.show();
    }
}
