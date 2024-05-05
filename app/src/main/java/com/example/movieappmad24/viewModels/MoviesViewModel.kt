package com.example.movieappmad24.viewModels

import com.example.movieappmad24.dataClasses.MovieWithImages

interface MoviesViewModel {
    fun changeFavourite(movieWithImages: MovieWithImages)
}