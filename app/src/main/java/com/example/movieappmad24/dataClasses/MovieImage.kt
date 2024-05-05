package com.example.movieappmad24.dataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MovieImage(
    @PrimaryKey(autoGenerate = true) val imageId: Long = 0,
    val movieId: String,
    val url: String
)

