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

    //Variable reference to Room Database
    private NameRoomDatabase database;
    //Varaible References to items needed for the recyclerview
    private NamesListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    //Variable reference to the button at the bottom of the screen
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_names);

        //Binds the view item variables to the view using the ID
        recyclerView = findViewById(R.id.recyclerview_content);
        goBackButton = findViewById(R.id.go_back_button);

        //calls setListeners method
        setListeners();
        //Sets variable reference to the database to the current instance
        database = ((NameApplication) getApplicationContext()).getDatabase();

        //Calls the setupRecyclerView method
        setupRecyclerView();

    }

    //Sets onClickListener for clicking the goBack button
    private void setListeners() {

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    //Sets up needed items for using a recyclerView
    private void setupRecyclerView(){

        //Sets linearLayoutManager variable to a new LinearLayoutManager object using this context
        linearLayoutManager = new LinearLayoutManager(this);
        //Sets adapter variable the NamesListAdapter using the database DAO getAllNames to populate it
        adapter = new NamesListAdapter(database.nameDao().getAllNames());
        //Sets recyclerView variable to use the linearLayoutManager we set up above
        recyclerView.setLayoutManager(linearLayoutManager);
        //Sets recyclerView to use the adapter we set up above
        recyclerView.setAdapter(adapter);
        //Tells the adapter to refresh since it has been told where to get the data from
        adapter.notifyDataSetChanged();
    }



}
