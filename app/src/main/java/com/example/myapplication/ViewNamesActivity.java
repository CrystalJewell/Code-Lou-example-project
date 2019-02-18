package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.room.NameApplication;
import com.example.myapplication.room.NameRoomDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewNamesActivity extends AppCompatActivity {

    private NameRoomDatabase database;
    private NamesListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_names);

        recyclerView = findViewById(R.id.recyclerview_content);
        goBackButton = findViewById(R.id.go_back_button);

        setListeners();
        database = ((NameApplication) getApplicationContext()).getDatabase();

        setupRecyclerView();

    }

    private void setListeners() {

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    private void setupRecyclerView(){

        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new NamesListAdapter(database.nameDao().getAllNames());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



}
