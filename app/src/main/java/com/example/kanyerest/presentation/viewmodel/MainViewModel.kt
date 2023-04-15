package com.example.kanyerest.presentation.viewmodel

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kanyerest.presentation.languages.LanguagesTranslate
import com.example.kanyerest.data.repository.quotes.QuotesRepositoryImpl
import com.example.kanyerest.presentation.state.MainState
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val _state by lazy { MutableLiveData<MainState>() }
    val state: LiveData<MainState> = _state

    private val quotesRepositoryImpl = QuotesRepositoryImpl()
    private val languagesTranslate = LanguagesTranslate()

    suspend fun searchQuote(buttonSearch: Button) {

        buttonSearch.setOnClickListener() {
            viewModelScope.launch {
                catchReturnQuotesImpl()
            }
        }
    }

    fun translateQuote(spinner: Spinner, quote : String, context: Context) {

        with(ArrayAdapter(context, R.layout.simple_spinner_dropdown_item,languagesTranslate.listLanguages())){
            this.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = this
        }


    }

    private suspend fun catchReturnQuotesImpl(){
        viewModelScope.launch {
            val response = quotesRepositoryImpl.fetchCurrencies()
            _state.postValue(MainState.ShowItems(response))
        }
    }
    


}