package com.android.benben.myretrofit.service;

import com.android.benben.myretrofit.data.RetData;

/**
 * Time      2017/3/13 15:15 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface EventFinish<T> {
    abstract void onFinish(RetData<T> retData);
}
