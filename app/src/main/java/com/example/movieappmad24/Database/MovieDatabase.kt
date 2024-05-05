package com.example.movieappmad24.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.movieappmad24.workManagers.DatabaseWorker
import com.example.movieappmad24.dataClasses.Movie
import com.example.movieappmad24.dataClasses.MovieImage

@Database(
    entities = [Movie::class, MovieImage::class],
    version = 2,
    exportSchema = false
)

abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        // this instance will never be cached somewhere ->
        // will always access the real memory locaton of instance variable
        private var Instance: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(seedDatabase(context))
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }

        private fun seedDatabase(context: Context): Callback {
            return object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val databaseWorker = DatabaseWorker(context)
                    databaseWorker.seedRequest()
                }
            }
        }
    }
}