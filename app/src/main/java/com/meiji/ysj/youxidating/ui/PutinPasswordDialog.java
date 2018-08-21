package com.meiji.ysj.youxidating.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.meiji.utils.DialogUtils;
import com.meiji.utils.MsgUtils;
import com.meiji.yangshijie.login.R;

import com.meiji.yangshijie.login.view.BaesDialog;
import com.meiji.yangshijie.login.view.ProgressDialog;

public class PutinPasswordDialog extends BaesDialog implements TextWatcher {
    private Context context;
    private Activity activity;


    private EditText edPutinEd1;
    private EditText edPutinEd2;
    private EditText edPutinEd3;
    private EditText edPutinEd4;
    private EditText edPutinEd5;
    private EditText edPutinEd6;
    private TextView tvPutinForgetPassword;
    private TextView tvPutinMimacuowu;


    private Handler handler;

    public PutinPasswordDialog(@NonNull Context context) {
        super(context);
        this.context=context;
        activity=RechargePutForwardDialog.activity;
    }

    public PutinPasswordDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected PutinPasswordDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.putinpassword_dialog;
    }

    @Override
    protected void init() {


        handler=new Handler(){

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        ProgressDialog.Stop();
                        PutinPasswordDialog.this.dismiss();
                        break;
                    case 2:
                        tvPutinMimacuowu.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        edPutinEd1 = (EditText) findViewById(R.id.ed_putin_ed1);
        edPutinEd2 = (EditText) findViewById(R.id.ed_putin_ed2);
        edPutinEd3 = (EditText) findViewById(R.id.ed_putin_ed3);
        edPutinEd4 = (EditText) findViewById(R.id.ed_putin_ed4);
        edPutinEd5 = (EditText) findViewById(R.id.ed_putin_ed5);
        edPutinEd6 = (EditText) findViewById(R.id.ed_putin_ed6);
        tvPutinForgetPassword = (TextView) findViewById(R.id.tv_putin_forget_password);
        tvPutinMimacuowu = (TextView) findViewById(R.id.tv_putin_mimacuowu);
        tvPutinMimacuowu.setVisibility(View.GONE);
       // View.VISIBLE;

        edPutinEd1.addTextChangedListener(this);
        edPutinEd2.addTextChangedListener(this);
        edPutinEd3.addTextChangedListener(this);
        edPutinEd4.addTextChangedListener(this);
        edPutinEd5.addTextChangedListener(this);
        edPutinEd6.addTextChangedListener(this);


        edPutinEd1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPutinEd2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPutinEd3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPutinEd4.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPutinEd5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPutinEd6.setTransformationMethod(PasswordTransformationMethod.getInstance());
        tvPutinForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //忘记密码
            }
        });


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.toString().length() == 1) {

            if (edPutinEd1.isFocused()) {
                edPutinEd1.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd2);


            } else if (edPutinEd2.isFocused()) {

                //yic(edPasswordEd2);
                edPutinEd2.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd3);


            } else if (edPutinEd3.isFocused()) {

                edPutinEd3.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd4);


            } else if (edPutinEd4.isFocused()) {

                edPutinEd4.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd5);

            } else if (edPutinEd5.isFocused()) {

                edPutinEd5.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd6);

            } else if (edPutinEd6.isFocused()) {

                //edPasswordEd6.clearFocus();
                ProgressDialog.Show(context);
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.sendMessage(MsgUtils.getmsg(1,null));


                    }
                }.start();


                Log.i("测试", "输入完成");
            }
        } else if (editable.toString().length() == 0) {

            if (edPutinEd1.isFocused()) {
                edPutinEd1.clearFocus();

            } else if (edPutinEd2.isFocused()) {

                //yic(edPasswordEd2);
                edPutinEd2.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd1);


            } else if (edPutinEd3.isFocused()) {

                edPutinEd3.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd2);


            } else if (edPutinEd4.isFocused()) {

                edPutinEd4.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd3);

            } else if (edPutinEd5.isFocused()) {

                edPutinEd5.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd4);

            } else if (edPutinEd6.isFocused()) {

                edPutinEd6.clearFocus();
                showSoftInputFromWindow(activity, edPutinEd5);

            }

        }


    }


    /**
     *  描述：跳转焦点
     *  时间：2018/8/21 15:51
     **/
    public void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        //activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        //上行代码有BUG
    }


    public static void Show(Context context){
        PutinPasswordDialog putinPasswordDialog=new PutinPasswordDialog(context);
        DialogUtils.Show(putinPasswordDialog);
    }

}
