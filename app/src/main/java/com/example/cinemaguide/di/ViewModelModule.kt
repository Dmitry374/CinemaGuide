package com.example.cinemaguide.di

import androidx.lifecycle.ViewModel
import com.example.cinemaguide.ui.mainpage.MainPageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainPageViewModel::class)
    abstract fun bindViewModel(viewmodel: MainPageViewModel): ViewModel
}