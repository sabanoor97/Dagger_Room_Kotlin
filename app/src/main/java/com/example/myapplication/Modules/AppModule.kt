package com.example.myapplication.Modules

import dagger.Component
import dagger.Module
import android.app.Application
import dagger.Provides

import javax.inject.Singleton


@Module
class AppModule(var mApplication: Application) {
    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }
}