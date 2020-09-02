package com.example.cinemaguide.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cinemaguide.common.Constants.Companion.API_KEY
import com.example.cinemaguide.data.entity.Movie
import com.example.cinemaguide.db.MovieDao
import com.example.cinemaguide.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val api: Api,
    private val movieDao: MovieDao
) {

    private val _movies by lazy { MutableLiveData<List<Movie>>() }
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun fetchPopularMovies(): Disposable {
        return api.loadPopularMovies(
            apiKey = API_KEY,
            language = "en-US",
            page = 1,
            region = "ru"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results }
            .subscribe(object : Consumer<List<Movie>> {
                override fun accept(movies: List<Movie>?) {
                    _movies.value = movies
                }

            },
                object : Consumer<Throwable> {
                    override fun accept(throwable: Throwable) {
                        _movies.value = emptyList()
                    }

                })
    }
}