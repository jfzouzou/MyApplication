package com.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.util.MyToast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
      //  throw new UnsupportedOperationException("Not yet implemented");
        MyToast.showToast(context,"mybroadcaseRecivier");

    }
}
