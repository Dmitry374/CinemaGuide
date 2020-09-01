package com.example.cinemaguide.di

import com.example.cinemaguide.repository.MovieRepository
import com.example.cinemaguide.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repository: MovieRepositoryImpl): MovieRepository
}