package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.URL;

public class HomeActivity extends AppCompatActivity {
    private FirebaseUser user;
    private FirebaseAuth auth;
    private ImageView dp_imVw;
    private TextView greet_txtVw,name_txtVw;
    private LinearLayout test_ll, doc_ll, record_ll,medication_ll;

    Button lgOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auth=FirebaseAuth.getInstance();

        greet_txtVw=findViewById(R.id.homeA_greet_txtVw);
        name_txtVw=findViewById(R.id.homeA_profile_name_txtVw);
        test_ll=findViewById(R.id.homeA_test_imgVw);
        doc_ll=findViewById(R.id.homeA_doc_imgVw);
        record_ll=findViewById(R.id.homeA_record_imgVw);
        medication_ll=findViewById(R.id.homeA_medication_imgVw);
        user= FirebaseAuth.getInstance().getCurrentUser();
        dp_imVw=findViewById(R.id.homeA_dp_imgVw);
        lgOut=findViewById(R.id.homeA_signout_btn);
        lgOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            }
        });

       dp_imVw.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(HomeActivity.this,UserProfileActivity.class));
           }
       });


        name_txtVw.setText(user.getDisplayName());

        Log.i("Test", String.valueOf(user.getPhotoUrl()));
        Uri dpUrl=user.getPhotoUrl();

        try
        {
            dp_imVw.setImageURI(dpUrl);
            dp_imVw.invalidate();
            Log.i("Test", "Done");
        }
        catch (Exception e)
        {
            //handle exception
            Log.i("Test", String.valueOf(e));
        }

        test_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,TestActivity.class));
            }
        });

        doc_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    startActivity(new Intent(HomeActivity.this,TestDiseases.class));
            }
        });

        record_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,FileManagerActivity.class));
            }
        });

        medication_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });









    }
}