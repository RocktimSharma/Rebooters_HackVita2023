package com.example.pha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;

import com.example.pha.Fragments.Fragment1;
import com.example.pha.Fragments.Fragment2;
import com.example.pha.Fragments.Fragment3;
import com.example.pha.adapters.ViewPagerAdapter;
import com.example.pha.model.HealthInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddHealthInfo extends AppCompatActivity {
    private ViewPager viewPager;
    private RadioGroup bp_radio, sgr_radio, vac_radio,gender_rdGp;
    private Spinner spinner_blood;
    private String bg;
    private RadioButton bp, sgr, vac,genderChecked;
    Fragment2 fragment2;
    Fragment1 fragment1;
    FirebaseAuth mFireBaseAuth;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseReference;
    HealthInfo healthInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_info);

        mFireBaseAuth=FirebaseAuth.getInstance();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = mFirebaseDatabase.getReference("UserHealthInfo");

       // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();
        fragment1=new Fragment1();
        fragment2=new Fragment2();

        viewPager = (ViewPager) findViewById(R.id.adHltInfo_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter (AddHealthInfo.this.getSupportFragmentManager());
        adapter.add(fragment1, "Fragment 1");
        adapter.add(fragment2, "Fragment 2");
        adapter.add(new Fragment3(), "Fragment 3");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        healthInfo=new HealthInfo();


    }

    public void getDataFromFragments(){
        //EditText ed=fragment2.getView().findViewById(R.id.frag2_age_edTxt);





        databaseReference
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(healthInfo).
                addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //    progressbar GONE
                        if(task.isSuccessful()){
                            Log.i("Test Ah 1", "Successful");
                            Toast.makeText(AddHealthInfo.this,"Data inserted Successful",Toast.LENGTH_LONG).show();

                        }else{
                            Log.i("Test Ah 2", "Failed");
                            Toast.makeText(AddHealthInfo.this,"Data inserted failed" + task.getException(),Toast.LENGTH_LONG).show();

                        }


                    }
                });


    }

    public void setGender(String g){
        healthInfo.setGender(g);
    }

    public void setDetails(String dob,int h_ft,int h_in,int w,String bg,String bp,String s,String v){

        healthInfo.setDob(dob);
        healthInfo.setHeight_ft(h_ft);
        healthInfo.setHeight_in(h_in);
        healthInfo.setWeight(w);
        healthInfo.setBlood(bg);
        healthInfo.setBp(bp);
        healthInfo.setSgr(s);
        healthInfo.setVac(v);
    }




    public void replaceFragments(int fragmentNo) {

        switch (fragmentNo){
            case 1:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();
                viewPager.setCurrentItem(0);
                break;
            case 2:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment2()).commit();
                viewPager.setCurrentItem(1);
                break;
            case 3:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment3()).commit();
                viewPager.setCurrentItem(2);
                break;
        }


    }
}