package com.example.kanyerest.data.request

import com.example.kanyerest.domain.model.QuoteModel
import retrofit2.http.GET

interface EndpointQuotes {
    @GET("https://api.kanye.rest")
    suspend fun getQuote() : QuoteModel
}