package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Button addNameButton;
    private Button showNamesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNameButton = findViewById(R.id.add_name_button);
        showNamesButton = findViewById(R.id.view_names_button);

        setListeners();

    }

    private void setListeners() {

        addNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });

        showNamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNames();
            }
        });

    }


    protected void addName(){
        Intent addName = new Intent(this, AddNameActivity.class);
        startActivity(addName);
    }

    protected void showNames(){
        Intent showNames = new Intent(this, ViewNamesActivity.class);
        startActivity(showNames);
    }

}
