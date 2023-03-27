package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText email_edTxt,password_edTxt;
    private Button signIn_btn;
    private TextView forgetPassword_txt,register_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_edTxt= findViewById(R.id.loginA_email_edtxt);
        password_edTxt=findViewById(R.id.loginA_password_edtxt);
        register_txt=findViewById(R.id.loginA_register_txtVw);
        register_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is used to switch from one activity to another.
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i); // invoke the RegisterActivity.

            }
        });

        signIn_btn=findViewById(R.id.loginA_signin_btn);
        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Write sign in codes here
            }
        });

        forgetPassword_txt=findViewById(R.id.loginA_forget_txtVw);
        forgetPassword_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Write password reset code here
            }
        });

    }
}