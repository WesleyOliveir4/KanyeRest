package com.example.kanyerest.di

import com.example.kanyerest.data.database.QuotesDatabase
import com.example.kanyerest.domain.quotes.QuotesUseCase
import com.example.kanyerest.data.repository.quotes.QuotesUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule= module {

    factory<QuotesDatabase>  {
        QuotesDatabase.getDatabaseInstance(androidContext())
    }

    single<QuotesUseCase>  {
        QuotesUseCaseImpl(get())
    }

}