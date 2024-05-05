package com.example.movieappmad24.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.Database.MovieRepository
import com.example.movieappmad24.dataClasses.MovieWithImages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class WatchListScreenViewModel (private val repository: MovieRepository): ViewModel(), MoviesViewModel {

    private val _favouriteMovieList = MutableStateFlow(listOf<MovieWithImages>())
    val favouriteMovieList : StateFlow<List<MovieWithImages>> = _favouriteMovieList.asStateFlow()

    override fun changeFavourite(movieWithImages: MovieWithImages) {
        movieWithImages.movie.isFavourite = !movieWithImages.movie.isFavourite
        viewModelScope.launch {
            repository.updateMovie(movieWithImages.movie)
        }
    }

    init {
        viewModelScope.launch {
            repository.getFavouriteMovies().distinctUntilChanged().collect {
                movies -> _favouriteMovieList.value = movies
            }
        }
    }
}