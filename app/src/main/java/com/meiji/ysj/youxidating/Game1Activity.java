package com.meiji.ysj.youxidating;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meiji.yangshijie.login.BaseActivity;
import com.meiji.yangshijie.login.R;
import com.meiji.utils.ToastUtils;
import com.meiji.ysj.youxidating.ui.AgentDialog;
import com.meiji.ysj.youxidating.ui.HeadPortraitDialog;
import com.meiji.ysj.youxidating.ui.NewsDialog;
import com.meiji.ysj.youxidating.ui.PersonalDialog;
import com.meiji.ysj.youxidating.ui.SetUpDialog;
import com.meiji.utils.UrlUtils;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

import static com.meiji.utils.IsBeginSoundEffectUtils.Begin;
import static com.meiji.utils.IsBeginSoundEffectUtils.IsMusic;


/**
  *  描述：游戏大厅
  *  时间：2018/8/15 14:21
  **/
public class Game1Activity extends BaseActivity implements View.OnClickListener {

    private static int REQUEST_CODE_CHOOSE=0011;//拍照返回标志




    private static final String TAG ="Game1Activity" ;
    private ImageView gameImTouxiang;
    private TextView gameTvName;
    private TextView gameTvId;
    private TextView gameTvMoney;
    private TextView gameTvDonggao;
    private FrameLayout gameImZ1;
    private TextView gameTvGonggao1;
    private FrameLayout gameImZ2;
    private FrameLayout gameImL2;
    private FrameLayout gameImL1;
    private FrameLayout gameImR1;
    private FrameLayout gameImR2;
    private LinearLayout gameLlXiaoxi;
    private LinearLayout gameLlGerenzhongxing;
    private LinearLayout gameLlSehzhi;

    public  Activity activity=Game1Activity.this;
    @Override
    protected int setView() {
        return R.layout.activity_game1;
    }

    @Override
    protected void initViews() {
        IsMusic(this);


        gameImTouxiang = (ImageView) findViewById(R.id.game_im_touxiang);//头像
        gameTvName = (TextView) findViewById(R.id.game_tv_name);//昵称
        gameTvId = (TextView) findViewById(R.id.game_tv_id);//ID
        gameTvMoney = (TextView) findViewById(R.id.game_tv_money);//金币;
        gameTvDonggao = (TextView) findViewById(R.id.game_tv_donggao);//消息通知
        gameImZ1 = (FrameLayout) findViewById(R.id.game_im_z1);//站内公告
        gameTvGonggao1 = (TextView) findViewById(R.id.game_tv_gonggao1);//公告内容
        gameImZ2 = (FrameLayout) findViewById(R.id.game_im_z2);//电子游戏
        gameImL2 = (FrameLayout) findViewById(R.id.game_im_l2);//彩票游戏
        gameImL1 = (FrameLayout) findViewById(R.id.game_im_l1);//真人咨询
        gameImR1 = (FrameLayout) findViewById(R.id.game_im_r1);//体育赛事
        gameImR2 = (FrameLayout) findViewById(R.id.game_im_r2);//棋牌游戏
        gameLlXiaoxi = (LinearLayout) findViewById(R.id.game_ll_xiaoxi);//消息
        gameLlGerenzhongxing = (LinearLayout) findViewById(R.id.game_ll_gerenzhongxing);//个人中心
        gameLlSehzhi = (LinearLayout) findViewById(R.id.game_ll_sehzhi);//设置
        initanimation();//初始化动画
        gameImTouxiang.setOnClickListener(this);
        gameImZ1.setOnClickListener(this);
        gameImZ2.setOnClickListener(this);
        gameImL2.setOnClickListener(this);
        gameImL1.setOnClickListener(this);
        gameImR1.setOnClickListener(this);
        gameImR2.setOnClickListener(this);
        gameLlXiaoxi.setOnClickListener(this);
        gameLlGerenzhongxing.setOnClickListener(this);
        gameLlSehzhi.setOnClickListener(this);


        String s="系统：";
        String s1="恭喜 ";
        String name=" 小明 ";

        String s3="申请成为高级VIP代理66666666666666666666666666666666666666666666666666666";


        String str1 = "<font color='#3AD3FF'>"+s+"</font><font color='#3AD3FF'>"+s1+"</font><font color='#F1DC6B'> "+name+" </font><font color='#3AD3FF'> "+s3+" </font>";
        gameTvDonggao.setText(Html.fromHtml(str1));

        gameTvDonggao.setSelected(true);//跑马灯

    }


