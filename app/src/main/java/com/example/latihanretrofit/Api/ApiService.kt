package com.example.latihanretrofit.Api

import com.example.latihanretrofit.model2.RomanceBooks
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/books/v1/volumes?q=subject:romance")
    fun getRomanceBooks(
        @Query("startIndex") startIndex: Int,
        @Query("maxResults") maxResults : Int
    ): Call<RomanceBooks>
    
}