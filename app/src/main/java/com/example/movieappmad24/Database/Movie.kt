package com.example.movieappmad24.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "director") val director: String,
    @ColumnInfo(name = "actors") val actors: String,
    @ColumnInfo(name = "plot") val plot: String,
    // @ColumnInfo(name = "images") val images: List<String>,
    @ColumnInfo(name = "trailer") val trailer: String,
    @ColumnInfo(name = "rating") val rating: String,
    @ColumnInfo(name = "isFavourite") val isFavourite: Boolean
)

