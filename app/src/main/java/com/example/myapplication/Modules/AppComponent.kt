package com.example.myapplication.Modules

import android.app.Application
import com.example.myapplication.*
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RoomModule::class, AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(addActivity: AddActivity)
}