package com.example.cinemaguide.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["id", "title"])
data class Movie(
    val id: Int,
    val title: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    val popularity: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
    val video: Boolean,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    val overview: String,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>
)