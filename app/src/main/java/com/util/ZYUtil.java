package com.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.use.ui.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zy on 2016/10/27.
 */

public class ZYUtil {

    private static final int FLAGBOOLEANBVALUE = 0;


    private Context mContext;
   public ZYUtil(Context mContext){
        this.mContext = mContext;
    }

    /**
     * 循环初始化id 方式一、
     */
    private int[] selBtnIdArr = {/*R.id.thred_tv1, R.id.thred_tv2, R.id.thred_tv3, R.id.thred_tv4*/};
    private List<View> selBtnViewArr = new ArrayList<>();
    private void initforxuhuanID() {
        for (int i = 0; i < selBtnIdArr.length; i++) {
            View selBtn = new View(mContext);
            //selBtn =findViewById(selBtnIdArr[i]);
            //selBtn.setOnClickListener(new setOnclick(i));
            selBtnViewArr.add(selBtn);

        }
    }



    private class setOnclick implements View.OnClickListener{
        int i;
        private setOnclick(int i){
            this.i = i;
        }

        @Override
        public void onClick(View v) {

        }
    }

    /**
     * 循环初始化id 方式二、
     */
    private void findViews() {
        //反射机制，动态获取控件的资源ID
        for(int i = 0 ; i < 10 ; i ++) {
            try{
                Field field = R.id.class.getField("keypad"+i);
                //keys[i] = findViewById((Integer)field.getInt(new R.id()));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 在子线程更新ui，但是要在onResume方法执行之前
     */
    private void thread (){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               TextView thread_tv = new TextView(mContext);
                thread_tv.setText("在子线程更新ui服不服");
            }
        }).start();
    }

    /**
     * 延迟2毫秒跳转
     */
    private void init() {
        switch (FLAGBOOLEANBVALUE) {
            case 0:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                      openActivity(GuideViewActivity.class);
                    }
                }, 2000);
                break;
        }
    }
}
