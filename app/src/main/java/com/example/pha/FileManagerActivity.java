package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FileManagerActivity extends AppCompatActivity {

    private RecyclerView files_recycler_Vw;
   // private List<Item> itemList;
    private SearchView search_file_Vw;
    //private FloatingActionButton addPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manager);

        FloatingActionButton addPhoto = findViewById(R.id.fileA_cm_fab);

        search_file_Vw=findViewById(R.id.activity_file_search_view);
        search_file_Vw.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               // fileList(newText);
                return true;
            }
        });

        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FileManagerActivity.this, AddRecord.class);
                startActivity(i); // invoke the SecondActivity.
                finish();
            }
        }
        );
    }
}