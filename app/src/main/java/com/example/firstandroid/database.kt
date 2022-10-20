package com.example.firstandroid
import androidx.room.Database
import androidx.room.RoomDatabase;

@Database(version = 1, entities = [MovieEntity::class])
abstract class database : RoomDatabase() {
    abstract fun movieDAO(): MovieDAO
}