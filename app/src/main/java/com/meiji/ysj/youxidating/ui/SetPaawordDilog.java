package com.meiji.ysj.youxidating.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;


import com.meiji.utils.DialogUtils;
import com.meiji.utils.ToastUtils;
import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;

/**
  *  描述：设置提现密码
  *  时间：2018/8/21 13:43
  **/
public class SetPaawordDilog extends BaesDialog implements TextWatcher, View.OnClickListener {

    private EditText edPasswordEd1;
    private EditText edPasswordEd2;
    private EditText edPasswordEd3;
    private EditText edPasswordEd4;
    private EditText edPasswordEd5;
    private EditText edPasswordEd6;
    private ImageView imSetPasswordShow;
    private ImageView imSetPasswordVvv;
    private ImageView imSetPasswordButton;

    private Activity activity;

    private Context context;

    public SetPaawordDilog(@NonNull Context context) {
        super(context);
        this.context=context;
        activity=RechargePutForwardDialog.activity;


  //      edRechargeEd.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);//只能输入数字和小数
    }

    public SetPaawordDilog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SetPaawordDilog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.setpaaword_dilog;
    }

    @Override
    protected void init() {



        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay(); //获取屏幕宽高
        Point point = new Point();
        display.getSize(point);

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes(); //获取当前对话框的参数值
        layoutParams.width = (int) (point.x * 0.7); //宽度设置为屏幕宽度的0.5
        layoutParams.height = (int) (point.y * 0.6); //高度设置为屏幕高度的0.5
//        layoutParams.width = (int) (display.getWidth() * 0.5);
//        layoutParams.height = (int) (display.getHeight() * 0.5);
        window.setAttributes(layoutParams);




        edPasswordEd1 = (EditText) findViewById(R.id.ed_password_ed1);//密码输入框
        edPasswordEd2 = (EditText) findViewById(R.id.ed_password_ed2);
        edPasswordEd3 = (EditText) findViewById(R.id.ed_password_ed3);
        edPasswordEd4 = (EditText) findViewById(R.id.ed_password_ed4);
        edPasswordEd5 = (EditText) findViewById(R.id.ed_password_ed5);
        edPasswordEd6 = (EditText) findViewById(R.id.ed_password_ed6);
        edPasswordEd1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);//只能输入数字和小数
        edPasswordEd2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);//只能输入数字和小数
        edPasswordEd3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);//只能输入数字和小数
        edPasswordEd4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);//只能输入数字和小数
        edPasswordEd5.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);//只能输入数字和小数
        edPasswordEd6.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);//只能输入数字和小数
        imSetPasswordShow = (ImageView) findViewById(R.id.im_set_password_show);//显示密码
        imSetPasswordVvv = (ImageView) findViewById(R.id.im_set_password_vvv);//隐藏密码
        imSetPasswordButton = (ImageView) findViewById(R.id.im_set_password_button);//确定

        edPasswordEd1.addTextChangedListener(this);
        edPasswordEd2.addTextChangedListener(this);
        edPasswordEd3.addTextChangedListener(this);
        edPasswordEd4.addTextChangedListener(this);
        edPasswordEd5.addTextChangedListener(this);
        edPasswordEd6.addTextChangedListener(this);
        imSetPasswordShow.setOnClickListener(this);
        imSetPasswordVvv.setOnClickListener(this);
        imSetPasswordButton.setOnClickListener(this);
        setpassword();

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

            if (edPasswordEd1.isFocused()) {
                edPasswordEd1.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd2);


            } else if (edPasswordEd2.isFocused()) {

                //yic(edPasswordEd2);
                edPasswordEd2.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd3);


            } else if (edPasswordEd3.isFocused()) {

                edPasswordEd3.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd4);


            } else if (edPasswordEd4.isFocused()) {

                edPasswordEd4.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd5);

            } else if (edPasswordEd5.isFocused()) {

                edPasswordEd5.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd6);

            } else if (edPasswordEd6.isFocused()) {

                //edPasswordEd6.clearFocus();

                Log.i("测试", "输入完成");
            }
        } else if (editable.toString().length() == 0) {

            if (edPasswordEd1.isFocused()) {
                edPasswordEd1.clearFocus();

            } else if (edPasswordEd2.isFocused()) {

                //yic(edPasswordEd2);
                edPasswordEd2.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd1);


            } else if (edPasswordEd3.isFocused()) {

                edPasswordEd3.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd2);


            } else if (edPasswordEd4.isFocused()) {

                edPasswordEd4.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd3);

            } else if (edPasswordEd5.isFocused()) {

                edPasswordEd5.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd4);

            } else if (edPasswordEd6.isFocused()) {

                edPasswordEd6.clearFocus();
                showSoftInputFromWindow(activity, edPasswordEd5);

            }

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im_set_password_show://显示密码
                settext();
                break;
            case R.id.im_set_password_vvv://隐藏密码
                setpassword();
                break;
            case R.id.im_set_password_button://确定
                ToastUtils.showLongToast(context,edPasswordEd1.getText().toString()+edPasswordEd2.getText().toString()+edPasswordEd3.getText().toString()+edPasswordEd4.getText().toString()+edPasswordEd4.getText().toString()+edPasswordEd6.getText().toString());
                break;
        }
    }


    public static void Show(Context context){
        SetPaawordDilog setPaawordDilog=new SetPaawordDilog(context);
        DialogUtils.Show(setPaawordDilog);
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

   /**
     *  描述：设置为文本
     *  时间：2018/8/21 15:51
     **/

    private  void settext(){
        edPasswordEd1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edPasswordEd2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edPasswordEd3.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edPasswordEd4.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edPasswordEd5.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edPasswordEd6.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

    }
    /**
      *  描述：设置为密码
      *  时间：2018/8/21 15:51
      **/

    private void setpassword(){
        edPasswordEd1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPasswordEd2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPasswordEd3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPasswordEd4.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPasswordEd5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edPasswordEd6.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }
}
