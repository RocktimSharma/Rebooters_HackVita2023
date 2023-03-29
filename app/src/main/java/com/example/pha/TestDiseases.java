package com.example.pha;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class TestDiseases extends AppCompatActivity {

    /*
    ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        bloodGroup_spinner.setAdapter(arrayAdapter);
     */

    private EditText search_bar;
    private ListView smts_list, listView;
    private SearchView searchView;
    private Button next_btn;
    ArrayAdapter<String> arrayAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_diseases);

        String[] items = {"a","b"};
        next_btn = findViewById(R.id.next_in_symts);
        listView = findViewById(R.id.smts_listView);
        searchView = findViewById(R.id.search_bar_smt);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);

        //filter the searched text
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                TestDiseases.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                TestDiseases.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });


        /*ListAdapter listAdapter = new androidx.recyclerview.widget.ListAdapter<>()
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        smts_list.setAdapter(arrayAdapter);


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.smts_list,items);
        ListView list = new ListView(this);
        list.setAdapter(adapter);
        */


    }
}