package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.room.Models.Name;
import com.example.myapplication.room.NameApplication;
import com.example.myapplication.room.NameRoomDatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AddNameActivity extends AppCompatActivity {

    private NameRoomDatabase nameDatabase;

    protected TextView nameTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        nameTextview = findViewById(R.id.name_edit_text);

        nameTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        nameDatabase = ((NameApplication)getApplicationContext()).getDatabase();
    }


    protected void addName(){

       if (nameTextview.getText().toString().isEmpty()) {
            Toast.makeText(this, "Name can not be empty, try again!", Toast.LENGTH_LONG).show();
        } else {
           Name name = new Name(nameTextview.getText().toString());

           nameDatabase.nameDao().insert(name);

           Toast.makeText(this, "Name added to database!", Toast.LENGTH_LONG).show();

           addAnotherPrompt();
        }
    }

    protected void addAnotherPrompt(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Add Another Name?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nameTextview.setText("");
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }
}
