package com.example.cinemaguide.di

import com.example.cinemaguide.repository.RemoteRepository
import com.example.cinemaguide.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repository: RemoteRepositoryImpl): RemoteRepository
}