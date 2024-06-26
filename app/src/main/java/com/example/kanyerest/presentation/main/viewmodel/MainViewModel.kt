package com.example.kanyerest.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kanyerest.domain.database.QuotesDatabaseUseCase
import com.example.kanyerest.domain.model.QuoteDatabaseModel
import com.example.kanyerest.domain.quotes.QuotesUseCase
import com.example.kanyerest.presentation.state.QuoteState
import kotlinx.coroutines.launch

class MainViewModel(val quotesUseCase: QuotesUseCase, val quotesDatabaseUseCase: QuotesDatabaseUseCase) : ViewModel() {

    private val _state by lazy { MutableLiveData<QuoteState>() }
    val state: LiveData<QuoteState> = _state

    suspend fun searchQuote() {
        viewModelScope.launch {
            val response = quotesUseCase.fetchCurrencies()
            _state.postValue(QuoteState.ShowItems(response))
        }
    }

     fun fetchListQuotes(): List<QuoteDatabaseModel>{
        return quotesDatabaseUseCase.fetchData()
    }

}