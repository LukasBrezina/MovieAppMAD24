package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.getWatchListMovies
import com.example.movieappmad24.reuseableFunctions.CreateBottomAppBar
import com.example.movieappmad24.reuseableFunctions.CreateTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieList

@Composable
fun WatchlistScreen(navController: NavController) {
    Scaffold(
        topBar = { CreateTopAppBar(navController = navController, text = "Watchlist") },
        bottomBar = { CreateBottomAppBar(navController) }
    ) { paddingValues ->  MovieList(movieList = getWatchListMovies(),
                                    paddingValues = paddingValues,
                                    navController = navController )
    }
}