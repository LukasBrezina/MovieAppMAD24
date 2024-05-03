package com.example.movieappmad24.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappmad24.Database.MovieRepository

class MoviesViewModelFactory (private val repository: MovieRepository): ViewModelProvider.Factory {
    override fun <T: ViewModel>create(modelClass: Class<T>):T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}