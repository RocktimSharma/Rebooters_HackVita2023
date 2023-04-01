package com.example.pha.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pha.R;

public class SymptomRecyclerAdapter extends RecyclerView.Adapter {


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.symptom_rc_item, parent, false);
                RecyclerView.ViewHolder vh = new RecyclerView.ViewHolder(v);// pass the view to View Holder
                return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
                return 0;
        }
}
