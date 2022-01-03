package com.example.latihanretrofit.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.latihanretrofit.Api.ApiHelper
import com.example.latihanretrofit.Api.ApiService
import com.example.latihanretrofit.Main.MainViewModel
import com.example.latihanretrofit.Repo.MainRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}