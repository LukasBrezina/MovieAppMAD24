package com.example.movieappmad24.screens

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.Injection.InjectorUtils
import com.example.movieappmad24.ViewModel.HomeScreenViewModel
import com.example.movieappmad24.reuseableFunctions.SimpleBottomAppBar
import com.example.movieappmad24.reuseableFunctions.SimpleTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieList

@Composable
fun HomeScreen(navController: NavController, route: String) {
    val homeScreenViewModel: HomeScreenViewModel = viewModel(factory = InjectorUtils.provideMoviesViewModelFactory(context = LocalContext.current))
    Scaffold(
        topBar = {
            SimpleTopAppBar(navController = navController, text = "Lukas's Movie APP") },
        bottomBar = {
            SimpleBottomAppBar(navController, route) },
    ) { paddingValues -> MovieList(movieList = homeScreenViewModel.movieList.collectAsState().value, homeScreenViewModel, paddingValues, navController) }
}
