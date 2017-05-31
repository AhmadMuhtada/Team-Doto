package com.example.helmi_mii.mobile_ova;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etNama, etEmail, etPassword, etNomorTelp, etJenisKel;
    private Button etDaftar;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNama = (EditText) findViewById(R.id.etNama);
        etNomorTelp = (EditText) findViewById(R.id.etNomorTelp);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etJenisKel= (EditText) findViewById(R.id.etJenisKel);


        etDaftar = (Button) findViewById(R.id.etDaftar);
        progressDialog = new ProgressDialog(this);

        etDaftar.setOnClickListener(this);


    }

    private void registerUser()
    {
        final String nama = etNama.getText().toString().trim();
        final String notel = etNomorTelp.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String gender = etJenisKel.getText().toString().trim();

        progressDialog.setMessage("Mendaftarkan User..");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        progressDialog.dismiss();

                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("NAMA_USER", nama);
                params.put("NO_TELP", notel);
                params.put("EMAIL_USER", email);
                params.put("PASSWORD_USER", password);
                params.put("JENIS_KELAMIN_USER", gender);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {

        if( view == etDaftar)
            registerUser();
    }
}
