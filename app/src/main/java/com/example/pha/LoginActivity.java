package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;


public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1001;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
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

        mAuth = FirebaseAuth.getInstance();
        register_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is used to switch from one activity to another.
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i); // invoke the RegisterActivity.
                finish();
            }
        });


        signIn_btn=findViewById(R.id.loginA_signin_btn);
        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_edTxt.getText().toString();
                String pwd = password_edTxt.getText().toString();
                //Write sign in codes here
                if (TextUtils.isEmpty(email)) {
                    email_edTxt.setError("Email cannot be empty");
                    email_edTxt.requestFocus();
                } else if (TextUtils.isEmpty(pwd)) {
                    password_edTxt.setError("Password cannot be empty");
                    password_edTxt.requestFocus();
                } else {
                    mAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                        public void onComplete(@NonNull Task<AuthResult> task){
                           if (task.isSuccessful()){
                               Toast.makeText(LoginActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(LoginActivity.this, UserProfile.class));
                           } else {
                               Toast.makeText(LoginActivity.this, "Oh no" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           }
                       }
                    });
                }
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