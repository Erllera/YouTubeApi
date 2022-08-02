package com.geektech.testing.youtube.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geektech.testing.youtube.data.converters.Converter
import com.geektech.testing.youtube.data.local.room.Dao
import com.geektech.testing.youtube.data.model.Playlist

@Database(entities = [Playlist::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): Dao
}