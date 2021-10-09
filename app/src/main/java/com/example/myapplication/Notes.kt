package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Notes {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo
    var title: String = ""
    @ColumnInfo
    var description: String = ""
}