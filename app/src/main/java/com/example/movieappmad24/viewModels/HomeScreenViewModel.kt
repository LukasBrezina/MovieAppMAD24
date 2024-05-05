package com.example.movieappmad24.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.Database.MovieRepository
import com.example.movieappmad24.dataClasses.MovieWithImages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val repository: MovieRepository) : ViewModel(), MoviesViewModel {

    private val _movieList = MutableStateFlow(listOf<MovieWithImages>())

    override fun changeFavourite(movieWithImages: MovieWithImages) {
        movieWithImages.movie.isFavourite = !movieWithImages.movie.isFavourite
        viewModelScope.launch {
            repository.updateMovie(movieWithImages.movie)
        }
    }

    init {
        viewModelScope.launch {
            repository.getAllMovies().distinctUntilChanged().collect { movies ->
                if (movies.isEmpty()) {
                    repository.deleteAllMovies()
                } else {
                    _movieList.value = movies
                }
            }
        }
    }

    val movieList: StateFlow<List<MovieWithImages>> = _movieList.asStateFlow()
}