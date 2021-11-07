package com.example.latihanretrofit.Repo

import com.example.latihanretrofit.Api.RetrofitInstance
import com.example.latihanretrofit.Api.SimpleApi
import com.example.latihanretrofit.Model.Books
import com.example.latihanretrofit.Model.VolumeInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call

class Repository(private val instance: RetrofitInstance) {

    suspend fun getRomanceBooks() {
        instance.api.getRomanceBooks()
    }

    suspend fun getBooks() {
        instance.api.getBooks()
    }

}