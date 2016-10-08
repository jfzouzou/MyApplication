package com.example.use.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private int flagStr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String rul = insetString("","2016-09");
        Log.i("zy",rul);
        init();
    }

  private void init(){

      switch (flagStr){
          case 0:
              new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                    //  openActivity(GuideViewActivity.class);
                  }
              },2000);

              break;
      }


  }

    private long mPressedTime = 0;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        long time = System.currentTimeMillis();
        if((time - mPressedTime) >2000) {
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            mPressedTime = time;
        }else{
            finish();
        }
    }

    public static String insetString(String url, String date) {
        StringBuilder sb = new StringBuilder();
        try{
            sb.append(url);
            int i = url.lastIndexOf("/");
            sb.insert(i+1, date);//+1是在string后插入
        }catch (Exception e){
            Log.i("zy",e.toString());
        }
        return sb.toString();
    }
}


