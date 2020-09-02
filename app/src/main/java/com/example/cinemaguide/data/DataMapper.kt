package com.example.cinemaguide.data

import com.example.cinemaguide.data.entity.Movie
import com.example.cinemaguide.data.network.MovieResponse

fun List<MovieResponse.ResultMovie>.toMovieEntityList() = this.map { it.toMovieEntity() }

fun MovieResponse.ResultMovie.toMovieEntity() = Movie(
    id = this.id,
    title = this.title,
    originalTitle = this.originalTitle,
    voteAverage = this.voteAverage,
    originalLanguage = this.originalLanguage,
    releaseDate = this.releaseDate,
    popularity = this.popularity,
    voteCount = this.voteCount,
    video = this.video,
    posterPath = this.posterPath,
    adult = this.adult,
    backdropPath = this.backdropPath,
    overview = this.overview,
    genreIds = this.genreIds
)

fun List<Movie>.toApiMoviesList() = this.map { it.toData() }

fun Movie.toData() = MovieResponse.ResultMovie(
    popularity = this.popularity,
    voteCount = this.voteCount,
    video = this.video,
    posterPath = this.posterPath,
    id = this.id,
    adult = this.adult,
    backdropPath = this.backdropPath,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    genreIds = this.genreIds,
    title = this.title,
    voteAverage = this.voteAverage,
    overview = this.overview,
    releaseDate = this.releaseDate
)