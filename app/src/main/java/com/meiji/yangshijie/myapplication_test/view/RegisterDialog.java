package com.meiji.yangshijie.myapplication_test.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.utils.MsgUtils;
import com.meiji.utils.ToastUtils;


/**
  *  描述：注册对话框
  *  时间：2018/8/8 14:59
  **/

public class RegisterDialog extends BaesDialog implements View.OnClickListener {
    private Context context;


    private EditText edRegisterName;
    private EditText edRegisterPassword;
    private EditText edRegisterPassword1;
    private EditText edRegisterDaili;
    private EditText edRegisterYzm;
    private TextView tvRegisterSend;
    private CheckBox ckRegisterCk;
    private TextView tvRegisterKaihutiaoyue;
    private TextView tvRegisterGologin;
    private Button btRegisterRegister;
    private ImageView imRegisterXx;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    tvRegisterSend.setText((int)msg.obj+"");
                    tvRegisterSend.setEnabled(false);
                    break;
                case 2:
                    tvRegisterSend.setText("发送");
                    tvRegisterSend.setEnabled(true);
                    break;
                case 3:
                    ProgressDialog.Stop();
                    ToastUtils.showToast(context,"发送成功，请注意查收！");
                    break;
            }
        }
    };


    public RegisterDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public RegisterDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RegisterDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.dialog_register;
    }

    @Override
    protected void init() {

        edRegisterName = (EditText) findViewById(R.id.ed_register_name);//手机号码、账号
        edRegisterPassword = (EditText) findViewById(R.id.ed_register_password);//密码
        edRegisterPassword1 = (EditText) findViewById(R.id.ed_register_password1);//第二次密码
        edRegisterDaili = (EditText) findViewById(R.id.ed_register_daili);//代理邀请码
        edRegisterYzm = (EditText) findViewById(R.id.ed_register_yzm);//验证码
        tvRegisterSend = (TextView) findViewById(R.id.tv_register_send);//发送验证码
        ckRegisterCk = (CheckBox) findViewById(R.id.ck_register_ck);//同意注册条约
        tvRegisterKaihutiaoyue = (TextView) findViewById(R.id.tv_register_kaihutiaoyue);//开户条约
        tvRegisterGologin = (TextView) findViewById(R.id.tv_register_gologin);//去登录
        btRegisterRegister = (Button) findViewById(R.id.bt_register_register);//注册
        imRegisterXx = (ImageView) findViewById(R.id.im_register_xx);//关闭对话框

        imRegisterXx.setOnClickListener(this);
        tvRegisterSend.setOnClickListener(this);
        tvRegisterKaihutiaoyue.setOnClickListener(this);
        tvRegisterGologin.setOnClickListener(this);
        btRegisterRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        switch (view.getId()){
            case R.id.im_register_xx://关掉对话框
                this.dismiss();
                break;
            case R.id.tv_register_send://发送验证码
                if (edRegisterName.getText().toString().equals("")){
                    ToastUtils.showToast(context,"手机号不能为空！");
                    return;
                }
                String s = tvRegisterSend.getText().toString();
                if (s.equals("发送")){
                    send();
                }else {
                    //Log.i(TAG, "onClick: "+"发送太频繁");
                    ToastUtils.showToast(context,"发送太频繁");
                }

                break;
            case R.id.tv_register_kaihutiaoyue://开户条约
                ShowTreatyDialog();
                break;
            case R.id.tv_register_gologin://去登陆
                ShowLoginDialog();
                break;
            case R.id.bt_register_register://注册
                Register();
                break;
        }
    }

    /**
      *  描述：注册逻辑
      *  时间：2018/8/8 16:51
      **/
    private void Register() {

    }

    /**
  *  描述：隐藏注册对话框，显示登录对话框
  *  时间：2018/8/8 16:48
  **/
    private void ShowLoginDialog() {
        this.dismiss();
        Dialoglogin dialoglogin=new Dialoglogin(context);
        dialoglogin.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialoglogin.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialoglogin.show();
    }

    /**
      *  描述：隐藏注册对话框，显示用户条约对话框
      *  时间：2018/8/8 16:47
      **/
    private void ShowTreatyDialog() {
        this.dismiss();
        TreatyDialog treatyDialog=new TreatyDialog(context);
        treatyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        treatyDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        treatyDialog.show();
    }

    /**
      *  描述：发送验证码
      *  时间：2018/8/8 16:46
      **/
    private void send() {
        ProgressDialog.Show(context);
        new Thread(){
            @Override
            public void run() {
                for (int a=60;a>0;a--){
                    try {
                        Thread.sleep(1000);
                        if (a==60){
                            handler.sendMessage(MsgUtils.getmsg(3,null));
                        }

                        handler.sendMessage(MsgUtils.getmsg(1,a));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendMessage(MsgUtils.getmsg(2,null));
            }
        }.start();

    }
}
