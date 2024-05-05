package com.example.movieappmad24.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector


// tutorial: youtube.com/watch?v=c8XP_Ee7iqY

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val count: Int? = null,
    val route: String
)

fun getNavigationItems(): List<BottomNavigationItem> {
    return listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            //count = moviesViewModel.movieList.size,
            route = Screen.HomeScreen.route

        ),
        BottomNavigationItem(
            title = "Watchlist",
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star,
            //count = moviesViewModel.favouriteMovieList.size,
            route = Screen.WatchListScreen.route
        ),
    )
}
