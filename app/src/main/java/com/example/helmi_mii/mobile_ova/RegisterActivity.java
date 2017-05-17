package com.example.helmi_mii.mobile_ova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etNama = (EditText) findViewById(R.id.etNama);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etRePassword = (EditText) findViewById(R.id.etRePassword);
        final EditText etNomorTelp = (EditText) findViewById(R.id.etNomorTelp);
        final Button bDaftar = (Button) findViewById(R.id.etDaftar);
    }
}
