package com.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.util.MyToast;

public class BootCompleteRecevier extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        MyToast.showToast(context,"recevier cowmplete");
        Log.i("zy","recevier cowmplete");
        Toast.makeText(context, "recevier cowmplete", Toast.LENGTH_SHORT).show();

//r        throw new UnsupportedOperationException("Not yet implemented");
    }
}
