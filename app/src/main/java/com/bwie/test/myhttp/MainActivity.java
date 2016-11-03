package com.bwie.test.myhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bwie.test.myhttp.bean.Bean;
import com.bwie.test.myhttp.util.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        postObj();
    }
    public void postObj(){
        Bean b=new Bean();
        b.page="1";
        b.raws="20";
        OkHttpUtils.post("http://www.tngou.net/api/cook/list", b, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(result);
                    }
                });
            }
        });
    }
    public void init(){
        tv=(TextView)findViewById(R.id.tv);
    }
}
