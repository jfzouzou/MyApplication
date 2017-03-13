package com.example.use.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.View.MySlider;
import com.base.BaseActivity;
import com.util.HlistView.MainActivityHListView;
import com.util.MyToast;


public class MainActivity extends BaseActivity {

    private TextView thread_tv, qqlist, recyclerviewindexBar, thred_tv3, thred_tv4;

    /**
     * BroadcaseReceiver
     */
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    //本地广播
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    /**
     * View
     * @param savedInstanceState
     */
    private MySlider mMySilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 本地广播
         */
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        thread_tv = (TextView) findViewById(R.id.thred_tv);
        qqlist = (TextView) findViewById(R.id.qqlist);
        recyclerviewindexBar = (TextView) findViewById(R.id.recyclerviewindexBar);
        thred_tv3 = (TextView) findViewById(R.id.thred_tv3);
        thred_tv4 = (TextView) findViewById(R.id.thred_tv4);

        thread_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityHListView.class));
            }
        });

        qqlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QQListActivity.class));
            }
        });

        recyclerviewindexBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewIndexBarActivity.class));
            }
        });

        /**
         * 发送广播
         */
        thred_tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intet = new Intent("post broadcastRecivier");
                sendBroadcast(intet);
//                sendOrderedBroadcast(intet, null);
            }
        });


        /**
         * 发送本地广播
         */
        thred_tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intet = new Intent("com.example.use.ui.MYBROADCASTRECEIVER");
                //sendBroadcast(intet);
               // sendOrderedBroadcast(intet, null);
                localBroadcastManager.sendBroadcast(intet);
            }
        });

        /**
         * BroadcaseReceiver
         */
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.use.ui.MYBROADCASTRECEIVER");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver, intentFilter);

//        mMySilder = (MySlider) findViewById(R.id.myview);
//        mMySilder.setOnItemSelectListener(new MySlider.OnItemSelectListener() {
//            @Override
//            public void onItemSelect(int index, String indexString) {
//
//                thread_tv.setText(indexString);
//            }
//        });

    }


    /**
     * BroadcaseReceiver
     */

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Log.i("zy", "网络链接");
            } else {
                Log.i("zy", "网络断开");
            }

        }
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            MyToast.showToast(MainActivity.this, "本地广播");
        }
    }


    /**
     * 移除BroadcaseReceiver注册
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
        Toast.makeText(MainActivity.this, "unregisterReceiver change", Toast.LENGTH_SHORT).show();

    }

    private void String() {
        //如何实现“ I am Student”转为“Student am I”？
        String string = " I am Student";
        String str = "";
        for (int i = string.length() - 1; i > -1; i--) {
            str += String.valueOf(str.charAt(i));
        }

    }

//    private long mPressedTime = 0;
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        long time = System.currentTimeMillis();
//        if ((time - mPressedTime) > 2000) {
//            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//            mPressedTime = time;
//        } else {
//            finish();
//        }
//    }


}


