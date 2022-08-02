package com.geektech.testing.youtube

import android.app.Application
import androidx.room.Room
import com.geektech.testing.youtube.data.local.AppDatabase

class App : Application() {
    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database")
            .build()
    }
}