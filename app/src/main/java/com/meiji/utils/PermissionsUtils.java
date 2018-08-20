package com.meiji.utils;

import android.Manifest;
import android.app.Activity;

import com.lwkandroid.rtpermission.RTPermission;
import com.lwkandroid.rtpermission.listener.OnPermissionResultListener;

import com.meiji.Interface.PermissionsCallk;


/**
 * 描述：6.0动态权限申请工具类
 * 时间：2018/8/14 10:35
 **/
public class PermissionsUtils {

    /**
     * 描述：拍照权限
     * 时间：2018/8/14 10:42
     **/
    public static void Photograph(Activity activity, final PermissionsCallk callk) {
        new RTPermission.Builder()
                .permissions(

                        Manifest.permission.READ_EXTERNAL_STORAGE,//
                        Manifest.permission.WRITE_EXTERNAL_STORAGE

                )
                .start(activity, new OnPermissionResultListener() {
                    @Override
                    public void onAllGranted(String[] allPermissions) {
                        //所有权限都已获得使用权后的回调
                        // Game1Activity.startMatisse(activity);
                        callk.Success();

                    }

                    @Override
                    public void onDeined(String[] dinedPermissions) {
                        //有权限未获得使用权的回调
                        // huantouxiang();
                        callk.Error();
                    }
                });
    }
}
