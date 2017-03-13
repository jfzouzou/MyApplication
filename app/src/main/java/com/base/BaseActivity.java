package com.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.example.use.ui.LoginActivity;

/**
 * Created by zy on 2016/7/21.
 */
public class BaseActivity extends FragmentActivity {


    private ForceOffLineRecevier forceOffLineRecevier;

    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        return super.createConfigurationContext(overrideConfiguration);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActivityeCollctor.addActivity(this);

    }


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("post broadcastRecivier");
        forceOffLineRecevier = new ForceOffLineRecevier();
        registerReceiver(forceOffLineRecevier, intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (forceOffLineRecevier != null) {
            unregisterReceiver(forceOffLineRecevier);
            forceOffLineRecevier = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityeCollctor.removeActivity(this);
    }

    class ForceOffLineRecevier extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("账号在另外一个地方登陆");
            builder.setCancelable(false);
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityeCollctor.onDestoryActivity();
                    startActivity(new Intent(BaseActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });
            builder.show();
        }
    }

    public void openActivity(Class<? extends Activity> clazz) {
        openActivity(clazz, null);
    }

    public void openActivity(Class<? extends Activity> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


}
