package com.example.helmi_mii.mobile_ova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final EditText etNama = (EditText) findViewById(R.id.etNama);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etNomorTelp = (EditText) findViewById(R.id.etNomorTelp);
        final TextView SelamatDatangMessage = (TextView) findViewById(R.id.tvSelamatDatang);
    }
}
