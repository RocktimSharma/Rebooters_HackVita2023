package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.pha.Fragments.Fragment1;
import com.example.pha.Fragments.Fragment2;
import com.example.pha.Fragments.Fragment3;
import com.example.pha.adapters.ViewPagerAdapter;
import com.example.pha.model.HealthInfo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddHealthInfo extends AppCompatActivity {
    private ViewPager viewPager;
    private RadioGroup bp_radio, sgr_radio, vac_radio;
    private  RadioGroup gender_rdGp;
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
        replaceFragments(0);

        healthInfo=new HealthInfo();

        /*
        spinner code for blood group not working
        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLanguages.setAdapter(adapter2);
        */

    }





    public void getDataFromFragments(){




       /* databaseReference
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
                });*/


    }

    public void setGender(String g){
        healthInfo.setGender(g);
    }

    public  void setDetails(int a,int h1,int h2,int w,String bg,String bp,String s ,String v){
        Log.i("Frag 2",String.valueOf(a));
        Log.i("Frag 2",String.valueOf(h1));
        Log.i("Frag 2",String.valueOf(h2));
        Log.i("Frag 2",String.valueOf(w));
        Log.i("Frag 2",String.valueOf(bg));
        Log.i("Frag 2",String.valueOf(bp));
        Log.i("Frag 2",String.valueOf(s));
        Log.i("Frag 2",String.valueOf(v));

        healthInfo.setAge(a);
        healthInfo.setHeight_ft(h1);
        healthInfo.setHeight_in(h2);
        healthInfo.setWeight(w);
        healthInfo.setBlood(bg);
        healthInfo.setBp(bp);
        healthInfo.setSgr(s);
        healthInfo.setVac(v);
        Log.i("Test",healthInfo.getSgr());

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