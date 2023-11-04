package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    public static final String TAG="TAG";
    EditText fullname,email,pwd,cpwd;
    Button regbtn;
    TextView loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname = findViewById(R.id.signeditTextText1);
        email = findViewById(R.id.signeditTextText2);
        pwd = findViewById(R.id.signeditTextPassword1);
        cpwd = findViewById(R.id.signeditTextPassword2);
        regbtn = findViewById(R.id.signbutton8);
        loginbtn = findViewById(R.id.textView2);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),UserLogin.class));
            }
        });

    }
}