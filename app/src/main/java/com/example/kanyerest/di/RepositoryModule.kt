package com.example.kanyerest.di.modules

import com.example.kanyerest.domain.quotes.QuotesUseCase
import com.example.kanyerest.data.repository.quotes.QuotesUseCaseImpl
import org.koin.dsl.module

val repositoryModule= module {

    single<QuotesUseCase>  {
        QuotesUseCaseImpl()
    }

}