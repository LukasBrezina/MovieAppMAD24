package com.example.movieappmad24.Database

import com.example.movieappmad24.dataClasses.Movie
import com.example.movieappmad24.dataClasses.MovieImage
import com.example.movieappmad24.dataClasses.MovieWithImages
import kotlinx.coroutines.flow.Flow


class MovieRepository (private val movieDao: MovieDao) {
    suspend fun addMovie (movie: Movie) = movieDao.insert(movie)
    suspend fun updateMovie (movie: Movie) = movieDao.updateMovie(movie)
    suspend fun deleteMovie (movie: Movie) = movieDao.delete(movie)
    fun getAllMovies(): Flow<List<MovieWithImages>> = movieDao.getAllMovies()
    fun getFavouriteMovies(): Flow<List<MovieWithImages>> = movieDao.getFavouriteMovies()
    fun getMovieById(id: String?): Flow<MovieWithImages?> = movieDao.getMovieById(id)
    suspend fun insertMovieList(movies: List<Movie>) = movieDao.insertMovieList(movies)
    suspend fun insertMovieImages(movieImages: List<MovieImage>) = movieDao.insertMovieImages(movieImages)
    suspend fun deleteAllMovies() = movieDao.deleteAllMovies()

    // Video von Moodle "room_2024"
    companion object {
        @Volatile
        private var Instance: MovieRepository? = null
        fun getInstance(movieDao: MovieDao) = Instance?:synchronized(this) {
            Instance?:MovieRepository(movieDao).also { Instance = it }
        }
    }
}