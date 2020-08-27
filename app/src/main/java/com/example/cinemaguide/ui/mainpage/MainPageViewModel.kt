package com.example.cinemaguide.ui.mainpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cinemaguide.repository.RemoteRepository
import javax.inject.Inject

class MainPageViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {
    val films: LiveData<List<String>> = remoteRepository.loadFilms()
}