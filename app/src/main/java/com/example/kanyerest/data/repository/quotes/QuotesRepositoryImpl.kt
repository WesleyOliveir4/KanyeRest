package com.example.kanyerest.data.repository.quotes

import com.example.kanyerest.data.api.NetworkUtils
import com.example.kanyerest.data.model.QuoteModel
import com.example.kanyerest.data.request.EndpointQuotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuotesRepositoryImpl():QuotesRepository {

    override suspend fun fetchCurrencies(): String {
        return withContext(Dispatchers.IO) {
            val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.kanye.rest")
            val endpoint = retrofitClient.create(EndpointQuotes::class.java)
            endpoint.getCurrencies().quote?: ""
        }
    }

}