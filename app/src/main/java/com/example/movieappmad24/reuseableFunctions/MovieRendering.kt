package com.example.movieappmad24.reuseableFunctions

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.Movie
import com.example.movieappmad24.navigation.Screen


@SuppressLint("UnrememberedMutableState")
@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(size=25.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                onItemClick(movie.id)
            }
    ) {
        Box {
            AsyncImage(
                model = movie.images[0],
                contentDescription = null,
            )
            IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Up Arrow",
                )
            }
        }
    }
    var arrow by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = movie.title, modifier = Modifier.padding(start=12.dp), fontSize = 22.sp)

        IconButton(onClick = { arrow = !arrow }) {
            Icon(
                imageVector = if (arrow) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Arrow"
            )
        }
    }
    AnimatedVisibility(visible = arrow) {
        Column(modifier = Modifier.padding(all = 12.dp)) {
            Text(text="Director: "+ movie.director)
            Text(text="Actors: " + movie.actors)
            Text(text="Genre: " + movie.genre)
            Text(text="Release Year: " + movie.year)
            Text(text="Rating: "+ movie.rating)
            Divider(color = Color.Black, thickness = 2.dp, modifier = Modifier.padding(all=12.dp))
            Text(text="Plot: " + movie.plot)
        }
    }
}
@Composable
fun MovieList(movieList: List<Movie>, paddingValues: PaddingValues, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = paddingValues.calculateBottomPadding(),
                top = paddingValues.calculateTopPadding()
            )
    ) {
        items(movieList) {
                movie -> MovieRow(movie, onItemClick = {
            navController.navigate(Screen.DetailScreen.route+"/${movie.id}")
        })
        }
    }
}