package com.example.infogate3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ScannerRecords extends AppCompatActivity {
    EditText nameofDevice;
    EditText nameofBrand;
    EditText supplierAddress;
    EditText dateofReciept;
    EditText costofComp;
    EditText DSR;
    EditText nameofDepart;
    EditText nameofLab;
    Button btn;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scanner_records);
        nameofDevice = (EditText) findViewById(R.id.nameOfDeviceS);
        nameofBrand =(EditText) findViewById(R.id.nameOfBrandS);
        supplierAddress =(EditText) findViewById(R.id.suppliersAddressS);
        dateofReciept =(EditText) findViewById(R.id.dateOfReceiptOfComputersS);
        costofComp =(EditText) findViewById(R.id.costOfComputersS);
        DSR =(EditText) findViewById(R.id.DSRPageNoandSRNoS);
        nameofDepart =(EditText) findViewById(R.id.nameOfDepartmentS);
        nameofLab =(EditText) findViewById(R.id.nameOfLabS);
        btn = (Button) findViewById(R.id.scanner_btn);
        // Generate QR code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScannerRecords.this, generateQR.class);
                String nameDevice = nameofDevice.getText().toString();
                String nameBrand = nameofBrand.getText().toString();
                String suppaddress = supplierAddress.getText().toString();
                String dateReceipt = dateofReciept.getText().toString();
                String costcomp = costofComp.getText().toString();
                String DSR_Sr = DSR.getText().toString();
                String nameDepart = nameofDepart.getText().toString();
                String nameLab = nameofLab.getText().toString();
                intent.putExtra("key1",nameDevice);
                intent.putExtra("key2",nameBrand);
                intent.putExtra("key3",suppaddress);
                intent.putExtra("key4",dateReceipt);
                intent.putExtra("key5",costcomp);
                intent.putExtra("key6",DSR_Sr);
                intent.putExtra("key7",nameDepart);
                intent.putExtra("key8",nameLab);

                startActivity(intent);
            }
        });
    }
}