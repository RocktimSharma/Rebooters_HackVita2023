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


        Log.i("Test",healthInfo.getGender());
        Log.i("Test",healthInfo.getSgr());



   /*     EditText age_edTxt = fragment2.getView().findViewById(R.id.frag2_age_edTxt);
        EditText height_ft_edTxt = fragment2.getView().findViewById(R.id.frag2_height_ft_edTxt);
        EditText height_in_edTxt = fragment2.getView().findViewById(R.id.frag2_height_inc_edTxt);
        EditText weight_edTxt = fragment2.getView().findViewById(R.id.frag2_weight_edTxt);
        bp_radio = fragment2.getView().findViewById(R.id.blood_p_grp);
        sgr_radio = fragment2.getView().findViewById(R.id.sugar_grp);
        vac_radio = fragment2.getView().findViewById(R.id.vac_grp);
        View v=fragment1.getView();
        Log.i("Test",v.toString());
        gender_rdGp=fragment1.getView().findViewById(R.id.frag1_gender_rdGp);
        //bp_radio.getCheckedRadioButtonId();
        bp = fragment2.getView().findViewById(bp_radio.getCheckedRadioButtonId());
        sgr = fragment2.getView().findViewById(sgr_radio.getCheckedRadioButtonId());
        vac = fragment2.getView().findViewById(vac_radio.getCheckedRadioButtonId());

        genderChecked=fragment1.getView().findViewById(gender_rdGp.getCheckedRadioButtonId());

        String gender=genderChecked.getText().toString();

*//*

        spinner_blood = fragment2.getView().findViewById(R.id.spinner_blood);
        spinner_blood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bg = items[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String age=age_edTxt.getText().toString();
        String height_ft=height_ft_edTxt.getText().toString();
        String height_in=height_in_edTxt.getText().toString();
        String weight=weight_edTxt.getText().toString();

        String bp_high=bp_high_edTxt.getText().toString();
        String bp_low=bp_low_edTxt.getText().toString();
        String sgr_yes=sgr_yes_edTxt.getText().toString();
        String sgr_no=sgr_no_edTxt.getText().toString();
        String vac_yes=vac_yes_edTxt.getText().toString();
        String vac_no=vac_no_edTxt.getText().toString();
         */
   //     Spinner spinner_Language = fragment2.getView().findViewById(R.id.spinner_blood);
        //vac_grp sugar_grp blood_p_grp
     //   HealthInfo healthInfo=new HealthInfo(gender,Integer.parseInt(age), Integer.parseInt(height_in), Integer.parseInt(height_ft), Integer.parseInt(weight), bp.getText().toString(), sgr.getText().toString(), vac.getText().toString(), bg);

      //  Log.i("Test 2", String.valueOf(healthInfo.getGender()));




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
        healthInfo.setAge(a);
        healthInfo.setHeight_ft(h1);
        healthInfo.setHeight_in(h2);
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