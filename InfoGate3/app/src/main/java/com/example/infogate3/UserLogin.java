package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class UserLogin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    EditText username,pwd;
    TextView signbtn;
    Button loginbtn;


//    variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        username = findViewById(R.id.editTextText);
        pwd = findViewById(R.id.editTextPassword);
        signbtn = findViewById(R.id.usertextView3);
        loginbtn = findViewById(R.id.button8);


        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)

            {

                String rname = username.getText().toString().trim();
                String rpwd = pwd.getText().toString().trim();
                String t1 = getIntent().getStringExtra("k1");
                String t2 = getIntent().getStringExtra("k2");



                if(rname.isEmpty()|| rpwd.isEmpty())
                {
                    Toast.makeText(UserLogin.this, "Enter Username and Password ", Toast.LENGTH_SHORT).show();
                }
                else if (t1.equals(rname) && t2.equals(rpwd))
                {
                        Toast.makeText(UserLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserLogin.this, Scan.class);
                        startActivity(intent);
                }
                else
                {
                    Toast.makeText(UserLogin.this, "Enter Username and Password Properly ", Toast.LENGTH_SHORT).show();

                }


            }
        });

        signbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                startActivity(new Intent(getApplicationContext(),SignUp.class));
                Intent intent = new Intent(UserLogin.this,SignUp.class);
                startActivity(intent);
            }
        });

//        Hooks
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

//        Toolbar
        setSupportActionBar(toolbar);

//        Navigation Drawer Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigration_open,R.string.navigration_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //toolbar menu icon
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_menu_24);

    }

    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }


    @Override
//selection on menu items
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        if(id == R.id.nav_adminLogin)
        {
            Intent intent = new Intent(UserLogin.this,AdminLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else if(id == R.id.nav_aboutus)
        {
            Intent intent = new Intent(UserLogin.this,AboutUs.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(UserLogin.this,AboutApp.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }
}