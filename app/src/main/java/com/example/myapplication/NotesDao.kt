package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {

    @Query("Select * From Notes")
    fun getData(): List<Notes>

    @Insert
    fun insert(note: Notes)
}