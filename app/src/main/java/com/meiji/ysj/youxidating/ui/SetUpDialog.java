package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.ysj.youxidating.GlobalVariable;
import com.meiji.Interface.SwitchButtonListener;
import com.meiji.utils.DialogUtils;
import com.meiji.utils.SystemSetupUtils;
import com.meiji.ysj.youxidating.view.SwitchButton;

/**
  *  描述：设置
  *  时间：2018/8/10 13:58
  **/
public class SetUpDialog extends BaesDialog implements View.OnClickListener {
    private static final String TAG = "SetUpDialog";
    private Context context;
    private ImageView bt_setup_xx;

    private SwitchButton sb_setup_yingyue;

    private SwitchButton sb_setup_zhengdong;

    private SwitchButton sb_setup_yingxiao;


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
        layoutParams.width = (int) (point.x * 0.6); //宽度设置为屏幕宽度的0.5
        layoutParams.height = (int) (point.y * 0.57); //高度设置为屏幕高度的0.5

        window.setAttributes(layoutParams);
        bt_setup_xx=findViewById(R.id.bt_setup_xx);
        bt_setup_xx.setOnClickListener(this);

        sb_setup_yingyue=findViewById(R.id.sb_setup_yingyue);//音乐开关
        //设置默认开关
        sb_setup_zhengdong=findViewById(R.id.sb_setup_zhengdong);//振动开关
        sb_setup_yingxiao=findViewById(R.id.sb_setup_yingxiao);//音效开关



        /**
         *  描述：初始化系统设置
         *  时间：2018/8/10 16:00
         **/
        if (GlobalVariable.isMute){//如果是静音
            sb_setup_yingyue.setcurrentState(true);
        }else {
            sb_setup_yingyue.setcurrentState(false);
        }
        if (GlobalVariable.isvibrator){//如果是开了振动
            sb_setup_zhengdong.setcurrentState(false);
        }else {
            sb_setup_zhengdong.setcurrentState(true);
        }
        if (GlobalVariable.isSound){//如果开启音效
            sb_setup_yingxiao.setcurrentState(false);
        }else {
            sb_setup_yingxiao.setcurrentState(true);
        }
/**
  *  描述：音效开关
  *  时间：2018/8/17 13:58
  **/
        sb_setup_yingxiao.setOnClick(new SwitchButtonListener() {
            @Override
            public void OnClick(View view, boolean b) {
                if (!b){

                    Log.i(TAG, "OnClick: 开启音效");
                    SystemSetupUtils.setisSound(context,true);
                }else {
                    Log.i(TAG, "OnClick: 开关闭音效");
                    SystemSetupUtils.setisSound(context,false);
                }
            }
        });

        /**
          *  描述：振动开关
          *  时间：2018/8/17 13:58
          **/

        sb_setup_zhengdong.setOnClick(new SwitchButtonListener() {
            @Override
            public void OnClick(View view, boolean b) {
                if (!b){
                    Log.i(TAG, "OnClick: 开启振动");
                    SystemSetupUtils.setisvibrator(context,true);
                }else {
                    Log.i(TAG, "OnClick: 关闭振动");
                    SystemSetupUtils.setisvibrator(context,false);
                }
            }
        });


        /**
          *  描述：音乐开关
          *  时间：2018/8/17 13:58
          **/
        sb_setup_yingyue.setOnClick(new SwitchButtonListener() {
            @Override
            public void OnClick(View view, boolean b) {
                if (!b){
                    Log.i(TAG, "OnClick: 开");
                    SystemSetupUtils.setisMute(context,false);
                }else {
                    SystemSetupUtils.setisMute(context,true);
                    Log.i(TAG, "OnClick: 关");
                }
            }
        });





    }

    public static void Show(Context context){
        SetUpDialog setUpDialog=new SetUpDialog(context);
        DialogUtils.Show(setUpDialog);
    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        switch (view.getId()){
            case R.id.bt_setup_xx:
                this.dismiss();
                break;

        }
    }



}
