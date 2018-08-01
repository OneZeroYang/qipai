package com.meiji.yangshijie.myapplication_test.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

import com.meiji.yangshijie.myapplication_test.Receiver.NetworkConnectChangedReceiver;

public class ExitUtils {

    public static void ExitApp(Context context){
        context.getPackageManager().setComponentEnabledSetting(
                new ComponentName("com.meiji.yangshijie.myapplication_test",
                        NetworkConnectChangedReceiver.class.getName()),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);


        System.exit(0);

    }
}
