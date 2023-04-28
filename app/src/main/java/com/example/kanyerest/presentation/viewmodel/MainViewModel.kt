package com.example.kanyerest.presentation.viewmodel

import android.R
import android.content.Context
import android.view.View
import android.widget.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kanyerest.data.repository.quotes.QuotesRepository
import com.example.kanyerest.data.repository.quotes.QuotesRepositoryImpl
import com.example.kanyerest.presentation.state.MainState
import kotlinx.coroutines.launch

class MainViewModel(val quotesRepository: QuotesRepository) : ViewModel() {

    private val _state by lazy { MutableLiveData<MainState>() }
    val state: LiveData<MainState> = _state

    suspend fun searchQuote(buttonSearch: Button) {

        buttonSearch.setOnClickListener() {
            viewModelScope.launch {
                catchReturnQuotesImpl()
            }
        }
    }

    private suspend fun catchReturnQuotesImpl(){
        viewModelScope.launch {
            val response = quotesRepository.fetchCurrencies()
            _state.postValue(MainState.ShowItems(response))
        }
    }



}