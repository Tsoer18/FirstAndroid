package com.example.firstandroid
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase;

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDB : RoomDatabase() {

    abstract fun movieDAO(): MovieDAO

    companion object{
        @Volatile
        private var INSTANCE: MovieDB? = null

        fun getDatabase(context: Context): MovieDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
              val instance = Room.databaseBuilder(context.applicationContext,
                  MovieDB::class.java,"movie_db").build()

              INSTANCE = instance
              return instance
            }
        }
    }
}