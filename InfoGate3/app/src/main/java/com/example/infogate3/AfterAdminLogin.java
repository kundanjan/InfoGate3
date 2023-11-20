package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AfterAdminLogin extends AppCompatActivity {
    Button addRecords;
    Button viewRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_admin_login);

        addRecords = findViewById(R.id.addRecordsBtn);
        viewRecords = findViewById(R.id.viewRecordsBtn);

        addRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AfterAdminLogin.this,AddRecords.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}