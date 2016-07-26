package com.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


/**
 * Created by zy on 2016/7/25.
 */
public class ServiceTest extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("zy","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("zy","onDestroy");
    }
}
