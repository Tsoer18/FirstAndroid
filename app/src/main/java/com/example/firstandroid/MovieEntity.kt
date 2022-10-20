package com.example.firstandroid

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey val id: Int,

    val title: String?,
    val rating: Int,
    val poster: String? = null
)