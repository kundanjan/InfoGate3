package com.example.infogate3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class afterScan extends AppCompatActivity {

    TextView scannedValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);

        // Find the TextView in the layout
        scannedValueTextView = findViewById(R.id.scannedValueTextView);

        // Retrieve the scanned value from the Intent
        String scannedValue = getIntent().getStringExtra("keydisplay");

        // Set the scanned value to the TextView
        if (scannedValue != null) {
            scannedValueTextView.setText(scannedValue);
        }
    }
}
