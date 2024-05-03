package com.example.movieappmad24.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MovieImage(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "movieId") val movieId: String,
    @ColumnInfo(name = "url") val url: String
)

