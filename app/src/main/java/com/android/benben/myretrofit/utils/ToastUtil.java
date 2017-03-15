package com.android.benben.myretrofit.utils;

import android.widget.Toast;

import com.android.benben.myretrofit.APP;

/**
 * Time      2017/3/13 16:02 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class ToastUtil {
    public static void show(String msg) {
        Toast.makeText(APP.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
