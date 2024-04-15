package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.reuseableFunctions.SimpleBottomAppBar
import com.example.movieappmad24.reuseableFunctions.SimpleTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieList

@Composable
fun WatchlistScreen(navController: NavController, moviesViewModel: MoviesViewModel, route: String) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(navController = navController, text = "Watchlist") },
        bottomBar = {
            SimpleBottomAppBar(navController, moviesViewModel, route) }
    ) { paddingValues -> MovieList(movieList = moviesViewModel.favouriteMovieList, moviesViewModel,
                                    paddingValues = paddingValues,
                                    navController = navController )
    }
}