package com.example.movieappmad24.ViewModel

import com.example.movieappmad24.dataClasses.MovieWithImages

interface MoviesViewModel {
    fun changeFavourite (movieWithImages: MovieWithImages)
}