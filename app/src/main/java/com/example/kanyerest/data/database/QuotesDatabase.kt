package com.example.kanyerest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kanyerest.data.dao.QuotesDao
import com.example.kanyerest.domain.model.QuoteDatabaseModel

@Database(entities = [QuoteDatabaseModel::class], version = 1, exportSchema = false)
abstract class QuotesDatabase : RoomDatabase() {
        abstract fun myQuotesDao(): QuotesDao

    companion object
    {
        var INSTANCE: QuotesDatabase?=null

        fun getDatabaseInstance(context: Context): QuotesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return  tempInstance
            }
            synchronized(this){
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, QuotesDatabase::class.java,"Quotes").allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }
}