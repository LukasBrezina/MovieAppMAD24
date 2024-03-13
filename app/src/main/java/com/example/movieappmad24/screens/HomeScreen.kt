package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.getMovies
import com.example.movieappmad24.reuseableFunctions.CreateBottomAppBar
import com.example.movieappmad24.reuseableFunctions.CreateTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieList

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { CreateTopAppBar(navController = navController, text = "Lukas's Movie APP") },
        bottomBar = { CreateBottomAppBar(navController) },
    ) { paddingValues -> MovieList(movieList = getMovies(),
                                    paddingValues,
                                    navController) }
}
