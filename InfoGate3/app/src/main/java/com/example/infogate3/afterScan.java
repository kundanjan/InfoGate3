package com.example.infogate3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class afterScan extends AppCompatActivity {
TextView tv;
String t1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);
        tv=(TextView)findViewById(R.id.display);
        Intent intent=new Intent();
        t1=getIntent().getStringExtra("keydisplay");
        tv.setText(t1);


    }
}