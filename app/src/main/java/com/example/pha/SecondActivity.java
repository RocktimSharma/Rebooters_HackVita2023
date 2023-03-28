package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pha.Fragments.Fragment1;
import com.example.pha.Fragments.Fragment3;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class
SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //get the current user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            //User is Logged in
            // Intent is used to switch from one activity to another.
            Intent i = new Intent(SecondActivity.this, LoginActivity.class);
            startActivity(i); // invoke the SecondActivity.
            finish(); // the current activity will get finished.
        }else{
            //No User is Logged in
          //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment3()).commit();
            Intent i = new Intent(SecondActivity.this, HomeActivity.class);
            startActivity(i); // invoke the SecondActivity.
            finish();
        }









        //if user is signed in then execute the following codes

    /*    Intent i = new Intent(SecondActivity.this, HomeActivity.class);
        startActivity(i); // invoke the SecondActivity.
        finish();*/

        //if user is not signed in the exucute the follow codes




    }
}