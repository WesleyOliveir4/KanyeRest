package com.example.kanyerest.data.api

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object{
        fun getRetrofitInstance(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getOkHttp3Instance(path: String): Request {
            return  Request.Builder()
                .url(path)
                .get()
                .addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
                .addHeader("X-RapidAPI-Host", "nlp-translation.p.rapidapi.com")
                .build()
        }

    }


}