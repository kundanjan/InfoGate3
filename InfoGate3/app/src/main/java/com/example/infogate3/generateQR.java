package com.example.infogate3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;

public class generateQR extends AppCompatActivity {
  public ImageView img;

   // final static int REQUEST_CODE = 1232;
    Button btn;
  public Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);
        btn = (Button) findViewById(R.id.print);
        img = (ImageView) findViewById(R.id.qr_code);

        Intent intent = new Intent();
        String t1 = getIntent().getStringExtra("key1");
        String t2 = getIntent().getStringExtra("key2");
        String t3 = getIntent().getStringExtra("key3");
        String t4 = getIntent().getStringExtra("key4");
        String t5 = getIntent().getStringExtra("key5");
        String t6 = getIntent().getStringExtra("key6");
        String t7 = getIntent().getStringExtra("key7");
        String t8 = getIntent().getStringExtra("key8");
        String data = t1 + ',' + t2 + ',' + t3 + ',' + t4 + ',' + t5 + ',' + t6 + ',' + t7 + ',' + t8;

        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, 400, 400);
            img.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    //    askPermissions();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    PdfDocument pdfDocument = new PdfDocument();
                    PdfDocument.PageInfo pi = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
                    //jguyhfuyf
                    PdfDocument.Page page = pdfDocument.startPage(pi);


                    Paint paint = new Paint();
                    int x = 5, y = 5;
                    Canvas canvas = page.getCanvas();
                    canvas.drawBitmap(bitmap, x, y, paint);  // float left = x, float top = y


                    pdfDocument.finishPage(page);

                    // save pdf file in Mobile Phone Storage
                    String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/myPDFFile.pdf";
                    File myFile = new File(myFilePath);
                    try {
                        pdfDocument.writeTo(new FileOutputStream(myFile));

                        Toast.makeText(generateQR.this, "PDF File saved in mobile Location", Toast.LENGTH_SHORT).show();

                    }
                    catch (Exception e) {
                        e.printStackTrace();

                    }

                    pdfDocument.close();
                }});


            }
    }





