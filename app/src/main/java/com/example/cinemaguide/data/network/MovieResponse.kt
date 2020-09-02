package com.example.cinemaguide.data.network

import com.example.cinemaguide.data.entity.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val page: Int,
    @field:SerializedName("total_results")
    val totalResults: Int,
    @field:SerializedName("total_pages")
    val totalPages: Int,
    val results: List<Movie>
)