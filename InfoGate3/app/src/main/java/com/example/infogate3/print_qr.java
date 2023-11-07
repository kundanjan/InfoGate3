package com.example.infogate3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class print_qr extends AppCompatActivity {
    // Get the PrintManager
    PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

    // Set a print job name
    String jobName = "QR Code Print";
    Button button2=generateQR.button2;

    // Create a print job
    PrintDocumentAdapter pda = new PrintDocumentAdapter() {

        @Override
        public void onWrite(PageRange[] pages, ParcelFileDescriptor destination, CancellationSignal cancellationSignal, WriteResultCallback callback) {
            try {

                Bitmap bitmap =button2.getDrawingCache();
                button2.setDrawingCacheEnabled(false);
                // Write the QR code bitmap to the output stream
                OutputStream output = new FileOutputStream(destination.getFileDescriptor());
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                output.close();
                callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } catch (IOException e) {
                // Handle any exceptions
            }
        }

        @Override
        public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes, CancellationSignal cancellationSignal, LayoutResultCallback callback, Bundle extras) {
            // Handle layout changes if needed
        }
    };

    PrintJob printJob = printManager.print(jobName, pda, null);

// Handle print job status or completion as needed
}