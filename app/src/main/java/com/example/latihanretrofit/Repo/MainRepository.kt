package com.example.latihanretrofit.Repo

import com.example.latihanretrofit.Api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getRomanceBooks(
        startIndex : Int,
        maxResults : Int
    ) {
        apiHelper.getRomanceBooks(startIndex, maxResults)
    }


}