package com.example.latihanretrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.latihanretrofit.Api.SimpleApi
import com.example.latihanretrofit.Model.Books
import com.example.latihanretrofit.Repo.Repository
import com.example.latihanretrofit.model2.RomanceBooks
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val simpleApi: SimpleApi): ViewModel() {

    fun getAllData() {
        viewModelScope.launch {
            coroutineScope {
                val RomanceResponse : Call<RomanceBooks>?
                val RandomBookResponse : Call<Books>?
                val call1 = async { simpleApi.getRomanceBooks() }
                val call2 = async { simpleApi.getBooks() }

                try {
                    RomanceResponse = call1.await()
                    RandomBookResponse = call2.await()
                } catch (e : Exception) {
                    e.printStackTrace()
                }

            }
        }
    }



}