package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;


class MonitorInfo {
    public String id;
    public String name_of_brand;
    public String suppliers_full_address;
    public String date_of_receipt_of_computer;
    public double cost_of_computer;
    public String dsr_page_no_and_sr_no;
    public String name_of_department;
    public String name_of_laboratory;

}

//{"monitor_info":{"cost_of_computer":61000,"date_of_receipt_of_computer":1234567890,"dsr_page_no_and_sr_no":"DSRNO.21","id":1,"name_of_brand":"Dell","name_of_department":"Computer","name_of_laboratory":"Programming Lab","suppliers_full_address":"Jalgaon"}}

public class ViewMonitors extends AppCompatActivity {

    ImageView viewRecordsBack;
    TextView mon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_monitors);

        mon = findViewById(R.id.monitor);

        RequestQueue queue = Volley.newRequestQueue(this);
        Gson gson = new Gson();
        String url = "https://infogateapi.onrender.com/get_monitor_info/1";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        MonitorInfo monitorInfo = gson.fromJson(jsonObject.getJSONObject("monitor_info").toString(), MonitorInfo.class);
                        String str = "ID : "+monitorInfo.id+"\nName of Brand:"+monitorInfo.name_of_brand+"\nSuplier Address : "+monitorInfo.suppliers_full_address+"\nDate of Receipt:"+monitorInfo.date_of_receipt_of_computer+"\nCost : "+monitorInfo.cost_of_computer+"\nDsr no:"+monitorInfo.dsr_page_no_and_sr_no+"\nName of Dept : "+monitorInfo.name_of_department+"\nName of Laboratory : "+monitorInfo.name_of_laboratory;
                        mon.setText(str);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                },
                error -> {
                    Log.d("Volley", "Error: " + error.getMessage());
                }
        );

        queue.add(stringRequest);



        viewRecordsBack = findViewById(R.id.viewRecordsBack);
        viewRecordsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewMonitors.this, AfterAdminLogin.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
}

