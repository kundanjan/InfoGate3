package com.example.infogate3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardRecords extends AppCompatActivity {
    EditText nameofDeviceK;
    EditText nameofBrandK;
    EditText supplierAddressK;
    EditText dateofRecieptK;
    EditText costofCompK;
    EditText DSRK;
    EditText nameofDepartK;
    EditText nameofLabK;
    Button btn;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_keyboard_records);
        nameofDeviceK = (EditText) findViewById(R.id.nameOfDeviceK);
        nameofBrandK =(EditText) findViewById(R.id.nameOfBrandK);
        supplierAddressK =(EditText) findViewById(R.id.suppliersAddressK);
        dateofRecieptK =(EditText) findViewById(R.id.dateOfReceiptOfComputersK);
        costofCompK =(EditText) findViewById(R.id.costOfComputersK);
        DSRK =(EditText) findViewById(R.id.DSRPageNoandSRNoK);
        nameofDepartK =(EditText) findViewById(R.id.nameOfDepartmentK);
        nameofLabK =(EditText) findViewById(R.id.nameOfLabK);
        btn = (Button) findViewById(R.id.keyboard_btn);
        // Generate QR code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(KeyboardRecords.this, generateQR.class);
                String nameDevice = nameofDeviceK.getText().toString();
                String nameBrand = nameofBrandK.getText().toString();
                String suppaddress = supplierAddressK.getText().toString();
                String dateReceipt = dateofRecieptK.getText().toString();
                String costcomp = costofCompK.getText().toString();
                String DSR_Sr = DSRK.getText().toString();
                String nameDepart = nameofDepartK.getText().toString();
                String nameLab = nameofLabK.getText().toString();
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