package com.example.infogate3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class afterScan extends AppCompatActivity {
TextView tv;
String t111;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);
        tv=(TextView)findViewById(R.id.display);
        Intent intent=new Intent();
        t111=getIntent().getStringExtra("keydisplay");
        tv.setText(t111);


    }
}