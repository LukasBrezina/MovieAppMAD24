package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.Database.MovieDatabase
import com.example.movieappmad24.Database.MovieRepository
import com.example.movieappmad24.ViewModel.MoviesViewModel
import com.example.movieappmad24.ViewModel.MoviesViewModelFactory
import com.example.movieappmad24.reuseableFunctions.SimpleBottomAppBar
import com.example.movieappmad24.reuseableFunctions.SimpleTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieList

@Composable
fun HomeScreen(navController: NavController, moviesViewModel: MoviesViewModel, route: String) {

    val db = MovieDatabase.getDatabase(LocalContext.current)
    val repository = MovieRepository(movieDao = db.movieDao())
    val factory = MoviesViewModelFactory(repository = repository)
    val viewModel: MoviesViewModel = viewModel(factory = factory)


    Scaffold(
        topBar = {
            SimpleTopAppBar(navController = navController, text = "Lukas's Movie APP") },
        bottomBar = {
            SimpleBottomAppBar(navController, moviesViewModel, route) },
    ) { paddingValues -> MovieList(movieList = moviesViewModel.movieList, moviesViewModel, paddingValues, navController) }
}
