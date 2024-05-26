package com.example.kanyerest.data.repository.quotes

import com.example.kanyerest.data.api.NetworkUtils
import com.example.kanyerest.data.database.QuotesDatabase

import com.example.kanyerest.data.request.EndpointQuotes
import com.example.kanyerest.domain.database.QuotesDatabaseUseCase
import com.example.kanyerest.domain.model.QuoteDatabaseModel
import com.example.kanyerest.domain.model.QuoteModel
import com.example.kanyerest.domain.quotes.QuotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class QuotesUseCaseImpl(private val quotesDatabase : QuotesDatabase): QuotesUseCase, QuotesDatabaseUseCase {



    override suspend fun fetchCurrencies(): String {
        return withContext(Dispatchers.IO) {
            val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.kanye.rest")
            val endpoint = retrofitClient.create(EndpointQuotes::class.java)
            endpoint.getQuote().run {
                val quoteText = this.quote?: ""
                saveData(quoteText)
                quoteText
            }
        }
    }

    override suspend fun saveData(quoteText: String) {
        quotesDatabase.myQuotesDao().insertQuotes(
            QuoteDatabaseModel(
                null,
                quoteText
            )
        )
    }

    override suspend fun fetchData(): String {
        TODO("Not yet implemented")
    }

}