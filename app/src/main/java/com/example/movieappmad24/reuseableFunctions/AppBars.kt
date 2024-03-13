package com.example.movieappmad24.reuseableFunctions

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieappmad24.Movie
import com.example.movieappmad24.navigation.getNavigationItems
import com.example.movieappmad24.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTopAppBar(movie: Movie? = null, navController: NavController, text: String? = null) {
    if (movie != null) {
        TopAppBar(
            title = { Text(text= movie.title)},
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack()}) {
                    Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "ArrowBack" )
                }
            }
        )
    } else {
        TopAppBar(title= { Text(text= text!! ) } )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBottomAppBar(navController: NavController) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = currentBackStackEntry?.destination?.route

    NavigationBar {
        getNavigationItems().forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                            if (currentDestination == Screen.HomeScreen.route && item.title == "Watchlist") {
                                navController.navigate(Screen.WatchListScreen.route)
                            } else if (currentDestination == Screen.WatchListScreen.route && item.title == "Home") {
                                navController.popBackStack()
                            }
                            selectedItemIndex = index
                          },
                label = {
                    Text(text = item.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.count != null) {
                                Badge {
                                    Text(text = item.count.toString())
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) item.selectedIcon
                            else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                })
        }
    }
}