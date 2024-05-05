package com.example.movieappmad24.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.Database.MovieRepository
import com.example.movieappmad24.dataClasses.MovieWithImages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailScreenViewModel(private val repository: MovieRepository) : ViewModel(),
    MoviesViewModel {

    private val _movie = MutableStateFlow<MovieWithImages?>(null)

    fun getMovieById(movieId: String?): StateFlow<MovieWithImages?> {
        viewModelScope.launch {
            repository.getMovieById(movieId).collect { movie ->
                _movie.value = movie
            }
        }
        return _movie.asStateFlow()
    }

    override fun changeFavourite(movieWithImages: MovieWithImages) {
        movieWithImages.movie.isFavourite = !movieWithImages.movie.isFavourite
        viewModelScope.launch {
            repository.updateMovie(movieWithImages.movie)
        }
    }
}