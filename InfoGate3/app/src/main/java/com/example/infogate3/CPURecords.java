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

public class CPURecords extends AppCompatActivity
{

    EditText nameofBrand;
    EditText supplierAddress;
    EditText dateofReciept;
    EditText costofComp;
    EditText DSR,SR;
    EditText nameofDepart;
    EditText nameofLab;
    Button btn;

    static String url="https://infogateapi.onrender.com/add_cpu";

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cpu_records);
        nameofBrand =(EditText) findViewById(R.id.nameOfBrand);
        supplierAddress =(EditText) findViewById(R.id.suppliersAddress);
        dateofReciept =(EditText) findViewById(R.id.dateOfReceiptOfComputers);
        costofComp =(EditText) findViewById(R.id.costOfComputers);
        DSR =(EditText) findViewById(R.id.DSRPageNo);
        SR=(EditText) findViewById(R.id.SRNo);
        nameofDepart =(EditText) findViewById(R.id.nameOfDepartment);
        nameofLab =(EditText) findViewById(R.id.nameOfLab);
        btn = (Button) findViewById(R.id.cpubtn);


        // Generate QR code
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CPURecords.this, generateQR.class);
                String nameBrand = nameofBrand.getText().toString();
                String suppaddress = supplierAddress.getText().toString();
                String dateReceipt = dateofReciept.getText().toString();
                String costcomp = costofComp.getText().toString();
                String DSR_no = DSR.getText().toString();
                String SR_no=SR.getText().toString();
                String nameDepart = nameofDepart.getText().toString();
                String nameLab = nameofLab.getText().toString();

                if (nameBrand.isEmpty()||dateReceipt.isEmpty()||costcomp.isEmpty()||DSR_no.isEmpty()||nameDepart.isEmpty()||nameLab.isEmpty())
                {
                    Toast.makeText(CPURecords.this, "Please Enter all field properly", Toast.LENGTH_LONG).show();
                }
                else
                {
                    RequestQueue requestQueue = Volley.newRequestQueue(CPURecords.this);
                    sendCpuData(requestQueue,nameBrand,suppaddress,dateReceipt,Integer.parseInt(costcomp),DSR_no,nameDepart,nameLab,SR_no);

                    intent.putExtra("key1","Name of Brand : "+nameBrand);
                    intent.putExtra("key2","\n\nSupplier Address : "+suppaddress);
                    intent.putExtra("key3","\n\nDate of Receipt : "+dateReceipt);
                    intent.putExtra("key4","\n\nCost of device : "+costcomp);
                    intent.putExtra("key5","\n\nDSR page no. and SR no.: "+DSR_no);
                    intent.putExtra("key6","\n\nSerial no.: "+SR_no);
                    intent.putExtra("key7","\n\nName of Department : "+nameDepart);
                    intent.putExtra("key8","\n\nName of Lab : "+nameLab);
                    startActivity(intent);
                }
            }
        });
    }
    public static void sendCpuData(RequestQueue requestQueue, String brandName, String supplierAddress,
                                     String dateOfReceipt, int costOfComputer, String dsrNo, String department, String laboratory, String Srno) {

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