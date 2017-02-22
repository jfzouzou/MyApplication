package com.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * activity控制器
 * Created by use on 2017/2/21.
 */

public class ActivityeCollctor {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);

    }

    public static void onDestoryActivity() {
        for (Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
