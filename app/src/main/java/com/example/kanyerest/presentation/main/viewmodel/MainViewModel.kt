package com.example.kanyerest.presentation.main.viewmodel

import android.widget.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kanyerest.domain.quotes.QuotesUseCase
import com.example.kanyerest.presentation.state.MainState
import kotlinx.coroutines.launch

class MainViewModel(val quotesRepository: QuotesUseCase) : ViewModel() {

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