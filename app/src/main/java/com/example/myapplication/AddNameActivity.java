package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.room.Models.Name;
import com.example.myapplication.room.NameApplication;
import com.example.myapplication.room.NameRoomDatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AddNameActivity extends AppCompatActivity {

    //Variable reference for Room database class
    private NameRoomDatabase nameDatabase;

    //Variables for view items
    protected EditText nameEditText;
    protected Button addNameButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        //Setting the view for the items on screen
        nameEditText = findViewById(R.id.name_edit_text);
        addNameButton = findViewById(R.id.add_name_button);

        //Setting on click listener for add name to call the add name method
        addNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Telling this activity that when it starts is needs to get the instance of the database for us to use
        nameDatabase = ((NameApplication)getApplicationContext()).getDatabase();
    }


    //Adds the name in the edit text to the database
    protected void addName(){
        //Checks to see of the edit text is has text it it
       if (nameEditText.getText().toString().isEmpty()) {
           //If the edit text is empty we will toast the user to put something in
            Toast.makeText(this, "Name can not be empty, try again!", Toast.LENGTH_LONG).show();
        } else {
           //if the edit text is not empty we will call the Name constructor to make a name object to pass into the database
           Name name = new Name(nameEditText.getText().toString());

           //Call the database DAO to insert the name object we just created
           nameDatabase.nameDao().insert(name);

           //Tells the user that the name was added to the database
           Toast.makeText(this, "Name added to database!", Toast.LENGTH_LONG).show();

           //Starts the addAnotherPrompt method
           addAnotherPrompt();
        }
    }

    //Prompts user to see if they would like to add another name
    protected void addAnotherPrompt(){
        //Creates alert dialog builder
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //Sets title for alert dialog
        alert.setTitle("Add Another Name?")
                //Sets what should happen if a user selects yes
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Clears edit text
                        nameEditText.setText("");
                        //closes dialog
                        dialog.dismiss();
                    }
                })
                //Sets what to do if the user selects no
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Closes out the activity, takes us back to the activity we were at before this one
                        finish();
                    }
                })
                //Shows the alert dialog
                .show();
    }
}
