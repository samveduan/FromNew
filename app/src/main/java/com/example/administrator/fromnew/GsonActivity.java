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

public class GsonActivity extends AppCompatActivity {
    Button button1;
    //json对象
    String json_data = "[{\"username\":\"小明\",\"userid\":01}," +
            "{\"username\":\"小李\",\"userid\":02}," +
            "{\"username\":\"小李\",\"userid\":03}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //核心代码
                Type type = new TypeToken<LinkedList<User_json>>(){}.getType();
                Gson gson = new Gson();
                LinkedList<User_json> users = gson.fromJson(json_data, type);
                for(Iterator iterator = users.iterator(); iterator.hasNext();){
                    User_json user = (User_json)iterator.next();
                    Log.v("Gson","username:" + user.getUsername() + "id:" + user.getUserId());
                }
            }
        });
    }
}

//关键bean
class User_json {
    private String username ;
    private  int  userid ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }
}