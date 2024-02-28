package com.example.infogate3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class generateQR extends AppCompatActivity
{
    public ImageView img;

    // final static int REQUEST_CODE = 1232;
    PdfDocument pdfDocument;
    Button btn;
    public Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        try
        {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, 400, 400);
            img.setImageBitmap(bitmap);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //    askPermissions();
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                // Create PDF document as before
                pdfDocument = new PdfDocument();
                PdfDocument.PageInfo pi = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
                PdfDocument.Page page = pdfDocument.startPage(pi);

                Paint paint = new Paint();
                int x = 5, y = 5;
                Canvas canvas = page.getCanvas();
                canvas.drawBitmap(bitmap, x, y, paint);

                pdfDocument.finishPage(page);

                // Request user permission to save the PDF using SAF
                Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("application/pdf");
                intent.putExtra(Intent.EXTRA_TITLE, "myPDFFile.pdf");
                startActivityForResult(intent, 1); // Replace with your request code

                // Close the document before starting activity
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK)
        {
            if (data != null)
            {
                Uri uri = data.getData();
                try
                {
                    // Write PDF content to the selected file using the URI
                    pdfDocument.writeTo(getContentResolver().openOutputStream(uri));
                    Toast.makeText(generateQR.this, "PDF File saved successfully", Toast.LENGTH_SHORT).show();
                    pdfDocument.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(generateQR.this, "Error saving PDF", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}