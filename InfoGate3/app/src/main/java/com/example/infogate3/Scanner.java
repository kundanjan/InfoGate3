package com.example.infogate3;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;


public class Scanner extends AppCompatActivity {
    Button btn;

//easy one coder
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        btn=(Button) findViewById(R.id.btn_scan);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator i=new IntentIntegrator(Scanner.this);
                i.setOrientationLocked(true);
                i.setPrompt("Scan a QR Code");
                i.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                i.initiateScan();

            }
        });

        }

//        @Override
//        protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
//            IntentResult intentResult=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
//            if(intentResult!=null)
//            {
//                String contents=intentResult.getContents();
//            }
//            else
//            super.onActivityResult(requestCode,resultCode,data);
//
//
//
//    }
    //mdjamel

//    private void scanCode() {
//        ScanOptions options=new ScanOptions();
//        options.setPrompt("Volume up to flash on");
//        options.setBeepEnabled(true);
//        options.setOrientationLocked(true);
//        options.setCaptureActivity(CaptureAct.class);
//        barLaucher.launch(options);
//
//    }
//    ActivityResultLauncher<ScanOptions> barLaucher=registerForActivityResult(new ScanContract(),result -> {
//       if(result.getContents() != null)
//        {
//            AlertDialog.Builder builder=new AlertDialog.Builder(Scanner.this);
//            builder.setTitle("Result");
//            builder.setMessage(result.getContents());
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                }
//            }).show();
//        }
//    });
}




















