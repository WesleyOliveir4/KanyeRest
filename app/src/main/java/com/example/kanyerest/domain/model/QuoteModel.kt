package com.example.kanyerest.domain.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(

    @SerializedName("quote")
    val quote: String?,

)
