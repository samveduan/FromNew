package com.example.administrator.fromnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp3Activity extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http3);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //核心代码
                sendRequestWithOkHttp();
            }
        });
    }

    //核心代码
    private void sendRequestWithOkHttp(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            //要在服务器环境下运行data.json
                            .url("http://localhost:8080/Android/json/data.json")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJsonWithGson(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //核心代码
    private void parseJsonWithGson(String jsonData){
        Type type = new TypeToken<LinkedList<User_json>>(){}.getType();
        Gson gson = new Gson();
        LinkedList<User_json> users = gson.fromJson(jsonData, type);
        for(Iterator iterator = users.iterator(); iterator.hasNext();){
            User_json user = (User_json)iterator.next();
            Log.v("Gson","username:" + user.getUsername() + "id:" + user.getUserId());
        }
    }
}
