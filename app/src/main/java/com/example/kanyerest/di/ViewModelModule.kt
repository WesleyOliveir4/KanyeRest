package com.example.kanyerest.di

import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kanyerest.presentation.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {


    viewModel {
          MainViewModel(
              quotesUseCase = get(),
              quotesDatabaseUseCase = get()
          )
    }

}