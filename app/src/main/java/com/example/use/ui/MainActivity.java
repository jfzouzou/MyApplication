package com.example.use.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.base.BaseActivity;
import com.util.HlistView.MainActivityHListView;

public class MainActivity extends BaseActivity {

    private TextView thread_tv, qqlist, recyclerviewindexBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        thread_tv = (TextView) findViewById(R.id.thred_tv);
        qqlist = (TextView) findViewById(R.id.qqlist);
        recyclerviewindexBar = (TextView) findViewById(R.id.recyclerviewindexBar);
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


    }

    private void String() {
        //如何实现“ I am Student”转为“Student am I”？
        String string = " I am Student";
        String str = "";
        for (int i = string.length() - 1; i > -1; i--) {
            str += String.valueOf(str.charAt(i));
        }

    }

    private long mPressedTime = 0;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        long time = System.currentTimeMillis();
        if ((time - mPressedTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mPressedTime = time;
        } else {
            finish();
        }
    }


}


