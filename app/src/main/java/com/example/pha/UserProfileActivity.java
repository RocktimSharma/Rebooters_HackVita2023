package com.example.pha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfileActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private FirebaseAuth mFireBaseAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private TextView bloodGroup_tv, bloodPressure_tv, height_tv, weight_tv, sugar_tv, vac_tv;
    //ActivityReadDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityRead
        setContentView(R.layout.activity_user_profile);

        bloodGroup_tv = findViewById(R.id.bg);
        bloodPressure_tv = findViewById(R.id.bp);
        height_tv = findViewById(R.id.ht);
        weight_tv = findViewById(R.id.wgt);
        sugar_tv = findViewById(R.id.sgr);
        vac_tv = findViewById(R.id.vac);

        mFireBaseAuth=FirebaseAuth.getInstance();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=mFirebaseDatabase.getReference("UserHealthInfo");

        //user = FirebaseAuth.getInstance().getCurrentUser();
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        readData();
        Toast.makeText(this, "user", Toast.LENGTH_SHORT).show();

    }

    private void readData(){
        FirebaseUser user = mFireBaseAuth.getCurrentUser();

      //  Toast.makeText(this, "user " + String.valueOf(user), Toast.LENGTH_SHORT).show();

        databaseReference.child(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        DataSnapshot dataSnapshot = task.getResult();
                        // fetching data using dataSnapshot
                        String bg = String.valueOf(dataSnapshot.child("blood").getValue());
                        String bp = String.valueOf(dataSnapshot.child("bp").getValue());
                        String height = String.valueOf(dataSnapshot.child("height_ft").getValue()) + " ft " + String.valueOf(dataSnapshot.child("height_in").getValue()) + " in";
                        String weight = String.valueOf(dataSnapshot.child("weight").getValue()) + " kg";
                        String sugar = String.valueOf(dataSnapshot.child("sgr").getValue());
                        String vac = String.valueOf(dataSnapshot.child("vac").getValue());
                        Log.i("Test 11",bg);
                        // setting the value fetched from the db
                        bloodGroup_tv.setText(bg);
                        bloodPressure_tv.setText(bp);
                        height_tv.setText(height);
                        weight_tv.setText(weight);
                        sugar_tv.setText(sugar);
                        vac_tv.setText(vac);

                    }else {
                        bloodGroup_tv.setText("test");
                        bloodPressure_tv.setText("test");
                        height_tv.setText("test");
                        weight_tv.setText("test");
                        sugar_tv.setText("test");
                        vac_tv.setText("test");
                        Toast.makeText(UserProfileActivity.this, "user doesn't exist. " , Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(UserProfileActivity.this, "error ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}