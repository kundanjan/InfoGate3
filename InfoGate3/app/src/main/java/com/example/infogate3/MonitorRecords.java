package com.example.infogate3;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MonitorRecords extends AppCompatActivity {


    EditText nameofDeviceM;
    EditText nameofBrandM;
    EditText supplierAddressM;
    EditText dateofRecieptM;
    EditText costofCompM;
    EditText DSRM;
    EditText nameofDepartM;
    EditText nameofLabM;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_monitor_records);
        nameofDeviceM = (EditText) findViewById(R.id.nameOfDeviceM);
        nameofBrandM =(EditText) findViewById(R.id.nameOfBrandM);
        supplierAddressM =(EditText) findViewById(R.id.suppliersAddressM);
        dateofRecieptM =(EditText) findViewById(R.id.dateOfReceiptOfComputersM);
        costofCompM =(EditText) findViewById(R.id.costOfComputersM);
        DSRM =(EditText) findViewById(R.id.DSRPageNoandSRNoM);
        nameofDepartM =(EditText) findViewById(R.id.nameOfDepartmentM);
        nameofLabM =(EditText) findViewById(R.id.nameOfLabM);
        btn = (Button) findViewById(R.id.monitor_btn);
        // Generate QR code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MonitorRecords.this, generateQR.class);
                String nameDevice = nameofDeviceM.getText().toString();
                String nameBrand = nameofBrandM.getText().toString();
                String suppaddress = supplierAddressM.getText().toString();
                String dateReceipt = dateofRecieptM.getText().toString();
                String costcomp = costofCompM.getText().toString();
                String DSR_Sr = DSRM.getText().toString();
                String nameDepart = nameofDepartM.getText().toString();
                String nameLab = nameofLabM.getText().toString();
                intent.putExtra("key1",nameDevice);
                intent.putExtra("key2",nameBrand);
                intent.putExtra("key3",suppaddress);
                intent.putExtra("key4",dateReceipt);
                intent.putExtra("key5",costcomp);
                intent.putExtra("key6",DSR_Sr);
                intent.putExtra("key7",nameDepart);
                intent.putExtra("key8",nameLab);

                startActivity(intent);
            }
        });
    }
}