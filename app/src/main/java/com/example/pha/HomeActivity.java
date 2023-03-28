package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.URL;

public class HomeActivity extends AppCompatActivity {
    private FirebaseUser user;
    private ImageView dp_imVw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user= FirebaseAuth.getInstance().getCurrentUser();
        dp_imVw=findViewById(R.id.homeA_dp_imgVw);
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




    }
}