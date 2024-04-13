package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.models.getMovieById
import com.example.movieappmad24.reuseableFunctions.SimpleTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieRow


@Composable
fun DetailScreen(movieId: String?, moviesViewModel: MoviesViewModel, navController: NavController) {
    val movie: Movie? = getMovieById(movieId)
    Scaffold(
        topBar = {
            SimpleTopAppBar(movie = movie, navController = navController)
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            MovieRow(movie!!, onMovieRowClick = {}, onFavClick = {})
            ExoplayerTrailer(movie.trailer)
            LazyRow {
                items(movie.images) {image ->
                    AsyncImage(model = image, contentDescription = null)
                }
            }
        }
    }
}
// Tutorial: https://medium.com/@munbonecci/how-to-display-videos-using-exoplayer-on-android-with-jetpack-compose-1fb4d57778f4
@Composable
fun ExoplayerTrailer(uri: String) {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    var videoURI = "android.resource://" + context.getPackageName() + "/${context.resources.getIdentifier(uri, "raw", context.packageName)}"
    val mediaSource = remember(videoURI) {
        MediaItem.fromUri(videoURI)
    }

    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = {
            ctx -> PlayerView(ctx).apply {
                player = exoPlayer
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}



