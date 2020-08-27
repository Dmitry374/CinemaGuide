package com.example.cinemaguide.repository

import androidx.lifecycle.LiveData

interface RemoteRepository {
    fun loadFilms(): LiveData<List<String>>
}