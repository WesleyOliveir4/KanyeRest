package com.example.kanyerest.data.repository.quotes

import com.example.kanyerest.data.api.NetworkUtils
import com.example.kanyerest.data.request.EndpointQuotes
import com.example.kanyerest.domain.quotes.QuotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuotesUseCaseImpl(): QuotesUseCase {

    override suspend fun fetchCurrencies(): String {
        return withContext(Dispatchers.IO) {
            val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.kanye.rest")
            val endpoint = retrofitClient.create(EndpointQuotes::class.java)
            endpoint.getQuote().quote?: ""
        }
    }

}