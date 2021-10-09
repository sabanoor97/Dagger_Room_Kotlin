package com.example.myapplication

import android.app.Application
import com.example.myapplication.Modules.AppComponent
import com.example.myapplication.Modules.AppModule
import com.example.myapplication.Modules.DaggerAppComponent
import com.example.myapplication.Modules.RoomModule


class MyApp : Application() {
    var appComponent: AppComponent? = null
//        private set

    override fun onCreate() {
        super.onCreate()

        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule())
                .build()

    }
}