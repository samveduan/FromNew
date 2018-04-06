package com.example.administrator.fromnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView1;
    private Button button1;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView1 = (TextView)findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(this);
        editText1 = (EditText) findViewById(R.id.editText1);
    }

    @Override
    public void onClick(View view){
        //关键代码
        String s = editText1.getText().toString();
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.putExtra("key", s);
        startActivity(intent);
    }
}
