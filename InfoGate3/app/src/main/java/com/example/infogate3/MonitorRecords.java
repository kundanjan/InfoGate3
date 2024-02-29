package com.example.infogate3;

import static com.example.infogate3.SignUp.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;

public class MonitorRecords extends AppCompatActivity {

    EditText nameofBrandM;
    EditText supplierAddressM;
    EditText dateofRecieptM;
    EditText costofCompM;
    EditText DSRM;
    EditText SrNo;
    EditText nameofDepartM;
    EditText nameofLabM;
    Button btn;

    OkHttpClient client;
    static String url = "https://infogateapi.onrender.com/add_monitor";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_monitor_records);
        nameofBrandM =(EditText) findViewById(R.id.nameOfBrand);
        supplierAddressM =(EditText) findViewById(R.id.suppliersAddress);
        dateofRecieptM =(EditText) findViewById(R.id.dateOfReceiptOfComputers);
        costofCompM =(EditText) findViewById(R.id.costOfComputers);
        DSRM =(EditText) findViewById(R.id.DSRPageNo);
        SrNo =(EditText) findViewById(R.id.SRNo);
        nameofDepartM =(EditText) findViewById(R.id.nameOfDepartment);
        nameofLabM =(EditText) findViewById(R.id.nameOfLab);
        btn = (Button) findViewById(R.id.monitor_btn);

        client = new OkHttpClient();
        // Generate QR code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameBrand = nameofBrandM.getText().toString();
                String suppaddress = supplierAddressM.getText().toString();
                String dateReceipt = dateofRecieptM.getText().toString();
                String costcomp = costofCompM.getText().toString();
                String DSR_Sr = DSRM.getText().toString();
                String Srno = SrNo.getText().toString();
                String nameDepart = nameofDepartM.getText().toString();
                String nameLab = nameofLabM.getText().toString();
                // Assuming you have a reference to your activity or fragment named "myActivity"

                RequestQueue requestQueue = Volley.newRequestQueue(MonitorRecords.this);


                sendMonitorData(requestQueue,nameBrand,suppaddress,dateReceipt,Integer.parseInt(costcomp),DSR_Sr,nameDepart,nameLab,Srno);

                Intent intent = new Intent(MonitorRecords.this, generateQR.class);
                if (nameBrand.isEmpty() || suppaddress.isEmpty() || dateReceipt.isEmpty() || costcomp.isEmpty() || DSR_Sr.isEmpty() || nameDepart.isEmpty() || nameLab.isEmpty()) {
                    Toast.makeText(MonitorRecords.this, "Please  Enter all field properly", Toast.LENGTH_LONG).show();
                } else {

                    intent.putExtra("key1","\nSerial Number: "+Srno);
                    intent.putExtra("key2","\nName of Brand: "+nameBrand);
                    intent.putExtra("key3","\nsupplier Address: "+suppaddress);
                    intent.putExtra("key4","\nDate of Receipt: "+dateReceipt);
                    intent.putExtra("key5","\nCost of device: "+costcomp);
                    intent.putExtra("key6","\nDSR page & SR no. : "+DSR_Sr);
                    intent.putExtra("key7","\nName of Department: "+nameDepart);
                    intent.putExtra("key8","\n Name of Lab: "+nameLab);
                    startActivity(intent);
                }
            }
        });
    }

    public static void sendMonitorData(RequestQueue requestQueue, String brandName, String supplierAddress,
                                       String dateOfReceipt, int costOfComputer, String dsrNo, String department, String laboratory,String Srno) {

    // Create a JSONObject to hold the data
    JSONObject data = new JSONObject();
    try {
        data.put("name_of_brand", brandName);
        data.put("suppliers_full_address", supplierAddress);
        data.put("date_of_receipt_of_computer", dateOfReceipt);
        data.put("cost_of_computer", costOfComputer);
        data.put("dsr_page_no", dsrNo);
        data.put("name_of_department", department);
        data.put("name_of_laboratory", laboratory);
        data.put("sr_no", Srno);
    } catch (JSONException e) {
        Log.e(TAG, "Error creating JSON data: " + e.getMessage());
        return; // Handle error here, e.g., display an error message to the user
    }

    // Create a JSON request object
    JsonObjectRequest request = new JsonObjectRequest(
            Request.Method.POST, url, data,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if (response.has("transaction_hash")) {
                        try {
                            String transactionHash = response.getString("transaction_hash");
                            Log.i(TAG, "Successful transaction: " + transactionHash);
                            // Implement success handling here, e.g., notify user
                        } catch (JSONException e) {
                            Log.e(TAG, "Error parsing response: " + e.getMessage());
                        }
                    } else {
                        Log.w(TAG, "Unknown response format, transaction hash missing.");
                        // Handle unexpected response format here
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "Error sending request: " + error.getMessage());
                    // Handle network error here
                }
            }
    );

    // Add the request to the queue
    requestQueue.add(request);
}

}