package com.example.infogate3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


class MonitorInfo {
    public String id;
    public String name_of_brand;
    public String suppliers_full_address;
    public String date_of_receipt_of_computer;
    public double cost_of_computer;
    public String dsr_no;
    public String name_of_department;
    public String name_of_laboratory;

    public String Srno;

}

//{"monitor_info":{"cost_of_computer":61000,"date_of_receipt_of_computer":1234567890,"dsr_page_no_and_sr_no":"DSRNO.21","id":1,"name_of_brand":"Dell","name_of_department":"Computer","name_of_laboratory":"Programming Lab","suppliers_full_address":"Jalgaon"}}

public class ViewMonitors extends AppCompatActivity {

    ImageView viewRecordsBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_monitors);


        RequestQueue queue = Volley.newRequestQueue(this);
        Gson gson = new Gson();

        String IdApi ="https://infogateapi.onrender.com/get_all_monitor_ids";

            RequestQueue requestQueue = Volley.newRequestQueue(this); // Ensure you have a Context for Volley
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, IdApi, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray monitorIdsJson = response.getJSONArray("monitor_ids");
                                Log.d("Length",""+monitorIdsJson.length());
                                LinearLayout ll = findViewById(R.id.LL);
                                for (int i = 0; i < monitorIdsJson.length(); i++) {
                                    // Inflate the layout programmatically
                                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                    RelativeLayout monitorView = (RelativeLayout) inflater.inflate(R.layout.monitor_card, null);
                                    TextView tv = monitorView.findViewById(R.id.viewMonitors).findViewById(R.id.monitor);

                                    String url ="https://infogateapi.onrender.com/get_monitor_info/"+(i+1);
                                    StringRequest stringRequest = new StringRequest(
                                            Request.Method.GET, url,
                                            response1 -> {
                                                try {
                                                    JSONObject jsonObject = new JSONObject(response1);
                                                    MonitorInfo monitorInfo = gson.fromJson(jsonObject.getJSONObject("monitor_info").toString(), MonitorInfo.class);
                                                    String str = "ID : "+monitorInfo.id+"\nName of Brand : "+monitorInfo.name_of_brand+"\nSerial no : "+monitorInfo.Srno+"\nSuplier Address : "+monitorInfo.suppliers_full_address+"\nDate of Receipt : "+monitorInfo.date_of_receipt_of_computer+"\nCost : "+monitorInfo.cost_of_computer+"\nDsr no : "+monitorInfo.dsr_no+"\nName of Dept : "+monitorInfo.name_of_department+"\nName of Lab : "+monitorInfo.name_of_laboratory;
                                                    tv.setText(str);
                                                }catch(Exception e){
                                                    System.out.println(e);
                                                }
                                            },
                                            error -> {
                                                Log.d("Volley", "Error: " + error.getMessage());
                                            }
                                    );

                                    queue.add(stringRequest);
                                    ll.addView(monitorView);
                                }
                            } catch (JSONException e) {
                                Log.e("MonitorIdFetcher", "Error parsing JSON response: " + e.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("MonitorIdFetcher", "API request failed: " + error.getMessage());
                }
            });
            requestQueue.add(request);










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

