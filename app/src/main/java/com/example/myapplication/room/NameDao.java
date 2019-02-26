package com.example.myapplication.room;

import com.example.myapplication.room.Models.Name;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

//Give DAO annotation, Data access object, This is where we specify SQL queries we will need to use
@Dao
public interface NameDao {


    //These will be the methods that we will use to modify and view the database

    //@Insert annotation is used for methods that will ADD things to our database
    @Insert
    void insert(Name name);

    //@Query is how we ask the database to give us some information that matches our query params
    @Query("SELECT * from name_table")
    List<Name> getAllNames();


    //This @Query used to delete everything in the table we created
    @Query("DELETE FROM name_table")
    void deleteAll();

    //This will update the specific name object
    @Update
    void updateName(Name name);



}
