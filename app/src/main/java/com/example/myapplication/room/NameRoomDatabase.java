package com.example.myapplication.room;

import com.example.myapplication.room.Models.Name;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//Annotate this is the database class, give it entities of the models that are to be used and a version number
@Database(entities = {Name.class}, version = 1, exportSchema = false)
public abstract class NameRoomDatabase extends RoomDatabase {

    //Define where our DAO for the database is
    public abstract NameDao nameDao();

}
