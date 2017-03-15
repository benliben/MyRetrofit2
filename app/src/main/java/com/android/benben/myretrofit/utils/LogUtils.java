package com.android.benben.myretrofit.utils;

import android.util.Log;

/**
 * Time      2017/3/13 15:06 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class LogUtils {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;

    public static int level = VERBOSE;

    public static void v(String msg) {
        if (level <= VERBOSE) {
            Log.v("lyx", msg);
        }
    }

    public static void d(String msg) {
        if (level <= DEBUG) {
            Log.d("lyx", msg);
        }
    }

    public static void i(String msg) {
        if (level <= INFO) {
            Log.i("lyx", msg);
        }
    }

    public static void w(String msg) {
        if (level <= WARN) {
            Log.w("lyx", msg);
        }
    }

    public static void e(String msg) {
        if (level <= ERROR) {
            Log.e("lyx", msg);
        }
    }
}
