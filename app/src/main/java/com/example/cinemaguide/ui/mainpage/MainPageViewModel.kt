package com.example.cinemaguide.ui.mainpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemaguide.data.Movie
import com.example.cinemaguide.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPageViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _films by lazy { MutableLiveData<List<Movie.Result>>() }
    val films: LiveData<List<Movie.Result>>
        get() = _films

    init {
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        compositeDisposable.add(
            movieRepository.fetchPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.results }
                .subscribeWith(object : DisposableSingleObserver<List<Movie.Result>>() {
                    override fun onSuccess(movies: List<Movie.Result>) {
                        _films.value = movies
                    }

                    override fun onError(throwable: Throwable) {
                        _films.value = emptyList()
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}