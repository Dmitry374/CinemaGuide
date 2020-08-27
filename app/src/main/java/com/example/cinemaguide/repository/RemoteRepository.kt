package com.example.cinemaguide.repository

import com.example.cinemaguide.data.Movie
import io.reactivex.Single

interface RemoteRepository {

    fun fetchPopularMovies(): Single<Movie>
}