package com.com.use.zy.entrust;

import java.util.Date;

public class WatchingNBAListener {   
    public WatchingNBAListener(){   
        System.out.println(this.getClass().getSimpleName()
        		+"我正在看NBA,开始时间是： "+new Date());   
    }   
    public void stopWatchingTV(Date date){   
        System.out.println(this.getClass().getSimpleName()
        		+"老师来了，快关闭NBA直播 ， 结束时间是："+date.toString());   
    }   
}  
