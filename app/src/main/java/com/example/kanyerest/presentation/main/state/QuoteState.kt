package com.example.kanyerest.presentation.state

interface QuoteState {

    data class ShowItems( val items: String):QuoteState
}