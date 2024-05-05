package com.example.movieappmad24.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappmad24.Database.MovieRepository

class MoviesViewModelFactory (private val repository: MovieRepository): ViewModelProvider.Factory {
    override fun <T: ViewModel> create (modelClass:Class<T>):T = when (modelClass){
        HomeScreenViewModel::class.java -> HomeScreenViewModel(repository)
        WatchListScreenViewModel::class.java -> WatchListScreenViewModel(repository)
        DetailScreenViewModel::class.java -> DetailScreenViewModel(repository)
        else ->
            throw IllegalArgumentException("Unknown ViewModel class")
    } as T
}