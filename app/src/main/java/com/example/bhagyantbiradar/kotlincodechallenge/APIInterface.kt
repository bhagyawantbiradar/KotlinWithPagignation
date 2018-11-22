package com.example.bhagyantbiradar.kotlincodechallenge

import com.example.bhagyantbiradar.kotlincodechallenge.pojos.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIInterface {

    @GET("/")
    fun search(@Query("apikey") apiKey: String, @Query("s") title: String, @Query("page") pageNo: String): Call<SearchResult>
}