    @Override
    public void onClick(View view) {
                Begin(getApplication());
        switch (view.getId()){
            case R.id.game_im_touxiang://头像
                HeadPortraitDialog.Show(Game1Activity.this,activity);
                break;
            case R.id.game_im_z1://站内公告
                Log.i(TAG, "onClick: 站内公告");
                ToastUtils.showToast(getApplicationContext(),"站内公告");
                onClickanimation(gameImZ1);
                break;
            case R.id.game_im_z2://电子游戏
                Log.i(TAG, "onClick: 电子游戏");
                ToastUtils.showToast(getApplicationContext(),"电子游戏");
                onClickanimation(gameImZ2);
                break;
            case R.id.game_im_l2://彩票游戏
                Log.i(TAG, "onClick: 彩票游戏");
                ToastUtils.showToast(getApplicationContext(),"彩票游戏");
                onClickanimation(gameImL2);
                break;
            case R.id.game_im_l1://真人咨询
                Log.i(TAG, "onClick: 真人咨询");
                ToastUtils.showToast(getApplicationContext(),"真人咨询");
                onClickanimation(gameImL1);
                break;
            case R.id.game_im_r1://体育赛事
                Log.i(TAG, "onClick: 体育赛事");
                ToastUtils.showToast(getApplicationContext(),"体育赛事");
                onClickanimation(gameImR1);
                break;
            case R.id.game_im_r2://棋牌游戏
                Log.i(TAG, "onClick: 棋牌游戏");
                ToastUtils.showToast(getApplicationContext(),"棋牌游戏");
                onClickanimation(gameImR2);
                break;
            case R.id.game_ll_xiaoxi://消息
                NewsDialog.Show(Game1Activity.this);
                break;
            case R.id.game_ll_gerenzhongxing://个人中心
                ShowPersonalDialog();
                break;
            case R.id.game_ll_sehzhi://设置
                SetUpDialog.Show(Game1Activity.this);
                break;
        }

    }
/**
  *  描述：个人中心
  *  时间：2018/8/9 14:55
  **/
    private void ShowPersonalDialog() {
        PersonalDialog.Show(Game1Activity.this,activity);
    }

    @Override
    protected void initData() {

    }
    @Override
    protected void Error(String s) {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initanimation();//重新绘画动画
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }






//    public svoid getpower(){
//        new RTPermission.Builder()
//                .permissions()
//                .start(activity, new OnPermissionResultListener()
//        {
//            @Override
//            public void onAllGranted(String[] allPermissions)
//            {
//                //所有权限都已获得使用权后的回调
//            }
//
//            @Override
//            public void onDeined(String[] dinedPermissions)
//            {
//                //有权限未获得使用权的回调
//            }
//        });
//    }

    /**
      *  描述：拉起拍照(头像)
      *  时间：2018/8/14 9:53
      **/

    public static void startMatisse(Activity activity){
        Matisse
                .from(activity)
                .choose(MimeType.allOf())//照片视频全部显示
                .countable(true)//有序选择图片
                .maxSelectable(1)//最大选择数量为9
                .gridExpectedSize(360)//图片显示表格的大小getResources()
                //.getDimensionPixelSize(R.dimen.media_grid_size)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//图像选择和预览活动所需的方向。
                .thumbnailScale(0.85f)//缩放比例
                .theme(R.style.Matisse_Dracula)//主题  暗色主题 R.style.Matisse_Dracula
                .capture(true) //是否提供拍照功能
                .captureStrategy(new CaptureStrategy(true,"com.meiji.ysj.youxidating.fileprovider"))//存储到哪里
                .imageEngine(new GlideEngine())//加载方式
                .forResult(REQUEST_CODE_CHOOSE);//请求码
    }


