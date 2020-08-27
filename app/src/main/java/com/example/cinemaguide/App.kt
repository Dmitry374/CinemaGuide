package com.example.cinemaguide

import android.app.Application
import com.example.cinemaguide.di.AppComponent
import com.example.cinemaguide.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
    }


}