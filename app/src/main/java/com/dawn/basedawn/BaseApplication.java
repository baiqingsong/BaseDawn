package com.dawn.basedawn;

import android.app.Application;
import android.content.Context;

/**
 * Created by 90449 on 2017/7/4.
 */

public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getAppContext(){
        return context;
    }
}
