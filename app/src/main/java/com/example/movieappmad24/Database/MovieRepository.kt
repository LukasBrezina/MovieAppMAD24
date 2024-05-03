package com.example.movieappmad24.Database

import kotlinx.coroutines.flow.Flow


class MovieRepository (private val movieDao: MovieDao) {
    suspend fun addMovie (movie: Movie) = movieDao.insert(movie)
    suspend fun updateMovie (movie: Movie) = movieDao.updateMovie(movie)
    suspend fun deleteMovie (movie: Movie) = movieDao.delete(movie)
    fun getAllMovies(): Flow<List<Movie>> = movieDao.getAllMovies()
    fun getFavouriteMovies(): Flow<List<Movie>> = movieDao.getFavouriteMovies()
    fun getMovieById(id: String): Flow<Movie?> = movieDao.getMovieById(id)
}