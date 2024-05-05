package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.Injection.InjectorUtils
import com.example.movieappmad24.ViewModel.WatchListScreenViewModel
import com.example.movieappmad24.reuseableFunctions.SimpleBottomAppBar
import com.example.movieappmad24.reuseableFunctions.SimpleTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieList

@Composable
fun WatchlistScreen(navController: NavController, route: String) {
    val watchListScreenViewModel: WatchListScreenViewModel = viewModel(factory = InjectorUtils.provideMoviesViewModelFactory(LocalContext.current))
    Scaffold(
        topBar = {
            SimpleTopAppBar(navController = navController, text = "Watchlist") },
        bottomBar = {
            SimpleBottomAppBar(navController, route) }
    ) { paddingValues ->
        MovieList(
            movieList = watchListScreenViewModel.favouriteMovieList.collectAsState().value,
            watchListScreenViewModel,
            paddingValues = paddingValues,
            navController = navController )
    }
}