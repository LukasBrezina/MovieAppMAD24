package com.example.movieappmad24.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.Database.MovieRepository
import com.example.movieappmad24.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MoviesViewModel (private val repository: MovieRepository): ViewModel() {

    // private val _movieList = getMovies().toMutableStateList()
    private val _movieList =  MutableStateFlow(listOf<Movie>())
    val movieList: StateFlow<List<Movie>> = _movieList.asStateFlow()


    init {
        viewModelScope.launch {
            repository.getAllMovies().distinctUntilChanged()
                .collect {_movieList.value
                }
        }
    }

    /* das stimmt schon, aber nimmt falsches Movie
    fun addMovie (movie: Movie) {
        viewModelScope.launch {
            repository.addMovie(movie)
        }
    }
    */
    /*
    private val _favouriteMovieList = mutableStateListOf<Movie>()
    val favouriteMovieList: List<Movie> get() = _favouriteMovieList

    fun toggleFavourite(movie: Movie) {
        movie.isFavourite = !movie.isFavourite
        when ( movie.isFavourite ) {
            true -> _favouriteMovieList.add(movie)
            false -> _favouriteMovieList.remove(movie)
        }
    }
    */
}