package com.example.kanyerest.domain.database

import com.example.kanyerest.domain.model.QuoteDatabaseModel
import com.example.kanyerest.domain.model.QuoteModel

interface QuotesDatabaseUseCase{

 suspend fun  saveData(quoteText: String)

 suspend fun  fetchData() : String

}