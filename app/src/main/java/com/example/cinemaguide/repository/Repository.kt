package com.example.cinemaguide.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Repository {
    fun loadFilms(): LiveData<List<String>> {
        val filmList = listOf("Spider-Man", "Gladiator", "Avatar", "The Fast and the Furious", "Race")

        val filmsLiveData: MutableLiveData<List<String>> = MutableLiveData()
        filmsLiveData.value = filmList

        return filmsLiveData
    }
}