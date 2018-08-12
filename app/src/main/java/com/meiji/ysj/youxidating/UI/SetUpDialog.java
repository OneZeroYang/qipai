package com.meiji.ysj.youxidating.UI;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.View.BaesDialog;
import com.meiji.ysj.youxidating.GlobalVariable;
import com.meiji.ysj.youxidating.utils.DialogUtils;

/**
  *  描述：设置
  *  时间：2018/8/10 13:58
  **/
public class SetUpDialog extends BaesDialog implements View.OnClickListener {
    private static final String TAG = "SetUpDialog";
    private Context context;
    private ImageView bt_setup_xx;
    private TextView tvSetupYingyue;
    private TextView tvSetupZhengdong;
    private TextView tvSetupyingxiao;
    private TextView tvSetup1;
    private TextView tvSetup2;
    private TextView tvSetup3;

    private Animation animation;
    private Animation animation1;
    int width;


    private boolean yy;//音乐开关
    private boolean zd;//振动开关
    private boolean yx;//音效开关




    public SetUpDialog(@NonNull Context context) {

        super(context);
        this.context=context;
    }

    public SetUpDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SetUpDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.setup_dialog;
    }

    @Override
    protected void init() {

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
        bt_setup_xx=findViewById(R.id.bt_setup_xx);
        bt_setup_xx.setOnClickListener(this);


        tvSetupYingyue = (TextView) findViewById(R.id.tv_setup_yingyue);//文字
        tvSetupZhengdong = (TextView) findViewById(R.id.tv_setup_zhengdong);
        tvSetupyingxiao = (TextView) findViewById(R.id.tv_setupyingxiao);

        tvSetup1 = (TextView) findViewById(R.id.tv_setup_1);// 这3个必须设置动画
        tvSetup2 = (TextView) findViewById(R.id.tv_setup_2);//
        tvSetup3 = (TextView) findViewById(R.id.tv_setup_3);//

        tvSetupYingyue.setOnClickListener(this);
        tvSetupZhengdong.setOnClickListener(this);
        tvSetupyingxiao.setOnClickListener(this);


        animation = new TranslateAnimation(0,130,0,0);//设置动画

        animation1=new TranslateAnimation(0,0,0,0);//设置动画


        /**
          *  描述：初始化系统设置
          *  时间：2018/8/10 16:00
          **/
        if (GlobalVariable.isMute){//如果是静音
            setAnimation(tvSetup1);
            tvSetupYingyue.setText("关");
        }else {
            tvSetupYingyue.setText("开");
            setAnimation1(tvSetup1);
        }
        if (GlobalVariable.isvibrator){//如果是开了振动
            setAnimation1(tvSetup2);
            tvSetupZhengdong.setText("开");
        }else {
            tvSetupZhengdong.setText("关");
            setAnimation(tvSetup2);
        }
        if (GlobalVariable.isSound){//如果开启音效
            tvSetupyingxiao.setText("开");
        }else {
            setAnimation(tvSetup3);
            tvSetupyingxiao.setText("关");
        }


    }

    public static void Show(Context context){
        SetUpDialog setUpDialog=new SetUpDialog(context);
        DialogUtils.Show(setUpDialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_setup_xx:
                this.dismiss();
                break;
            case R.id.tv_setup_yingyue://音乐开关
//                setAnimation(tvSetup1);
//                Log.i(TAG, "onClick: ");
                if (GlobalVariable.isMute){
                    setAnimation1(tvSetup1);
                    tvSetupYingyue.setText("开");
                    GlobalVariable.isMute=false;

                }else {
                    setAnimation(tvSetup1);
                    GlobalVariable.isMute=true;
                    tvSetupYingyue.setText("关");
                }
                break;
            case R.id.tv_setup_zhengdong://振动开关
                if (GlobalVariable.isvibrator){
                    setAnimation(tvSetup2);
                    GlobalVariable.isvibrator=false;
                    tvSetupZhengdong.setText("关");

                }else {
                    setAnimation1(tvSetup2);
                    GlobalVariable.isvibrator=true;
                    tvSetupZhengdong.setText("开");
                }
                break;
            case R.id.tv_setupyingxiao://音效开关
                if (GlobalVariable.isSound){
                    setAnimation(tvSetup3);
                    GlobalVariable.isSound=false;
                    tvSetupyingxiao.setText("关");

                }else {
                    setAnimation1(tvSetup3);
                    GlobalVariable.isSound=true;
                    tvSetupyingxiao.setText("开");
                }
                break;
        }
    }


    public void setAnimation(TextView tvSetup1){
//        translateAnimation.setDuration(500);//动画持续的时间为1.5s
//        tvSetup1.setAnimation(translateAnimation);//给imageView添加的动画效果
//        translateAnimation.setFillEnabled(true);//使其可以填充效果从而不回到原地
//        translateAnimation.setFillAfter(true);//不回到起始位置
//        //如果不添加setFillEnabled和setFillAfter则动画执行结束后会自动回到远点
//        translateAnimation.start();//动画开始执行 放在最后即可

        animation.setDuration(500);
        //animation.setRepeatCount(10);
        animation.setFillAfter(true);
        animation.setFillEnabled(true);
        tvSetup1.clearAnimation();
        tvSetup1.startAnimation(animation);

    }


    public void setAnimation1(TextView tvSetup1){
//        translateAnimation.setDuration(500);//动画持续的时间为1.5s
//        tvSetup1.setAnimation(translateAnimation);//给imageView添加的动画效果
//        translateAnimation.setFillEnabled(true);//使其可以填充效果从而不回到原地
//        translateAnimation.setFillAfter(true);//不回到起始位置
//        //如果不添加setFillEnabled和setFillAfter则动画执行结束后会自动回到远点
//        translateAnimation.start();//动画开始执行 放在最后即可

        animation1.setDuration(500);
        //animation.setRepeatCount(10);
        animation1.setFillAfter(true);
        animation1.setFillEnabled(true);
        tvSetup1.clearAnimation();
        tvSetup1.startAnimation(animation1);

    }





}
