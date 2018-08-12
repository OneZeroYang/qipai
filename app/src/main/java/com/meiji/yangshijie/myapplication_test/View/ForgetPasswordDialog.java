package com.meiji.yangshijie.myapplication_test.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

import com.meiji.yangshijie.myapplication_test.R;

/**
  *  描述：忘记密码对话框
  *  时间：2018/8/8 13:44
  **/

public class ForgetPasswordDialog extends Dialog implements View.OnClickListener {
    private Context context;


    private EditText edForgetName;
    private EditText edForgetYzm;
    private TextView tvForgetGetyzm;
    private EditText edForgetPassword;
    private EditText edForgetPassword1;
    private TextView tvForgetGologin;
    private TextView tvForgetZaixiankefu;
    private Button btForgetRegister;
    private ImageView imForgetXx;

    public ForgetPasswordDialog(@NonNull Context context) {
        super(context);
        this.context=context;

    }

    public ForgetPasswordDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ForgetPasswordDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialig_forgetpassword);

        init();
    }


    /**
      *  描述：初始化对话框
      *  时间：2018/8/8 13:49
      **/
    private void init() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay(); //获取屏幕宽高
        Point point = new Point();
        display.getSize(point);

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes(); //获取当前对话框的参数值
        layoutParams.width = (int) (point.x * 0.9); //宽度设置为屏幕宽度的0.5
        layoutParams.height = (int) (point.y * 0.9); //高度设置为屏幕高度的0.5
//        layoutParams.width = (int) (display.getWidth() * 0.5);
//        layoutParams.height = (int) (display.getHeight() * 0.5);
        window.setAttributes(layoutParams);




        edForgetName = (EditText) findViewById(R.id.ed_forget_name);//账号
        edForgetYzm = (EditText) findViewById(R.id.ed_forget_yzm);//验证码
        tvForgetGetyzm = (TextView) findViewById(R.id.tv_forget_getyzm);//发送验证码
        edForgetPassword = (EditText) findViewById(R.id.ed_forget_password);//密码
        edForgetPassword1 = (EditText) findViewById(R.id.ed_forget_password1);//确认密码
        tvForgetGologin = (TextView) findViewById(R.id.tv_forget_gologin);//去登录
        tvForgetZaixiankefu = (TextView) findViewById(R.id.tv_forget_zaixiankefu);//在线客服
        btForgetRegister = (Button) findViewById(R.id.bt_forget_register);//改密
        imForgetXx = (ImageView) findViewById(R.id.im_forget_xx);//关闭


        tvForgetGetyzm.setOnClickListener(this);
        tvForgetGologin.setOnClickListener(this);
        tvForgetZaixiankefu.setOnClickListener(this);
        btForgetRegister.setOnClickListener(this);
        imForgetXx.setOnClickListener(this);






    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_forget_getyzm://发送
                send();
                break;
            case R.id.tv_forget_gologin://去登录
                ShowLoginDialog();
                break;
            case R.id.tv_forget_zaixiankefu://在线客服
                break;
            case R.id.bt_forget_register://改密
                Register();
                break;
            case R.id.im_forget_xx://关闭
                this.dismiss();
                break;
        }

    }

    /**
      *  描述：改密逻辑
      *  时间：2018/8/8 17:19
      **/
    private void Register() {

    }

    /**
      *  描述：隐藏，开始登录对话框
      *  时间：2018/8/8 17:19
      **/
    private void ShowLoginDialog() {
        this.dismiss();
        Dialoglogin dialoglogin=new Dialoglogin(context);
        dialoglogin.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialoglogin.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialoglogin.show();

    }

    /**
  *  描述：获取验证码
  *  时间：2018/8/8 17:18
  **/
    private void send() {

    }


}
