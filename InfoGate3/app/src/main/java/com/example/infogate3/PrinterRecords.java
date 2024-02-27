package com.example.infogate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrinterRecords extends AppCompatActivity {
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
                    String nameBrand = nameBrandP.getText().toString();
                    String suppaddress = supplierAddressP.getText().toString();
                    String dateReceipt = dateofRecieptP.getText().toString();
                    String costcomp = costofCompP.getText().toString();
                    String DSR_Sr = DSRP.getText().toString();
                    String nameDepart = nameofDepartP.getText().toString();
                    String nameLab = nameofLabP.getText().toString();

                    if (nameBrand.isEmpty() || suppaddress.isEmpty() || dateReceipt.isEmpty() || costcomp.isEmpty() || DSR_Sr.isEmpty() || nameDepart.isEmpty() || nameLab.isEmpty()) {
                        Toast.makeText(PrinterRecords.this, "Please Enter all field properly", Toast.LENGTH_LONG).show();
                    } else {

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
    }
