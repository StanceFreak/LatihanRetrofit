package com.example.latihanretrofit.Api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getRomanceBooks(
        startIndex: Int,
        maxResults : Int
    ) = apiService.getRomanceBooks(startIndex, maxResults)

}