package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    //Variable References to view items
    private Button addNameButton;
    private Button showNamesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting variables to view Id's
        addNameButton = findViewById(R.id.add_name_button);
        showNamesButton = findViewById(R.id.view_names_button);

        //Goes to setListeners method
        setListeners();

    }

    //Sets up the onClickListeners for the buttons
    private void setListeners() {
        //Sets addNameButton to go to the addName method
        addNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });

        //Sets the showNamesButton to go to the showNames method
        showNamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNames();
            }
        });

    }

    //Creates and starts intent to go to the AddNameActivity
    protected void addName(){
        Intent addName = new Intent(this, AddNameActivity.class);
        startActivity(addName);
    }

    //Creates and starts intent to go to the ViewNamesActivity
    protected void showNames(){
        Intent showNames = new Intent(this, ViewNamesActivity.class);
        startActivity(showNames);
    }

}
