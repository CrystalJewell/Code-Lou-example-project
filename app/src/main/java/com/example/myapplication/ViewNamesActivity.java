package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.room.NameApplication;
import com.example.myapplication.room.NameRoomDatabase;

import androidx.appcompat.app.AlertDialog;
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
    private Button deleteAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_names);

        //Binds the view item variables to the view using the ID
        recyclerView = findViewById(R.id.recyclerview_content);
        goBackButton = findViewById(R.id.go_back_button);
        deleteAllButton = findViewById(R.id.delete_all_button);

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

        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNames();
            }
        });
    }

    private void deleteNames() {
        //Creates alert dialog builder
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //Sets title for alert dialog
        alert.setTitle("Delete all names?")
                //Sets what should happen if a user selects yes
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //calls database to delete all of the names
                        database.nameDao().deleteAll();
                        //Shows toast to show user that all of the names have been deleted
                        Toast.makeText(ViewNamesActivity.this, "Names deleted", Toast.LENGTH_SHORT).show();
                        //Tells the adapter to update the list which updates our view
                        adapter.updateList(database.nameDao().getAllNames());
                        //Closes out the dialog
                        dialog.dismiss();
                    }
                })
                //Sets what to do if the user selects no
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Closes out the dialog
                        dialog.dismiss();
                    }
                })
                //Shows the alert dialog
                .show();
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
