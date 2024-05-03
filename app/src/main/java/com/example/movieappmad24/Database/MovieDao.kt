package com.example.movieappmad24.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert
    fun insert (movie: Movie)

    @Delete
    fun delete (movie: Movie)

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getMovieById(id: String): Flow<Movie?>

    @Query("SELECT * FROM Movie")
    fun getAllMovies(): Flow<List<Movie>>

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM Movie WHERE isFavourite=True")
    fun getFavouriteMovies(): Flow<List<Movie>>
}