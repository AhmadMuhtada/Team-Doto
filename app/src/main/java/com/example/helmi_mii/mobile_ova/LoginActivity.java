package com.example.helmi_mii.mobile_ova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button bMasuk = (Button) findViewById(R.id.etMasuk);
        final TextView linkDaftar = (TextView) findViewById(R.id.linkDaftar);

        linkDaftar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent DaftarIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(DaftarIntent);

            }
        });
    }
}
