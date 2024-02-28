package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity
{

    EditText Ausername,Apwd;
    Button Abtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

//        Ids of fields from activity_admin_login.xml
        Ausername = findViewById(R.id.adminUsername);
        Apwd = findViewById(R.id.adminPassword);
        Abtn = findViewById(R.id.adminBtn);

        Abtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (Ausername.getText().toString().equals("user") && Apwd.getText().toString().equals("1234"))
                {
                    Toast.makeText(AdminLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminLogin.this,AfterAdminLogin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else
                {
                    Toast.makeText(AdminLogin.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}