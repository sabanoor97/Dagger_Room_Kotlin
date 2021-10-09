package com.example.myapplication.Modules

import android.app.Application
import androidx.room.Room
import com.example.myapplication.NotesDao
import com.example.myapplication.NotesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(application: Application): NotesDatabase {
        return Room.databaseBuilder(
            application.applicationContext, NotesDatabase::class.java,
            "note_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesRoomDao(notesDatabase: NotesDatabase): NotesDao {
        return notesDatabase.notesDao()
    }
}