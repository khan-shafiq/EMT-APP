package com.example.abc.emt1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLXML;

public class MainActivity extends AppCompatActivity {
    Button btnRegister;
    EditText edtFullName;
    EditText edtMobile;
    EditText edtEmail;
    EditText edtBloodGroup;
    EditText edtOfficeStreetName;
    EditText edtOfficeAreaName;
    EditText edtOfficePinCode;

    EditText edtHomeStreetName;
    EditText edttHomeAreaName;
    EditText edtHomePinCode;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        edtFullName = (EditText)findViewById(R.id.edtFullName);
        edtMobile = (EditText)findViewById(R.id.edtMobile);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtBloodGroup = (EditText)findViewById(R.id.edtBloodGroup);

        edtOfficeStreetName = (EditText)findViewById(R.id.edtOfficeStreetName);
        edtOfficeAreaName = (EditText)findViewById(R.id.edtOfficeAreaName);
        edtOfficePinCode = (EditText)findViewById(R.id.edtOfficePinCode);

        edtHomeStreetName = (EditText)findViewById(R.id.edtHomeStreetName);
        edttHomeAreaName = (EditText)findViewById(R.id.edtHomeAreaName);
        edtHomePinCode = (EditText)findViewById(R.id.edtHomePinCode);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();
                String fullName = edtFullName.getText().toString().trim();
                if(fullName.length()<3)
                {
                    Toast.makeText(MainActivity.this,"Invalid Name",Toast.LENGTH_LONG).show();
                    return;
                }

                String mobile = edtMobile.getText().toString().trim();
                if(mobile.length()<10)
                {
                    Toast.makeText(MainActivity.this,"Invalid Mobile Number",Toast.LENGTH_LONG).show();
                    return;
                }
                String email = edtEmail.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

// onClick of button perform this simplest code.
                if (email.matches(emailPattern))
                {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                    databaseHelper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.full_name,fullName);
                values.put(DatabaseHelper.mobile, mobile);

                Log.d("LogCat",DatabaseHelper.USER_CREATE_QUERY);
//                Toast.makeText(MainActivity.this,values.toString(),Toast.LENGTH_LONG).show();
// Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(DatabaseHelper.USER_TABLE, null, values);
                if(newRowId>0)
                {
                    Toast.makeText(MainActivity.this,"Registration Successful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,Homescreen.class));
                }
//                    Toast.makeText(MainActivity.this,"inserted id is "+newRowId,Toast.LENGTH_LONG).show();
            }
        });
        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM VOLUNTEER", new String[]{});

        if(cursor != null){
            cursor.moveToFirst();
        }

        StringBuilder builder = new StringBuilder();

        do{
            String name = cursor.getString(1);
            String p_no = cursor.getString(2);
            String homepin = cursor.getString(3);
            String offpin = cursor.getString(4);

            builder.append("NAME - "+name+" p_no - "+p_no+" homepin "+homepin+" offpin "+offpin);

        }
        while(cursor.moveToNext());



    }



    public void home(View h){
        Intent i = new Intent(getApplicationContext(),Homescreen.class);
        startActivity(i);
    }
    public void loginActivity(View l){
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }


}
