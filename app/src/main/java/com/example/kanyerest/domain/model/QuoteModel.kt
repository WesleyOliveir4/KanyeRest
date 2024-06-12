package com.example.kanyerest.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.Date

data class QuoteModel(
    @SerializedName("quote")
    val quote: String?,
)
@Parcelize
@Entity(tableName = "Quotes")
data class QuoteDatabaseModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val quote: String?,
    val date: String?
): Parcelable