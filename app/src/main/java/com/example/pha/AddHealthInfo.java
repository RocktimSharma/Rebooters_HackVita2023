package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class AddHealthInfo extends AppCompatActivity {
    private ViewPager viewPager;
    Fragment2 fragment2;
    private AlertDialog.Builder spinnerLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_info);


       // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();
        fragment2=new Fragment2();
        viewPager = (ViewPager) findViewById(R.id.adHltInfo_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter (AddHealthInfo.this.getSupportFragmentManager());
        adapter.add(new Fragment1(), "Fragment 1");
        adapter.add(fragment2, "Fragment 2");
        adapter.add(new Fragment3(), "Fragment 3");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);



    }

    public void getDataFromFragments(){
        //EditText ed=fragment2.getView().findViewById(R.id.frag2_age_edTxt);
        EditText age_edTxt = fragment2.getView().findViewById(R.id.frag2_age_edTxt);
        EditText height_ft_edTxt = fragment2.getView().findViewById(R.id.frag2_height_ft_edTxt);
        EditText height_in_edTxt = fragment2.getView().findViewById(R.id.frag2_height_inc_edTxt);
        EditText weight_edTxt = fragment2.getView().findViewById(R.id.frag2_weight_edTxt);
        EditText bp_high_edTxt = fragment2.getView().findViewById(R.id.frag2_bp_heigh_radio);
        EditText bp_low_edTxt = fragment2.getView().findViewById(R.id.frag2_bp_low_radio);
        EditText sgr_yes_edTxt = fragment2.getView().findViewById(R.id.frag2_sgr_yes_radio);
        EditText sgr_no_edTxt = fragment2.getView().findViewById(R.id.frag2_sgr_no_radio);
        EditText vac_yes_edTxt = fragment2.getView().findViewById(R.id.frag2_vac_yes_radio);
        EditText vac_no_edTxt = fragment2.getView().findViewById(R.id.frag2_vac_no_radio);
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
        Spinner spinner_Language = fragment2.getView().findViewById(R.id.spinner_languages);

        Toast.makeText(AddHealthInfo.this,age,Toast.LENGTH_LONG).show();
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