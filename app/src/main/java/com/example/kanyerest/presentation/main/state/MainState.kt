package com.example.kanyerest.presentation.state

import com.example.kanyerest.domain.model.QuoteModel

interface MainState {

    data class ShowItems( val items: String):MainState
}