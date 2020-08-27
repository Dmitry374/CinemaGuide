package com.example.cinemaguide.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cinemaguide.network.Api
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val api: Api
) : RemoteRepository {
    override fun loadFilms(): LiveData<List<String>> {
        val filmList = listOf("Spider-Man", "Gladiator", "Avatar", "The Fast and the Furious", "Race")

        val filmsLiveData: MutableLiveData<List<String>> = MutableLiveData()
        filmsLiveData.value = filmList

        return filmsLiveData
    }
}