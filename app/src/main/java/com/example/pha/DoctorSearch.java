package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DoctorSearch extends AppCompatActivity {

    private FirebaseUser user;
    private FirebaseAuth auth;

    private TextView dr_name, search_bar;
    private SearchView search_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_search);

        dr_name=findViewById(R.id.dr_searchA_name_txt);
      //  search_bar=findViewById(R.id.dr_search_bar_edtTxt);
      //  search_list=findViewById(R.id.dr_search_scroll_view);

        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();

        dr_name.setText(user.getDisplayName());
    }
}