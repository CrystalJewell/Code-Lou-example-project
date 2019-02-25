package com.example.myapplication.room.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Tells Room this class sholud be a entity/table in the database
@Entity(tableName = "name_table")
public class Name {

    //Sets this field as the primary key for Room
    @PrimaryKey
    //Tells Android/Java this vairable can never be null
    @NonNull
    //Gives this variable a column in the Room database with the specified name
    @ColumnInfo(name = "name")
    private String name;

    //Constructor for the Name object
    public Name(@NonNull String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }
}
