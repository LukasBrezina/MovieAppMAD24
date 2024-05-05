package com.example.movieappmad24.Injection

import android.content.Context
import com.example.movieappmad24.Database.MovieDatabase
import com.example.movieappmad24.Database.MovieRepository
import com.example.movieappmad24.ViewModel.MoviesViewModelFactory


// Video von Moodle "room_2024"
object InjectorUtils {

    private fun getRepository(context: Context): MovieRepository {
        return MovieRepository.getInstance(MovieDatabase.getDatabase(context.applicationContext).movieDao())
    }

    fun provideMoviesViewModelFactory(context: Context): MoviesViewModelFactory {
        val repository = getRepository(context)
        return MoviesViewModelFactory(repository)
    }
}
