package com.example.pha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pha.model.UserRegistration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText email_edTxt,password_edTxt,name_edTxt,phone_edTxt;

    private Button register_btn;
    private TextView logIn_txt;
    FirebaseAuth mFireBaseAuth;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseReference;
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

        mFireBaseAuth=FirebaseAuth.getInstance();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = mFirebaseDatabase.getReference("UserInfo");

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String name=name_edTxt.getText().toString();
                 String email=email_edTxt.getText().toString();
                 String password=password_edTxt.getText().toString();
                 String ph=phone_edTxt.getText().toString();
                 if(name.isEmpty()){
                     name_edTxt.setError("Please provide your name");
                     name_edTxt.requestFocus();
                 }else if(email.isEmpty()){
                     email_edTxt.setError("Please provide an email");
                     email_edTxt.requestFocus();
                 }else if(password.isEmpty()){
                     password_edTxt.setError("Set a password");
                     password_edTxt.requestFocus();
                 }
                 else if(ph.isEmpty()){
                     phone_edTxt.setError("Set a password");
                     phone_edTxt.requestFocus();
                 }else if(!(email.isEmpty() && password.isEmpty())){
                     Log.i("Test 1","Wokring 1");
                     mFireBaseAuth.createUserWithEmailAndPassword(email,password)
                             .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                     if(task.isSuccessful()){

                                         UserRegistration userRegistration= new UserRegistration(name,ph);

                                         databaseReference
                                                 .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userRegistration).
                                                 addOnCompleteListener(new OnCompleteListener<Void>() {
                                                     @Override
                                                     public void onComplete(@NonNull Task<Void> task) {
                                                         //    progressbar GONE

                                                         Toast.makeText(RegisterActivity.this,"Registration Successful",Toast.LENGTH_LONG).show();
                                                         Intent i = new Intent(RegisterActivity.this, AddHealthInfo.class);
                                                         startActivity(i); // invoke the RegisterActivity.
                                                         finish();
                                                     }
                                                 });


                                     }else{
                                         Toast.makeText(RegisterActivity.this,"Registration Failed",Toast.LENGTH_LONG).show();
                                     }
                                 }
                             });
                 }

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