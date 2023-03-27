package com.example.pha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RegisterActivity extends AppCompatActivity {
    private EditText email_edTxt,password_edTxt,name_edTxt,phone_edTxt;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://personalheathassistant-8b043-default-rtdb.firebaseio.com");
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
                final String name = name_edTxt.getText().toString();
                final String phone = phone_edTxt.getText().toString();
                final String email = email_edTxt.getText().toString();
                final String pwd = password_edTxt.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           //if not registered before
                           if (snapshot.hasChild(phone)){
                               Toast.makeText(RegisterActivity.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                           }else{
                               //string data to firebase
                               databaseReference.child("users").child(phone).child("name").setValue(name);
                               databaseReference.child("users").child(phone).child("email").setValue(email);
                               databaseReference.child("users").child(phone).child("pwd").setValue(pwd);

                               Toast.makeText(RegisterActivity.this, "User register successfully", Toast.LENGTH_SHORT).show();
                               finish();
                           }
                       }
                       @Override
                        public void onCancelled(@NonNull DatabaseError error) {

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