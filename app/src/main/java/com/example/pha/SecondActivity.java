package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pha.Fragments.Fragment1;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class
SecondActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Check if user is already logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is already logged in, do something
            Intent i = new Intent(SecondActivity.this, HomeActivity.class);
            startActivity(i); // invoke the SecondActivity.
            finish();
        } else {
            // User is not logged in, do something else
            /*profile view test
            Intent i = new Intent(SecondActivity.this, UserProfile.class);
            startActivity(i); // invoke the SecondActivity.
            finish(); */
            Intent i = new Intent(SecondActivity.this, LoginActivity.class);
            startActivity(i); // invoke the SecondActivity.
            finish();
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();
        }

        // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();

        //if user is signed in then execute the following codes

    /*    Intent i = new Intent(SecondActivity.this, HomeActivity.class);
        startActivity(i); // invoke the SecondActivity.
        finish();*/

        //if user is not signed in the exucute the follow codes

    }
}
