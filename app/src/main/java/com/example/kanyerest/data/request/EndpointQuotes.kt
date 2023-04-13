package com.example.kanyerest.data.request

import com.example.kanyerest.data.model.QuoteModel
import retrofit2.http.GET

interface EndpointQuotes {
    @GET("https://api.kanye.rest")
    suspend fun getCurrencies() : QuoteModel
}