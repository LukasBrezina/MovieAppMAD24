package com.example.movieappmad24.dataClasses

import androidx.room.Embedded
import androidx.room.Relation

data class MovieWithImages(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
    val images: List<MovieImage>
)
