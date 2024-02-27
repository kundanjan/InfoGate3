package com.example.infogate3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import android.os.Environment;
import android.widget.Toast;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class generateQR extends AppCompatActivity {
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private ImageView img;
    private Button btn;
    Bitmap bitmap;

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


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            // Permission not granted, request it
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION}, REQUEST_WRITE_EXTERNAL_STORAGE);
        } else {
            // Permission already granted, proceed with your code
        }
        
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePdfFromBitmap(bitmap);
            }
        });
    }

        private void generatePdfFromBitmap(Bitmap bitmap)
        {
            try
            {
                // Create PDF document
                Document document = new Document();
                PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(Environment.getExternalStorageDirectory() + "/" + "QR_Code_PDF.pdf")));
                document.open();

                // Convert Bitmap to iText Image
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                Image qrCodeImage = Image.getInstance(stream.toByteArray());

                // Set image alignment and scale
                qrCodeImage.setAlignment(Image.ALIGN_CENTER);
                qrCodeImage.scaleToFit(400, 400); // Adjust as per your requirement

                // Add QR code image to PDF
                document.add(qrCodeImage);
                document.close();

                // Display success message
                Toast.makeText(generateQR.this, "PDF with QR code saved to " + Environment.getExternalStorageDirectory() + "/" + "QR_Code_PDF.pdf", Toast.LENGTH_SHORT).show();
            }
            catch (IOException | DocumentException e)
            {
                e.printStackTrace();
                Toast.makeText(generateQR.this, "Failed to generate PDF from QR code", Toast.LENGTH_SHORT).show();
            }
        }
    }

