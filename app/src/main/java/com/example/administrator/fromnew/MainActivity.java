package com.example.administrator.fromnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);

        //关键代码
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String s = bundle.get("key").toString();
        textView1.setText(s);
    }
}
