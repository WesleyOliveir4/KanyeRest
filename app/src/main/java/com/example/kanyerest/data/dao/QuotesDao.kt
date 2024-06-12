package com.example.kanyerest.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kanyerest.domain.model.QuoteDatabaseModel

@Dao
interface QuotesDao {

    @Query("SELECT * FROM Quotes")
    fun getQuotes(): List<QuoteDatabaseModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuotes(quoteDatabaseModel: QuoteDatabaseModel)
}