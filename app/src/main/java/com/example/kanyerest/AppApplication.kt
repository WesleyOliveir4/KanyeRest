package com.example.kanyerest

import android.app.Application
import com.example.kanyerest.di.repositoryModule
import com.example.kanyerest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(
                repositoryModule,
                viewModelModule,
            )
        }
    }
}