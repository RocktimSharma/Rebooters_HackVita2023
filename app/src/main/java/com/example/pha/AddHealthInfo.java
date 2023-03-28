package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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
        EditText ed=fragment2.getView().findViewById(R.id.frag2_age_edTxt);
        String age=ed.getText().toString();
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