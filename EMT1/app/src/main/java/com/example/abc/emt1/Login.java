package com.example.abc.emt1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void shafiq(View s){

        Intent i = new Intent(getApplicationContext(),Homescreen.class);
        startActivity(i);

    }

    public void amisha(View as){

        Intent i = new Intent(getApplicationContext(),Feedback.class);
        startActivity(i);

    }
    public void tst(View ts){

        Toast.makeText(getApplicationContext(),"OTP has been send to your registered mobile numnber",Toast.LENGTH_SHORT).show();

    }
    }
