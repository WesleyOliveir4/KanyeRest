package com.example.kanyerest.presentation.state

import com.example.kanyerest.data.model.QuoteModel

interface MainState {

   object Loading : MainState

    data class ShowItems( val items: String):MainState
}