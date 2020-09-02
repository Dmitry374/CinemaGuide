package com.example.cinemaguide.data.network

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val page: Int,
    @field:SerializedName("total_results")
    val totalResults: Int,
    @field:SerializedName("total_pages")
    val totalPages: Int,
    val results: List<ResultMovie>
) {
    data class ResultMovie(
        val popularity: Double,
        @field:SerializedName("vote_count")
        val voteCount: Int,
        val video: Boolean,
        @field:SerializedName("poster_path")
        val posterPath: String,
        val id: Int,
        val adult: Boolean,
        @field:SerializedName("backdrop_path")
        val backdropPath: String,
        @field:SerializedName("original_language")
        val originalLanguage: String,
        @field:SerializedName("original_title")
        val originalTitle: String,
        @field:SerializedName("genre_ids")
        val genreIds: List<Int>,
        val title: String,
        @field:SerializedName("vote_average")
        val voteAverage: Double,
        val overview: String,
        @field:SerializedName("release_date")
        val releaseDate: String
    )
}