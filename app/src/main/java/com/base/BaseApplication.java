package com.base;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by zy on 2016/8/20.
 */
public class BaseApplication  extends Application {

    private static BaseApplication instance;
    private Typeface mTypeface;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        /**
         * 微软雅黑字体
         */
        mTypeface = Typeface.createFromAsset(getInstance().getAssets(), "fonts/wryh.ttf");
    }

    //单例模式中获取唯一的ExitApplication 实例
    public static BaseApplication getInstance()
    {
        if (null == instance)
        {
            instance = new BaseApplication();
        }
        return instance;
    }

    public Typeface createWRYHTypeFace()
    {
        return mTypeface;
    }
}
