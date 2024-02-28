package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

//        Registration Validations
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fullname.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String password = pwd.getText().toString().trim();
                String cpassword = cpwd.getText().toString().trim();


                if(TextUtils.isEmpty(name)){
                    fullname.setError("Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    pwd.setError("Password is Required.");
                    return;
                }

                if(TextUtils.isEmpty(cpassword)){
                    cpwd.setError("Confirm Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    pwd.setError("Password Must be greater than 6 Characters");
                    return;
                }

                if(password.equals(cpassword)){
                   // Intent intent =new Intent();

                    Toast.makeText(SignUp.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(SignUp.this,UserLogin.class);
                    intent.putExtra("k1",name);
                    intent.putExtra("k2",password);

                    startActivity(intent);
                }
                else {
                    Toast.makeText(SignUp.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}