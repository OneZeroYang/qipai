package com.meiji.ysj.youxidating.ui;


import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.utils.ToastUtils;
import com.meiji.ysj.youxidating.Game1Activity;
import com.meiji.Interface.PermissionsCallk;
import com.meiji.utils.DialogUtils;
import com.meiji.utils.PermissionsUtils;

/**
  *  描述：头像资料编辑界面
  *  时间：2018/8/13 10:05
  **/
public class HeadPortraitDialog extends BaesDialog implements View.OnClickListener {
    private Context context;

    private ImageView imHeadXx;
    private ImageView imHeadTouxiang;
    private TextView tvHeadName;
    private TextView tvHeadId;
    private TextView tvHeadHuanName;
    private TextView tvHeadHuanTouxiang;
    private ImageView imHeadFengxiang;
    private static Activity activity;





    public HeadPortraitDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public HeadPortraitDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected HeadPortraitDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.headportrait_dialog;
    }

    @Override
    protected void init() {

        imHeadXx = (ImageView) findViewById(R.id.im_head_xx);//关闭
        imHeadTouxiang = (ImageView) findViewById(R.id.im_head_touxiang);//头像
        tvHeadName = (TextView) findViewById(R.id.tv_head_name);//昵称
        tvHeadId = (TextView) findViewById(R.id.tv_head_id);//ID
        tvHeadHuanName = (TextView) findViewById(R.id.tv_head_huan_name);//换昵称
        tvHeadHuanTouxiang = (TextView) findViewById(R.id.tv_head_huan_touxiang);//换头像
        imHeadFengxiang = (ImageView) findViewById(R.id.im_head_fengxiang);//分享


        imHeadXx.setOnClickListener(this);
        tvHeadHuanName.setOnClickListener(this);
        tvHeadHuanTouxiang.setOnClickListener(this);
        imHeadFengxiang.setOnClickListener(this);



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
    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        switch (view.getId()){
            case R.id.im_head_xx://关闭
                this.dismiss();
                break;
            case R.id.tv_head_huan_name://换昵称
                NicknameDialog.Show(context);

                break;
            case R.id.tv_head_huan_touxiang://换头像
                huantouxiang();
                break;
            case R.id.im_head_fengxiang://分享
                ToastUtils.showToast(context,"分享");
                break;
        }

    }

    /**
      *  描述：换头像
      *  时间：2018/8/14 9:24
      **/

    private void huantouxiang() {

//        new RTPermission.Builder()
//                .permissions(
//
//                        Manifest.permission.READ_EXTERNAL_STORAGE,//
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE
//                )
//                .start(activity, new OnPermissionResultListener() {
//            @Override
//            public void onAllGranted(String[] allPermissions) {
//                //所有权限都已获得使用权后的回调
//                Game1Activity.startMatisse(activity);
//
//            }
//
//            @Override
//            public void onDeined(String[] dinedPermissions)
//            {
//                //有权限未获得使用权的回调
//                huantouxiang();
//            }
//        });

        PermissionsUtils.Photograph(activity, new PermissionsCallk() {
            @Override
            public void Success() {
                Game1Activity.startMatisse(activity);
            }

            @Override
            public void Error() {

            }
        });


    }

    public static void Show(Context context, Activity activity){
        HeadPortraitDialog.activity=activity;
        HeadPortraitDialog headPortraitDialog=new HeadPortraitDialog(context);
        DialogUtils.Show(headPortraitDialog);
    }


}
