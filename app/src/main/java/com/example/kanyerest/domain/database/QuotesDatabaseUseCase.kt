package com.example.kanyerest.domain.database

import androidx.lifecycle.LiveData
import com.example.kanyerest.domain.model.QuoteDatabaseModel
import com.example.kanyerest.domain.model.QuoteModel

interface QuotesDatabaseUseCase{

 suspend fun  saveData(quoteText: String)

 fun  fetchData() :List<QuoteDatabaseModel>

}