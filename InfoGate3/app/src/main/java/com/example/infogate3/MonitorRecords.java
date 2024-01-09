package com.example.infogate3;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MonitorRecords extends AppCompatActivity {
EditText nameofDevice;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_monitor_records);

        nameofDevice = findViewById(R.id.nameOfDevice);
        nameofDevice.setEnabled(false);
    }
}