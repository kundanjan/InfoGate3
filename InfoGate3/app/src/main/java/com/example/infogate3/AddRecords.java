package com.example.infogate3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class AddRecords extends AppCompatActivity {
    public static Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);

        EditText nameOfBrand = findViewById(R.id.nameOfBrand);
        EditText suppliersAddress = findViewById(R.id.suppliersAddress);
        EditText dateOfReceiptOfComputers = findViewById(R.id.dateOfReceiptOfComputers);
        EditText costOfComputers = findViewById(R.id.costOfComputers);
        EditText DSRPageNoandSRNo = findViewById(R.id.DSRPageNoandSRNo);
        EditText nameOfDepartment = findViewById(R.id.nameOfDepartment);
        EditText nameOfLab = findViewById(R.id.nameOfLab);
        Button button = findViewById(R.id.button3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1 = nameOfBrand.getText().toString();
                String t2 = suppliersAddress.getText().toString();
                String t3 = dateOfReceiptOfComputers.getText().toString();
                String t4 = costOfComputers.getText().toString();
                String t5 = DSRPageNoandSRNo.getText().toString();
                String t6 = nameOfDepartment.getText().toString();
                String t7 = nameOfLab.getText().toString();
                Intent intent = new Intent(AddRecords.this, generateQR.class);
                intent.putExtra("key1", t1);
                intent.putExtra("key2", t2);
                intent.putExtra("key3", t3);
                intent.putExtra("key4", t4);
                intent.putExtra("key5", t5);
                intent.putExtra("key6", t6);
                intent.putExtra("key7", t7);
                startActivity(intent);

            }
        });
    }
}