package com.example.movieappmad24

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.ui.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text(text="Lukas's Movie APP")})
                    },
                    bottomBar = {
                        BottomAppBar() {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = "Home-Button",
                                    )
                                }
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Wishlist-Button",
                                    )
                                }
                            }
                        }
                    }
                ) {_ -> MovieList(movieList = getMovies())}
                }
            }
        }
    }
    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun MovieRow(movie:Movie) {
        Card {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.movie_image),
                    contentDescription = "placeholder_image"
                )
                IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Up Arrow",
                        // modifier = Modifier.align(Alignment.TopEnd)
                    )
                }
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = movie.title)
            var arrow = remember{ mutableStateOf(Icons.Default.KeyboardArrowUp) }
            IconButton(onClick = { if (arrow.value== Icons.Default.KeyboardArrowUp) arrow.value=
                Icons.Default.KeyboardArrowDown else arrow.value= Icons.Default.KeyboardArrowUp }) {
                Icon(
                    imageVector = arrow.value,
                    contentDescription = "Arrow"
                )
            }
            if (arrow.value == Icons.Default.KeyboardArrowDown) {
                Column() {
                    Text(text="Director -> " + movie.director)
                    Text(text="Actors -> " + movie.actors)
                    Text(text="Genre -> " + movie.genre)
                    Text(text="Release Year -> " + movie.year)
                    Text(text="Plot -> " + movie.plot)
                    Text(text="Rating -> " + movie.rating)
                    Text(text="Trailer -> " + movie.trailer)
                }
            }
        }
    }
    @Composable
    fun MovieList(movieList: List<Movie>) {
        LazyColumn() {
            items(movieList) {
                    movie -> MovieRow(movie)
            }
        }
    }
