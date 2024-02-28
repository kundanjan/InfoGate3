package com.example.infogate3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ScannerRecords extends AppCompatActivity {
    EditText nameofBrand;
    EditText supplierAddress;
    EditText dateofReciept;
    EditText costofComp;
    EditText DSR,SR;
    EditText nameofDepart;
    EditText nameofLab;
    Button btn;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scanner_records);
        nameofBrand =(EditText) findViewById(R.id.nameOfBrand);
        supplierAddress =(EditText) findViewById(R.id.suppliersAddress);
        dateofReciept =(EditText) findViewById(R.id.dateOfReceiptOfComputers);
        costofComp =(EditText) findViewById(R.id.costOfComputers);
        DSR =(EditText) findViewById(R.id.DSRPageNo);
        SR=(EditText) findViewById(R.id.SRNo);
        nameofDepart =(EditText) findViewById(R.id.nameOfDepartment);
        nameofLab =(EditText) findViewById(R.id.nameOfLab);
        btn = (Button) findViewById(R.id.scanner_btn);


        // Generate QR code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScannerRecords.this, generateQR.class);

                String nameBrand = nameofBrand.getText().toString();
                String suppaddress = supplierAddress.getText().toString();
                String dateReceipt = dateofReciept.getText().toString();
                String costcomp = costofComp.getText().toString();
                String DSR_no = DSR.getText().toString();
                String SR_no=SR.getText().toString();
                String nameDepart = nameofDepart.getText().toString();
                String nameLab = nameofLab.getText().toString();

                if (nameBrand.isEmpty()||suppaddress.isEmpty()||dateReceipt.isEmpty()||costcomp.isEmpty()||DSR_no.isEmpty()||SR_no.isEmpty()||nameDepart.isEmpty()||nameLab.isEmpty()) {
                    Toast.makeText(ScannerRecords.this, "Please  Enter all field properly", Toast.LENGTH_LONG).show();
                }else
                {
                    intent.putExtra("key1","Name of Brand : "+nameBrand);
                    intent.putExtra("key2","\n\nsupplier Address : "+suppaddress);
                    intent.putExtra("key3","\n\nDate of Receipt : "+dateReceipt);
                    intent.putExtra("key4","\n\nCost of device : "+costcomp);
                    intent.putExtra("key5","\n\nDSR page no.: "+DSR_no);
                    intent.putExtra("key6","\n\nSR no.: "+SR_no);
                    intent.putExtra("key7","\n\nName of Department : "+nameDepart);
                    intent.putExtra("key8","\n\nName of Lab : "+nameLab);

                    startActivity(intent);
            }
        }
        });
    }
}