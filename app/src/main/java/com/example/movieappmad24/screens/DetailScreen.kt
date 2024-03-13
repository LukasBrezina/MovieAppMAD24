package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.Movie
import com.example.movieappmad24.getMovieById


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(movieId: String?, navController: NavController) {
    val movie: Movie? = getMovieById(movieId)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text=movie!!.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("homescreen") }) {
                        Icon(imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "ArrowBack" )
                    }
                }
                )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            MovieRow(movie!!, onItemClick = {

            })
            LazyRow() {
                items(movie.images) {image ->
                    AsyncImage(model = image, contentDescription = null)
                }
            }
        }
    }
}



