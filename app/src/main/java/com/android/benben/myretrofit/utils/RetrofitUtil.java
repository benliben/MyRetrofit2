package com.android.benben.myretrofit.utils;

import android.content.ContentValues;
import android.net.ConnectivityManager;
import android.net.Network;
import android.support.annotation.UiThread;
import android.util.Log;
import android.widget.Toast;

import com.android.benben.myretrofit.APP;
import com.android.benben.myretrofit.data.RetData;
import com.android.benben.myretrofit.net.NetWork;
import com.android.benben.myretrofit.service.BaseAPIService;
import com.android.benben.myretrofit.service.EventFinish;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Time      2017/3/13 14:40 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class RetrofitUtil {
    private static Retrofit retrofit;
    private static BaseAPIService apiService;

    private static void init() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(NetWork.HTTP_ROOT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .validateEagerly(true)
                    .build();
        }

        if (apiService == null) {
                apiService = retrofit.create(BaseAPIService.class);
        }
    }

    private static <T> RetData<T> getResult(Response<RetData> response, Class<T> tClass) {
        if (response.isSuccessful()) {
            if (response.body() == null) {
                Toast.makeText(APP.getContext(), "服务器错误，请稍后再试", Toast.LENGTH_LONG).show();
                return null;
            } else {
                if (response.body().getError_code() == 0) {
                    if (tClass == null) {
                        return response.body();
                    } else {
                        return response.body().getRetData(tClass);
                    }
                } else {
                    Toast.makeText(APP.getContext(), response.body().getReason(), Toast.LENGTH_LONG).show();
                    return null;
                }
            }
        } else {
            LogUtils.e("error_code=" + response.code());
            Toast.makeText(APP.getContext(), "网络错误，请检查网络设置", Toast.LENGTH_LONG).show();
            return null;
        }
    }


    /**
     * 异步POST请求
     * @param action action接口
     * @param params 请求参数
     * @param tClass 结果对象
     * @param event 请求完成回调接口
     * @param showLoading 是否显示加载对话框
     * @param <T>
     * @return
     */

    public static <T> Call<RetData> asyncPost(String action, HashMap<String, Object> params,
                                              final Class<T> tClass, final EventFinish<T> event,
                                              final boolean showLoading) {
        if (showLoading) {
        Toast.makeText(APP.getContext(),"异步提示对话框，稍后完善",Toast.LENGTH_LONG).show();
        }
        init();

        LogUtils.e("url=" + NetWork.HTTP_ROOT + action);
        if (params == null) {
            params = new HashMap<>();
        }

        addParams(params);
        Call<RetData> call = apiService.getDataWithPost(action, params);
        Log.i("lyx", "asyncPost: " + call);
//        call.enqueue(new Callback<RetData>() {
//            @Override
//            public void onResponse(Call<RetData> call, Response<RetData> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<RetData> call, Throwable t) {
//
//            }
//        });
        call.enqueue(new Callback<RetData>() {
            @Override
            public void onResponse(Call<RetData> call, Response<RetData> response) {
                if (showLoading) {
                    Toast.makeText(APP.getContext(), "联网结束", Toast.LENGTH_LONG).show();
                    RetData<T> retData = getResult(response, tClass);
                    if (event != null) {
                        event.onFinish(retData);
                    }
                }
            }

            @Override
            public void onFailure(Call<RetData> call, Throwable t) {
                if (showLoading) {
                    Toast.makeText(APP.getContext(), "联网结束", Toast.LENGTH_LONG).show();
                    LogUtils.i("联网结束");
                }
                if (event != null) {
                    Toast.makeText(APP.getContext(), "网络错误，请检查网络设置", Toast.LENGTH_LONG).show();
                    LogUtils.i("网络错误，请检查网络设置");
                    event.onFinish(null);
                }
                t.printStackTrace();
            }
        });
        return call;
    }

    private static void addParams(HashMap<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            sb.append(key + " : " + params.get(key) + "\n");
        }
        LogUtils.e(sb.toString());
    }


    public static <T> RetData<T> post(String action, ContentValues vs, Class<T> tClass, EventFinish<T> event) {
        HashMap<String, Object> params = new HashMap<>();
        Iterator<?> iter = vs.valueSet().iterator();
        while (iter.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry entry = (Map.Entry) iter.next();
            if (entry.getValue() instanceof Integer) {
                if (entry.getValue().equals(0)) {
                    params.put(entry.getKey().toString(),
                            entry.getValue() == null ? null : entry.getValue().toString());
                }else {
                    params.put(entry.getKey().toString(),
                            entry.getValue().toString());
                }
            }else {
                params.put(entry.getKey().toString(),
                        entry.getValue() == null ? null : entry.getValue().toString());
            }
        }
        asyncPost(action, params, tClass, event, false);
        return null;
    }

    public static <T> void post(String action, HashMap<String, Object> params, Class<T> tClass, EventFinish<T> event) {
        asyncPost(action, params, tClass, event, false);
    }

    public static <T> void post(String action, HashMap<String, Object> params, Class<T> tClass, EventFinish<T> event, boolean b) {
        asyncPost(action, params, tClass, event, b);
    }

    public static void post(String action, HashMap<String, Object> params, EventFinish event) {
        asyncPost(action, params, null, event, true);
    }

    public static <T> RetData<T> post(String action,HashMap<String,Object> params,final  Class<T> tClass) throws  Exception {
        init();
        LogUtils.e("url=" + NetWork.HTTP_ROOT + action);
        if (params == null) {
            params = new HashMap<>();
        }
        Call<RetData> call = apiService.getDataWithPost(action, params);
        Response<RetData> response = null;
        response = call.execute();
        if (response == null) {
            Toast.makeText(APP.getContext(), "服务器错误，请稍后再试", Toast.LENGTH_LONG).show();
            LogUtils.i("服务器错误，请稍后再试");
            throw new NullPointerException("服务器错误，请稍后再试");
        }else {
            if (response.isSuccessful()) {
                if (response.body() == null) {
                    Toast.makeText(APP.getContext(), "服务器错误，请稍后再试", Toast.LENGTH_LONG).show();
                    LogUtils.i("服务器错误，请稍后再试");
                    throw new NullPointerException("服务器错误，请稍后再试");
                }else {
                    if (response.body().getError_code() == 1) {
                        if (tClass == null) {
                            return response.body();
                        }else {
                            return response.body().getRetData(tClass);
                        }
                    }else {
                        Toast.makeText(APP.getContext(), response.body().getReason(), Toast.LENGTH_LONG).show();

                        throw new NullPointerException(response.body().getReason());
                    }
                }
            }else {
                LogUtils.e("error_code=" + response.code());
                Toast.makeText(APP.getContext(), "网络错误"+response.code()+"，请检查网络设置", Toast.LENGTH_LONG).show();
                throw new NullPointerException("网络错误"+response.code()+"，请检查网络设置");
            }
        }
    }

    @UiThread
    public static void showMsg(String msg) {
        ToastUtil.show(msg);
    }
}
