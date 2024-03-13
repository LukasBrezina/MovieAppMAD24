package com.example.movieappmad24

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.ui.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import coil.compose.AsyncImage
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieappmad24.navigation.Navigation
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                    Navigation()
                }
            }
        }
    }
    /*
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoadApplication(navigationItems: List<BottomNavigationItem> = getNavigationItems()) {
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        Scaffold(
            topBar = {
                TopAppBar(title= {Text(text= "Lukas's Movie APP" ) } )
            },
            bottomBar = {
                NavigationBar {
                    navigationItems.forEachIndexed{ index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = { selectedItemIndex = index },
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
        ) { paddingValues -> MovieList(movieList = getMovies(), paddingValues)}
    } 
    

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun MovieRow(movie: Movie) {
        Card(
            shape = RoundedCornerShape(size=25.dp)
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
    fun MovieList(movieList: List<Movie>, paddingValues: PaddingValues) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = paddingValues.calculateBottomPadding(),
                    top = paddingValues.calculateTopPadding()
                )
        ) {
            items(movieList) {
                    movie -> MovieRow(movie)
            }
        }
    } 
    */