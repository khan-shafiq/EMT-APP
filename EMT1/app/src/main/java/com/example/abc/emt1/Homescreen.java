package com.example.abc.emt1;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Homescreen extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private EditText mEditTextNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        TextView txt = findViewById(R.id.text);
        txt.setSelected(true);

        mEditTextNumber = findViewById(R.id.edit_text_number);
        ImageView imageCall = findViewById(R.id.image_call);

        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    public void ToastActivity(View tm) {

        Toast.makeText(getApplicationContext(),"Thank you for your valuable feeddback",Toast.LENGTH_SHORT).show();

    }

    private void makePhoneCall() {
        //String number = mEditTextNumber.getText().toString();
        String number = "9082950495";
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(Homescreen.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Homescreen.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(Homescreen.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
