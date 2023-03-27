package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.pha.Fragments.Fragment1;

public class AddHealthInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_info);


        getSupportFragmentManager().beginTransaction().replace(R.id.add_health_info_fmLy, new Fragment1()).commit();

    }
}