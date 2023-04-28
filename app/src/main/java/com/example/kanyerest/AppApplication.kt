package com.example.kanyerest

import android.app.Application
import com.example.kanyerest.di.modules.repositoryModule
import com.example.kanyerest.di.modules.viewModelModule
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                repositoryModule,
                viewModelModule
            )
        }
    }
}