package com.example.movieappmad24.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.movieappmad24.dataClasses.Movie
import com.example.movieappmad24.dataClasses.MovieImage
import com.example.movieappmad24.dataClasses.MovieWithImages
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMovieList(movies: List<Movie>)

    @Insert
    suspend fun insertMovieImages(images: List<MovieImage>)

    @Delete
    fun delete(movie: Movie)

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovieById(id: String?): Flow<MovieWithImages?>

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Flow<List<MovieWithImages>>

    @Update
    suspend fun updateMovie(movie: Movie)

    @Query("SELECT * FROM movie WHERE isFavourite=1")
    fun getFavouriteMovies(): Flow<List<MovieWithImages>>

    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()
}