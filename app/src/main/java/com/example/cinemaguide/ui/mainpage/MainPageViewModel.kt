package com.example.cinemaguide.ui.mainpage

import androidx.lifecycle.ViewModel
import com.example.cinemaguide.repository.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPageViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    val filmsList = movieRepository.movies

    init {
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        compositeDisposable.add(movieRepository.refreshPopularMovies())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}