package com.android.benben.myretrofit.service;

import com.android.benben.myretrofit.data.RetData;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Time      2017/3/13 14:41 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface BaseAPIService {
    @FormUrlEncoded
    @POST("{action}")
    Call<RetData> getDataWithPost(@Path("action") String action,
                                  @FieldMap HashMap<String, Object> map);

}
