package com.example.movieappmad24.dataClasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.movieappmad24.dataClasses.Movie
import com.example.movieappmad24.dataClasses.MovieImage

data class MovieWithImages(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
    val images: List<MovieImage>
)
