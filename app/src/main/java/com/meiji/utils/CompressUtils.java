package com.meiji.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.meiji.Interface.FileCallk;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

import static com.meiji.utils.FileUtils.TAG;

/**
  *  描述：压缩工具类
  *  时间：2018/8/14 16:35
  **/
public class CompressUtils {


    /**
      *  描述：压缩
      *  时间：2018/8/14 16:40
      **/

    public static void getFile(Uri path, Context context,final FileCallk fileCallk) {
        File file=null;
        // File file = new File(path.getPath());//创建文件

        String s=UrlUtils.getFilePath(context,path);
        if (s==null){
            //String realPathFromUri = UrlUtils.getRealPathFromUri(getApplicationContext(), path);
            // Log.i(TAG, "realPathFromUri: "+realPathFromUri);
            String test = test(path,context);
            Log.i(TAG, "测试: "+test);
            file = new File(test);//创建文件
        }else{
            file = new File(UrlUtils.getFilePath(context,path));//创建文件
        }


        Log.i(TAG, "压缩前的大小: "+file.length());
        Luban.get(context)
                .load(file)                     // 传入要压缩的图片
                .putGear(Luban.THIRD_GEAR)      // 设定压缩档次,默认三挡自己可以选择
                .setCompressListener(new OnCompressListener() { // 设置回调

                    @Override
                    public void onStart() {
                        // 压缩开始前调用,可以在方法内启动 loading UI
                        fileCallk.onStart();
                    }

                    @Override
                    public void onSuccess(File file) {
                        // 压缩成功后调用,返回压缩后的图片文件
                //        zipIcon(file);
                        Log.i(TAG, "压缩后的大小: file===="+file.length());
                        fileCallk.Success(file);

                    }

                    @Override
                    public void onError(Throwable e) {
                        fileCallk.Error(e);
                    }
                }).launch();
    }



    /**
      *  描述：7.0拍照获取URL
      *  时间：2018/8/14 16:40
      **/

    public  static String test(Uri uri,Context context){


        String filePath=null;
        List<PackageInfo> packs = context.getPackageManager().getInstalledPackages(PackageManager.GET_PROVIDERS);
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
                                    Object invoke = getPathStrategy.invoke(null, context, uri.getAuthority());
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


}
