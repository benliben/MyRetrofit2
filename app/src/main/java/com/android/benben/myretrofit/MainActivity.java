package com.android.benben.myretrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import com.android.benben.myretrofit.data.RetData;
import com.android.benben.myretrofit.model.MoveModel;
import com.android.benben.myretrofit.net.NetWork;
import com.android.benben.myretrofit.service.EventFinish;
import com.android.benben.myretrofit.utils.LogUtils;
import com.android.benben.myretrofit.utils.RetrofitUtil;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> vs = new HashMap<>();
                vs.put("key", NetWork.KEY);
                vs.put("q", "心花怒放");
//                RetrofitUtil.post(NetWork.MOVIE, vs, new EventFinish() {
//                    @Override
//                    public void onFinish(RetData retData) {
//                        Log.i("lyx", "onFinish: " + retData.getData());
//                    }
//                });
                RetrofitUtil.asyncPost(NetWork.MOVIE, vs, MoveModel.class, new EventFinish<MoveModel>() {
                    @Override
                    public void onFinish(RetData<MoveModel> retData) {
                        LogUtils.i(retData.getData() + "");
                    }
                }, true);
            }
        });
    }
}
