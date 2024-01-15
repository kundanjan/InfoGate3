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

public class generateQR extends AppCompatActivity {
    public static Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

//        EditText edit=findViewById(R.id.esit_text);
//        Button button=findViewById(R.id.gbutton);
        ImageView image=findViewById(R.id.qr_code);
        Button button2=findViewById(R.id.print);
  //     EditText text2=edit;
        String t1=getIntent().getStringExtra("key1");
        String t2=getIntent().getStringExtra("key2");
        String t3=getIntent().getStringExtra("key3");
        String t4=getIntent().getStringExtra("key4");
        String t5=getIntent().getStringExtra("key5");
        String t6=getIntent().getStringExtra("key6");
        String t7=getIntent().getStringExtra("key7");
        String data=t1+','+t2+','+t3+','+t4+','+t5+','+t6+','+t7;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix=multiFormatWriter.encode(data, BarcodeFormat.QR_CODE,300,300);
            BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
            Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);

        }catch(WriterException e)
        {
            throw new RuntimeException(e);
        }




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(generateQR.this,print_qr.class);
                startActivity(intent);
            }
        });


//
    }
}