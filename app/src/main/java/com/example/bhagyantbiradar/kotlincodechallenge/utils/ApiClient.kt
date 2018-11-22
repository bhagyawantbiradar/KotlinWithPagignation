package com.example.bhagyantbiradar.kotlincodechallenge.utils

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val BASE_URL = "http://www.omdbapi.com"
    private var sRetrofit: Retrofit? = null


    val client: Retrofit?
        get() {
            if (sRetrofit == null) {
                sRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return sRetrofit
        }
}