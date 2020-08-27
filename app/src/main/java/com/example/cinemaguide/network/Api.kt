package com.example.cinemaguide.network

import com.example.cinemaguide.data.Movie
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET

interface Api {

    @GET("/movie/popular")
    fun loadPopularMovies(
        @Field("api_key") api_key: String,
        @Field("language") language: String,
        @Field("page") page: Int,
        @Field("region") region: String
    ): Observable<List<Movie>>
}