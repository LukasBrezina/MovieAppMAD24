package com.example.movieappmad24.workManagers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.movieappmad24.Database.MovieDatabase.Companion.getDatabase
import com.example.movieappmad24.dataClasses.MovieImage
import com.example.movieappmad24.Database.MovieRepository
import com.example.movieappmad24.dataClasses.getMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

// https://developer.android.com/develop/background-work/background-tasks/persistent/getting-started?hl=de
class Worker(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    private val movieDao = getDatabase(context).movieDao()
    private val repository = MovieRepository(movieDao)

    override suspend fun doWork(): Result {
        return coroutineScope {
            return@coroutineScope withContext(Dispatchers.Main) {
                return@withContext try {
                    repository.insertMovieList(getMovies())
                    val images = mutableListOf<MovieImage>()
                    for (movie in getMovies()) {
                        for (image in movie.images) {
                            images.add(MovieImage(movieId = movie.id, url = image))
                        }
                    }
                    repository.insertMovieImages(images)
                    Result.success()
                } catch (throwable: Throwable) {
                    Result.failure()
                }
            }

        }
    }
}