package com.android.benben.myretrofit;

import android.app.Application;
import android.content.Context;

/**
 * Time      2017/3/13 14:54 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class APP extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
