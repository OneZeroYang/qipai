package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.utils.DialogUtils;

/**
  *  描述：换昵称
  *  时间：2018/8/14 10:09
  **/

public class NicknameDialog  extends BaesDialog{
    private Context context;
    private EditText edNicknameName;
    private ImageView imNicknameQueding;


    public NicknameDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public NicknameDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected NicknameDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.nickame_dialog;
    }

    @Override
    protected void init() {

        edNicknameName = (EditText) findViewById(R.id.ed_nickname_name);
        imNicknameQueding = (ImageView) findViewById(R.id.im_nickname_queding);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay(); //获取屏幕宽高
        Point point = new Point();
        display.getSize(point);

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes(); //获取当前对话框的参数值
        layoutParams.width = (int) (point.x * 0.6); //宽度设置为屏幕宽度的0.5
        layoutParams.height = (int) (point.y * 0.6); //高度设置为屏幕高度的0.5
//        layoutParams.width = (int) (display.getWidth() * 0.5);
//        layoutParams.height = (int) (display.getHeight() * 0.5);
        window.setAttributes(layoutParams);
        imNicknameQueding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsBeginSoundEffectUtils.Begin(context);

            }
        });


    }


    public static void Show(Context context){
        NicknameDialog nicknameDialog =new NicknameDialog(context);
        DialogUtils.Show(nicknameDialog);
    }
}
