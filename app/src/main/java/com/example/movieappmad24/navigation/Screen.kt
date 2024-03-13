package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("homeScreen")
    data object DetailScreen: Screen("detailScreen")
    data object WatchListScreen: Screen("watchlistScreen")
}