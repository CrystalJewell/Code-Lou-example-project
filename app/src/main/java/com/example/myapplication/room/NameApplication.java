package com.example.myapplication.room;

import android.app.Application;

import androidx.room.Room;

//This class is ONLY called before the application starts, this will ensure that there is an instance of the database for us to use and can not be created again
public class NameApplication extends Application {

    //Create a variable to hold the instance of our database to check against.
    private NameRoomDatabase database;
    public static final String DATABASE_NAME = "name_database";

    @Override
    public void onCreate() {
        super.onCreate();

        //This will build an instance of our database
        database = Room.databaseBuilder(getApplicationContext(), NameRoomDatabase.class, DATABASE_NAME)
                //ALLOWING QUERIES ON MAIN THREAD IS BAD PRACTICE but since this is a small application it shouldn't cause us any issues
                .allowMainThreadQueries()
                .build();
    }

    //This method will return the instance of the database when called
    public NameRoomDatabase getDatabase() {
        return database;
    }


}
