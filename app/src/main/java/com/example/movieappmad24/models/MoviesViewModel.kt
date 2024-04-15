package com.example.movieappmad24.models

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MoviesViewModel: ViewModel() {

    private val _movieList = getMovies().toMutableStateList()
    val movieList: List<Movie> get() = _movieList

    private val _favouriteMovieList = mutableStateListOf<Movie>()
    val favouriteMovieList: List<Movie> get() = _favouriteMovieList

    fun toggleFavourite(movie: Movie) {
        movie.isFavourite = !movie.isFavourite
        when ( movie.isFavourite ) {
            true -> _favouriteMovieList.add(movie)
            false -> _favouriteMovieList.remove(movie)
        }
    }
}