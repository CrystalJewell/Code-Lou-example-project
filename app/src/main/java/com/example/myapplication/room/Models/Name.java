package com.example.myapplication.room.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "name_table")
public class Name {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    public Name(@NonNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
