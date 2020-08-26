package com.example.cinemaguide.ui.mainpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cinemaguide.repository.Repository

class MainPageViewModel(repository: Repository) : ViewModel() {
    val films: LiveData<List<String>> = repository.loadFilms()
}