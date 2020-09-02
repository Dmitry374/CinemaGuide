package com.example.cinemaguide.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cinemaguide.data.entity.Movie
import com.example.cinemaguide.db.converters.IntegerListConverter

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [IntegerListConverter::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}