    /**
      *  描述：拍照返回
      *  时间：2018/8/14 9:53
      **/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            List<Uri> mSelected = Matisse.obtainResult(data);
            Log.i("Matisse", "mSelected: " + mSelected);
            //若需设置在imageview中
            //imageView.setImageURI(mSelected.get(0));

            getFile(mSelected.get(0));

          //  Log.i(TAG, "onActivityResult: ");

        }else if (requestCode == 1 && resultCode == RESULT_OK){
            List<Uri> mSelected = Matisse.obtainResult(data);
            Log.i("Matisse", "mSelected: " + mSelected);
            AgentDialog.upview1(mSelected.get(0));



            //身份证正面
        }else if (requestCode == 2 && resultCode == RESULT_OK){
            List<Uri> mSelected = Matisse.obtainResult(data);
            Log.i("Matisse", "mSelected: " + mSelected);
            //身份证反面
            AgentDialog.upview2(mSelected.get(0));
           // getFile(mSelected.get(0));
        }


    }

/**
  *  描述：身份证拍照返回（正）
  *  时间：2018/8/14 10:52
  **/
    public static void startMatisse1(Activity activity){
        Matisse
                .from(activity)
                .choose(MimeType.allOf())//照片视频全部显示
                .countable(true)//有序选择图片
                .maxSelectable(1)//最大选择数量为9
                .gridExpectedSize(360)//图片显示表格的大小getResources()
                //.getDimensionPixelSize(R.dimen.media_grid_size)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//图像选择和预览活动所需的方向。
                .thumbnailScale(0.85f)//缩放比例
                .theme(R.style.Matisse_Dracula)//主题  暗色主题 R.style.Matisse_Dracula
                .capture(true) //是否提供拍照功能
                .captureStrategy(new CaptureStrategy(true,"com.meiji.ysj.youxidating.fileprovider"))//存储到哪里
                .imageEngine(new GlideEngine())//加载方式
                .forResult(1);//请求码
    }

    /**
     *  描述：身份证拍照返回（反）
     *  时间：2018/8/14 10:52
     **/
    public static void startMatisse2(Activity activity){
        Matisse
                .from(activity)
                .choose(MimeType.allOf())//照片视频全部显示
                .countable(true)//有序选择图片
                .maxSelectable(1)//最大选择数量为9
                .gridExpectedSize(360)//图片显示表格的大小getResources()
                //.getDimensionPixelSize(R.dimen.media_grid_size)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//图像选择和预览活动所需的方向。
                .thumbnailScale(0.85f)//缩放比例
                .theme(R.style.Matisse_Dracula)//主题  暗色主题 R.style.Matisse_Dracula
                .capture(true) //是否提供拍照功能
                .captureStrategy(new CaptureStrategy(true,"com.meiji.ysj.youxidating.fileprovider"))//存储到哪里
                .imageEngine(new GlideEngine())//加载方式
                .forResult(2);//请求码
    }


