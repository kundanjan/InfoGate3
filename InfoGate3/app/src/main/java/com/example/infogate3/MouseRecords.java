package com.example.infogate3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MouseRecords extends AppCompatActivity {
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
        setContentView(R.layout.activity_add_mouse_records);
        nameofDevice = (EditText) findViewById(R.id.nameOfDeviceU);
        nameofBrand =(EditText) findViewById(R.id.nameOfBrandU);
        supplierAddress =(EditText) findViewById(R.id.suppliersAddressU);
        dateofReciept =(EditText) findViewById(R.id.dateOfReceiptOfComputersU);
        costofComp =(EditText) findViewById(R.id.costOfComputersU);
        DSR =(EditText) findViewById(R.id.DSRPageNoandSRNoU);
        nameofDepart =(EditText) findViewById(R.id.nameOfDepartmentU);
        nameofLab =(EditText) findViewById(R.id.nameOfLabU);
        btn = (Button) findViewById(R.id.mouse_btn);
        // Generate QR code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MouseRecords.this, generateQR.class);
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