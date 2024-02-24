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
import com.itextpdf.text.pdf.PdfDocument;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class generateQR extends AppCompatActivity {
  private ImageView img;
   private Button btn;
   Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);
        btn = (Button)findViewById(R.id.print);
        img = (ImageView) findViewById(R.id.qr_code);

        Intent intent=new Intent();
        String t1=getIntent().getStringExtra("Key1");
        String t2=getIntent().getStringExtra("key2");
        String t3=getIntent().getStringExtra("key3");
        String t4=getIntent().getStringExtra("key4");
        String t5=getIntent().getStringExtra("key5");
        String t6=getIntent().getStringExtra("key6");
        String t7=getIntent().getStringExtra("key7");
        String t8=getIntent().getStringExtra("key8");
        String data=t1+','+t2+','+t3+','+t4+','+t5+','+t6+','+t7+','+t8;

        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
             bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, 400, 400);
            img.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PdfDocument document = new PdfDocument();

                try {
                    // Set the file path for the PDF
                    String filePath = Environment.getExternalStorageDirectory().getPath() + "/GeneratedPDF.pdf";
                    PdfWriter.getInstance(document, new FileOutputStream(filePath));

                    document.open();

                    // Convert bitmap to byte array
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();

                    // Add image to PDF
                    Image image = Image.getInstance(byteArray);
                    document.add(image);

                   // document.close();

                    // Optionally, open the generated PDF
                    // openGeneratedPDF(filePath);

                } catch (DocumentException | IOException e) {
                    e.printStackTrace();
                }
            }


        });
            }
        }

