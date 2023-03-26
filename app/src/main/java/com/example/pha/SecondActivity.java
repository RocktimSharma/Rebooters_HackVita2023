package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pha.Fragments.Fragment1;
import com.example.pha.Fragments.Fragment3;

public class
SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment3()).commit();

        //if user is signed in then execute the following codes

    /*    Intent i = new Intent(SecondActivity.this, HomeActivity.class);
        startActivity(i); // invoke the SecondActivity.
        finish();*/

        //if user is not signed in the exucute the follow codes




    }
}