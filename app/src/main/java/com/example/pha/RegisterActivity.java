package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText email_edTxt,password_edTxt,name_edTxt,phone_edTxt;

    private Button register_btn;
    private TextView logIn_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name_edTxt=findViewById(R.id.registerA_name_edtxt);
        phone_edTxt=findViewById(R.id.registerA_phno_edtxt);
        password_edTxt=findViewById(R.id.registerA_password_edtxt);
        email_edTxt=findViewById(R.id.registerA_email_edtxt);
        register_btn=findViewById(R.id.registerA_register_btn);
        logIn_txt=findViewById(R.id.registerA_login_txtVw);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        logIn_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i); // invoke the RegisterActivity.
            }
        });
    }
}