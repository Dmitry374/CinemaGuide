package com.example.cinemaguide.data

import com.google.gson.annotations.SerializedName

data class Movie(
    val page: Int,
    val results: List<Result>,
    @field:SerializedName("total_results")
    val totalResults: Int,
    @field:SerializedName("total_pages")
    val totalPages: Int
) {
    data class Result(
        @field:SerializedName("poster_path")
        val posterPath: String,
        val adult: Boolean,
        val overview: String,
        @field:SerializedName("release_date")
        val releaseDate: String,
        @field:SerializedName("genre_ids")
        val genreIds: List<Int>,
        val id: Int,
        @field:SerializedName("original_title")
        val originalTitle: String,
        @field:SerializedName("original_language")
        val originalLanguage: String,
        val title: String,
        @field:SerializedName("backdrop_path")
        val backdropPath: String,
        val popularity: Double,
        @field:SerializedName("vote_count")
        val voteCount: Int,
        val video: Boolean,
        @field:SerializedName("vote_average")
        val voteAverage: Double
    )
}