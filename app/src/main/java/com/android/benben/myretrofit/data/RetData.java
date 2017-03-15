package com.android.benben.myretrofit.data;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Time      2017/3/13 14:43 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class RetData<T> {

    private List<T> data;
    private int error_code;
    private String reason;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public <T> RetData<T> getRetData(Class<T> tClass) {
        RetData<T> retData = new RetData<>();
        retData.setError_code(getError_code());
        List<T> list = new ArrayList<>();
        if (getData() != null && !getData().isEmpty()) {
            for (Object obj : getData()) {
                list.add(new Gson().fromJson(new Gson().toJson(obj), tClass));
            }
        }
        retData.setData(list);
        return retData;
    }
}
