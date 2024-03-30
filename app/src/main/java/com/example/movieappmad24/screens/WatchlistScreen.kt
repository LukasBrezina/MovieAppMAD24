package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.getWatchListMovies
import com.example.movieappmad24.reuseableFunctions.SimpleBottomAppBar
import com.example.movieappmad24.reuseableFunctions.SimpleTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieList

@Composable
fun WatchlistScreen(navController: NavController, route: String) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(navController = navController, text = "Watchlist") },
        bottomBar = {
            SimpleBottomAppBar(navController, route) }
    ) { paddingValues -> MovieList(movieList = getWatchListMovies(),
                                    paddingValues = paddingValues,
                                    navController = navController )
    }
}