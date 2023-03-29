package com.example.pha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

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
    private RadioGroup bp_radio, sgr_radio, vac_radio;
    private Spinner spinner_blood;
    private String bg;
    private RadioButton bp, sgr, vac;
    Fragment2 fragment2;
    Fragment1 fragment1;
    FirebaseAuth mFireBaseAuth;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_info);

        mFireBaseAuth=FirebaseAuth.getInstance();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = mFirebaseDatabase.getReference("UserHealthInfo");

       // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();
        fragment2=new Fragment2();
        fragment1=new Fragment1();
        viewPager = (ViewPager) findViewById(R.id.adHltInfo_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter (AddHealthInfo.this.getSupportFragmentManager());
        adapter.add(new Fragment1(), "Fragment 1");
        adapter.add(fragment2, "Fragment 2");
        adapter.add(new Fragment3(), "Fragment 3");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        /*
        spinner code for blood group not working
        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLanguages.setAdapter(adapter2);
        */

    }

    public void getDataFromFragments(){
        //EditText ed=fragment2.getView().findViewById(R.id.frag2_age_edTxt);
        RadioGroup gender_rdGp=fragment1.getView().findViewById(R.id.frag1_gender_radio);

        EditText age_edTxt = fragment2.getView().findViewById(R.id.frag2_age_edTxt);
        EditText height_ft_edTxt = fragment2.getView().findViewById(R.id.frag2_height_ft_edTxt);
        EditText height_in_edTxt = fragment2.getView().findViewById(R.id.frag2_height_inc_edTxt);
        EditText weight_edTxt = fragment2.getView().findViewById(R.id.frag2_weight_edTxt);
        bp_radio = fragment2.getView().findViewById(R.id.blood_p_grp);
        sgr_radio = fragment2.getView().findViewById(R.id.sugar_grp);
        vac_radio = fragment2.getView().findViewById(R.id.vac_grp);

        //bp_radio.getCheckedRadioButtonId();
        bp = fragment2.getView().findViewById(bp_radio.getCheckedRadioButtonId());
        sgr = fragment2.getView().findViewById(sgr_radio.getCheckedRadioButtonId());
        vac = fragment2.getView().findViewById(vac_radio.getCheckedRadioButtonId());

        RadioButton genderChecked=fragment1.getView().findViewById(gender_rdGp.getCheckedRadioButtonId());

        String gender=genderChecked.getText().toString();

        String[] items = {"A+","A-","B+","B-","AB","O+"};

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
        /*EditText bp_high_edTxt = fragment2.getView().findViewById(R.id.frag2_bp_heigh_radio);
        EditText bp_low_edTxt = fragment2.getView().findViewById(R.id.frag2_bp_low_radio);
        EditText sgr_yes_edTxt = fragment2.getView().findViewById(R.id.frag2_sgr_yes_radio);
        EditText sgr_no_edTxt = fragment2.getView().findViewById(R.id.frag2_sgr_no_radio);
        EditText vac_yes_edTxt = fragment2.getView().findViewById(R.id.frag2_vac_yes_radio);
        EditText vac_no_edTxt = fragment2.getView().findViewById(R.id.frag2_vac_no_radio);
         */
        String age=age_edTxt.getText().toString();
        String height_ft=height_ft_edTxt.getText().toString();
        String height_in=height_in_edTxt.getText().toString();
        String weight=weight_edTxt.getText().toString();
        /*
        String bp_high=bp_high_edTxt.getText().toString();
        String bp_low=bp_low_edTxt.getText().toString();
        String sgr_yes=sgr_yes_edTxt.getText().toString();
        String sgr_no=sgr_no_edTxt.getText().toString();
        String vac_yes=vac_yes_edTxt.getText().toString();
        String vac_no=vac_no_edTxt.getText().toString();
         */
        Spinner spinner_Language = fragment2.getView().findViewById(R.id.spinner_blood);
        //vac_grp sugar_grp blood_p_grp
        HealthInfo healthInfo=new HealthInfo(gender,Integer.parseInt(age), Integer.parseInt(height_in), Integer.parseInt(height_ft), Integer.parseInt(weight), bp.getText().toString(), sgr.getText().toString(), vac.getText().toString(), bg);
        Toast.makeText(AddHealthInfo.this,age,Toast.LENGTH_LONG).show();

        databaseReference
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(healthInfo).
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //    progressbar GONE

                        Toast.makeText(AddHealthInfo.this,"Data inserted Successful",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(AddHealthInfo.this, TestDiseases.class);
                        startActivity(i); // invoke the RegisterActivity.
                        finish();


                    }
                });


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