/**
  *  描述：压缩图片
  *  时间：2018/8/14 11:32
  **/
    private void getFile(Uri path) {
        File file=null;
       // File file = new File(path.getPath());//创建文件
        Log.i(TAG, "getPath: "+path.getPath());
        Log.i(TAG, "getFile: "+UrlUtils.getRealFilePath(getApplicationContext(),path));
        Log.i(TAG, "2: "+UrlUtils.getFilePath(getApplicationContext(),path));
        String s=UrlUtils.getFilePath(getApplicationContext(),path);
        if (s==null){
           //String realPathFromUri = UrlUtils.getRealPathFromUri(getApplicationContext(), path);
           // Log.i(TAG, "realPathFromUri: "+realPathFromUri);
            String test = test(path);
            Log.i(TAG, "测试: "+test);
            file = new File(test);//创建文件
        }else{
             file = new File(UrlUtils.getFilePath(getApplicationContext(),path));//创建文件
        }


        Log.i(TAG, "压缩前的大小: "+file.length());
        Luban.get(this)
                .load(file)                     // 传入要压缩的图片
                .putGear(Luban.THIRD_GEAR)      // 设定压缩档次,默认三挡自己可以选择
                .setCompressListener(new OnCompressListener() { // 设置回调

                    @Override
                    public void onStart() {
                        // 压缩开始前调用,可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // 压缩成功后调用,返回压缩后的图片文件
                        zipIcon(file);
                        Log.i(TAG, "压缩后的大小: file===="+file.length());

                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                }).launch();
    }
    /**
      *  描述：上传
      *  时间：2018/8/14 11:32
      **/
    private void zipIcon(File file) {


    }
    /**
      *  描述：7.0拍照压缩
      *  时间：2018/8/14 16:21
      **/

    public  String test(Uri uri){
        String filePath=null;
        List<PackageInfo> packs = this.getPackageManager().getInstalledPackages(PackageManager.GET_PROVIDERS);
        if (packs != null) {

            String fileProviderClassName = FileProvider.class.getName();
            for (PackageInfo pack : packs) {
                ProviderInfo[] providers = pack.providers;
                if (providers != null) {
                    for (ProviderInfo provider : providers) {

                        if (uri.getAuthority().equals(provider.authority)){
                            if (provider.name.equalsIgnoreCase(fileProviderClassName)) {
                                Class<FileProvider> fileProviderClass = FileProvider.class;
                                try {
                                    Method getPathStrategy = fileProviderClass.getDeclaredMethod("getPathStrategy", Context.class , String.class);
                                    getPathStrategy.setAccessible(true);
                                    Object invoke = getPathStrategy.invoke(null, this, uri.getAuthority());
                                    if (invoke != null) {
                                        String PathStrategyStringClass = FileProvider.class.getName()+"$PathStrategy";
                                        Class<?> PathStrategy = Class.forName(PathStrategyStringClass);
                                        Method getFileForUri = PathStrategy.getDeclaredMethod("getFileForUri", Uri.class);
                                        getFileForUri.setAccessible(true);
                                        Object invoke1 = getFileForUri.invoke(invoke, uri);
                                        if (invoke1 instanceof File) {
                                            filePath = ((File) invoke1).getAbsolutePath();
                                        Log.i("测试", "test: "+filePath);
                                        }
                                    }
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }

                                break;
                            }
                          //  Log.e(provider);
                            break;
                        }
                    }

                }

            }
        }
        return filePath;
    }

    /**
      *  描述：进入时的动画
      *  时间：2018/8/15 15:29
      **/

    public void initanimation(){
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 0);//设置动画
        translateAnimation.setDuration(300);
        //animation.setRepeatCount(10);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        gameImL1.setAnimation(translateAnimation);
        gameImL2.setAnimation(translateAnimation);



        TranslateAnimation translateAnimation1= new TranslateAnimation(0, -100, 0, 0);//设置动画
        translateAnimation1.setDuration(300);
        //animation.setRepeatCount(10);
        translateAnimation1.setFillAfter(true);
        translateAnimation1.setFillEnabled(true);

        gameImR2.setAnimation(translateAnimation1);
        gameImR1.setAnimation(translateAnimation1);

    }

    /**
      *  描述：点击动画
      *  时间：2018/8/15 15:30
      **/
    public void onClickanimation(View view){


//        ObjectAnimator animatorX = ObjectAnimator.ofFloat(gameImL1,"scaleX",1.0f,1.8f);
//        ObjectAnimator animatorY = ObjectAnimator.ofFloat(gameImL1,"scaleY",1.0f,1.8f);
//        AnimatorSet set =new AnimatorSet();
//        set.setDuration(1000);
//        set.playTogether(animatorX,animatorY);
//        set.start();


        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view,"scaleX",0.9f,1.0f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view,"scaleY",0.9f,1.0f);
        AnimatorSet set =new AnimatorSet();
        set.setDuration(1000);
        set.setInterpolator(new SpringScaleInterpolator(0.4f));
        set.playTogether(animatorX,animatorY);
        set.start();




    }

    /**
      *  描述：弹性动画
      *  时间：2018/8/15 15:34
      **/
    class SpringScaleInterpolator implements Interpolator {
        //弹性因数
        private float factor;

        public SpringScaleInterpolator(float factor) {
            this.factor = factor;
        }

        @Override
        public float getInterpolation(float input) {

            return (float) (Math.pow(2, -10 * input) * Math.sin((input - factor / 4) * (2 * Math.PI) / factor) + 1);//弹性算法
        }


    }

}
