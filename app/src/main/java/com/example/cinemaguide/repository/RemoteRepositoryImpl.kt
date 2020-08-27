package com.example.cinemaguide.repository

import com.example.cinemaguide.common.Constants.Companion.API_KEY
import com.example.cinemaguide.data.Movie
import com.example.cinemaguide.network.Api
import io.reactivex.Single
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val api: Api
) : RemoteRepository {

    override fun fetchPopularMovies(): Single<Movie> {
        return api.loadPopularMovies(
            apiKey = API_KEY,
            language = "en-US",
            page = 1,
            region = "ru"
        )
    }
}