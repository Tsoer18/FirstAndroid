package com.example.firstandroid

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDAO {
    @Query("SELECT * FROM movie_table ORDER BY id ASC")
    suspend fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movie_table WHERE id IN (:movieIds)")
    suspend fun loadAllByIds(movieIds: IntArray): List<MovieEntity>

    @Insert
    suspend fun insertMovie(movie: MovieEntity)


}