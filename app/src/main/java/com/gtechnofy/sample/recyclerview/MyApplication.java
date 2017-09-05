package com.gtechnofy.sample.recyclerview;

import android.app.Application;
import android.content.Context;

/**
 * Created by ggupta on 8/31/17 3:55 PM.
 */

public class MyApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

    }

    public static Context getContext() {
        return MyApplication.sContext;
    }
}
