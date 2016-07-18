package com.com.use.zy.entrust;

import java.util.Date;

public class WatchCartoonListener {   
    public WatchCartoonListener(){   
        System.out.println(this.getClass().getSimpleName()
        		+"  我正在看漫画，开始时间："+new Date());   
    }   
    public void stopPlayingGame(Date date){   
        System.out.println(this.getClass().getSimpleName()
        		+"    老师来了，不要看漫画了，结束时间："+date);   
    }   
}  
