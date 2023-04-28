package com.example.kanyerest.di.modules

import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kanyerest.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {


    viewModel {
          MainViewModel(
              quotesRepository = get()
          )
    }

}