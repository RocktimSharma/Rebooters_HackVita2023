package com.example.pha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1001;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;

    AppCompatEditText RegEmail;
    AppCompatEditText RegPwd;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set click listener for sign in button
        Button SignInButton = findViewById(R.id.sign_in_button);

        //data fetching
        RegEmail = findViewById(R.id.user_email);
        RegPwd = findViewById(R.id.user_pwd);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        SignInButton.setOnClickListener(view -> {
            createUser();
        });


    }
    private void createUser(){
        String email = RegEmail.getText().toString();
        String pwd = RegPwd.getText().toString();

        if (TextUtils.isEmpty(email)){
            RegEmail.setError("Email cannot be empty");
            RegEmail.requestFocus();
        } else if (TextUtils.isEmpty(pwd)) {
            RegPwd.setError("Password cannot be empty");
            RegPwd.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
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
}