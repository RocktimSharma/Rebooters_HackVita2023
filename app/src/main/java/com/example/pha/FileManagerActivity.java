package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;

import java.util.List;

public class FileManagerActivity extends AppCompatActivity {

    private RecyclerView files_recycler_Vw;
   // private List<Item> itemList;
    private SearchView search_file_Vw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manager);

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
    }
}