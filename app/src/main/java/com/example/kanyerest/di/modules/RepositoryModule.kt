package com.example.kanyerest.di.modules

import com.example.kanyerest.data.repository.quotes.QuotesRepository
import com.example.kanyerest.data.repository.quotes.QuotesRepositoryImpl
import org.koin.dsl.module

val repositoryModule= module {


    single<QuotesRepository>  {
        QuotesRepositoryImpl()
    }

}