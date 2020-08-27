package com.example.cinemaguide.ui.mainpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cinemaguide.repository.RemoteRepository

class MainPageViewModelFactory(private val remoteRepository: RemoteRepository) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainPageViewModel::class.java)) {
            return MainPageViewModel(
                remoteRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}