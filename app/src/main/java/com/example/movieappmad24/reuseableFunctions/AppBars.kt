package com.example.movieappmad24.reuseableFunctions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.dataClasses.Movie
import com.example.movieappmad24.navigation.getNavigationItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar(movie: Movie? = null, navController: NavController, text: String? = null) {
    if (movie != null) {
        TopAppBar(
            title = { Text(text = movie.title) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "ArrowBack"
                    )
                }
            }
        )
    } else {
        TopAppBar(title = { Text(text = text!!) })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleBottomAppBar(navController: NavController, route: String) {
    NavigationBar {
        getNavigationItems().forEach { navItem ->
            NavigationBarItem(
                selected = navItem.route == route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(id = 0)
                    }
                },
                label = {
                    Text(text = navItem.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (navItem.count != null) {
                                Badge {
                                    Text(text = navItem.count.toString())
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (navItem.route == route) navItem.selectedIcon else navItem.unselectedIcon,
                            contentDescription = navItem.title
                        )
                    }
                })
        }
    }
}