package com.example.movieappmad24.models

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MoviesViewModel: ViewModel() {
    private val _movieList = getMovies().toMutableStateList()

    val movieList: List<Movie> get() = _movieList

    val favouriteList: List<Movie> = movieList.filter { movie -> movie.isFavourite }

    fun toggleFavourite(movieId: String) = _movieList.find {it.id == movieId}?.let { movie ->
        movie.isFavourite = !movie.isFavourite
    }

}