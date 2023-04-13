package com.example.kanyerest.data.repository.quotes

import com.example.kanyerest.data.model.QuoteModel

interface QuotesRepository{

 suspend fun fetchCurrencies() : String

}