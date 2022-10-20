package com.example.firstandroid

import androidx.room.Insert
import androidx.room.Query

interface MovieDAO {
    @Query("SELECT * FROM MovieEntity")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM MovieEntity WHERE id IN (:movieIds)")
    fun loadAllByIds(movieIds: IntArray): List<MovieEntity>

    @Insert
    fun insertMovie(movie: MovieEntity)


}