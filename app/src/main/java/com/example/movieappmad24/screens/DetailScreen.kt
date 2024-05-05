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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.Injection.InjectorUtils
import com.example.movieappmad24.viewModels.DetailScreenViewModel
import com.example.movieappmad24.reuseableFunctions.SimpleTopAppBar
import com.example.movieappmad24.reuseableFunctions.MovieRow


@Composable
fun DetailScreen(movieId: String?, navController: NavController) {
    val detailScreenViewModel: DetailScreenViewModel = viewModel(
        factory = InjectorUtils.provideMoviesViewModelFactory(
            LocalContext.current
        )
    )
    val movieWithImages = detailScreenViewModel.getMovieById(movieId)?.collectAsState()?.value
    if (movieWithImages != null) {
        Scaffold(
            topBar = {
                SimpleTopAppBar(movie = movieWithImages.movie, navController = navController)
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                MovieRow(
                    movieWithImages,
                    onMovieRowClick = {},
                    onFavClick = { detailScreenViewModel.changeFavourite(movieWithImages) })
                ExoplayerTrailer(movieWithImages.movie.trailer)
                LazyRow {
                    items(movieWithImages.images) { image ->
                        AsyncImage(model = image.url, contentDescription = null)
                    }
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
    val videoURI = "android.resource://" + context.getPackageName() + "/${
        context.resources.getIdentifier(
            uri,
            "raw",
            context.packageName
        )
    }"
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
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}



