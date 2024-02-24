package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PrinterRecords extends AppCompatActivity {
    EditText namePrinter;
    EditText nameBrandP;
    EditText supplierAddressP;
    EditText dateofRecieptP;
    EditText costofCompP;
    EditText DSRP;
    EditText nameofDepartP;
    EditText nameofLabP;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_printer_records);
            namePrinter = (EditText) findViewById(R.id.nameOfDeviceP);
            nameBrandP =(EditText) findViewById(R.id.nameOfBrandP);
            supplierAddressP =(EditText) findViewById(R.id.suppliersAddressP);
            dateofRecieptP =(EditText) findViewById(R.id.dateOfReceiptOfComputersP);
            costofCompP =(EditText) findViewById(R.id.costOfComputersP);
            DSRP =(EditText) findViewById(R.id.DSRPageNoandSRNoP);
            nameofDepartP =(EditText) findViewById(R.id.nameOfDepartmentP);
            nameofLabP =(EditText) findViewById(R.id.nameOfLabP);
            btn = (Button) findViewById(R.id.printer_btn);
            // Generate QR code
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(PrinterRecords.this, generateQR.class);
                    String nameDevice = namePrinter.getText().toString();
                    String nameBrand = nameBrandP.getText().toString();
                    String suppaddress = supplierAddressP.getText().toString();
                    String dateReceipt = dateofRecieptP.getText().toString();
                    String costcomp = costofCompP.getText().toString();
                    String DSR_Sr = DSRP.getText().toString();
                    String nameDepart = nameofDepartP.getText().toString();
                    String nameLab = nameofLabP.getText().toString();
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
