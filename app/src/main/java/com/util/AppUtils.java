package com.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Leo on 2015/8/3.
 */
public class AppUtils
{
    /**
     * 获取版本code
     */
    public static int getVersionCode(Context context)
    {
        try
        {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            int version = info.versionCode;
            return version;
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }


    /**
     * 获取版本name
     */
    public static String getVersionName(Context context)
    {
        try
        {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
//            return context.getString(R.string.app_name) + version;
            return version;
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
