package com.example.latihanretrofit.Main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.latihanretrofit.Repo.MainRepository
import com.example.latihanretrofit.Utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository): ViewModel() {

    fun getRomanceBooks(
        startIndex : Int,
        maxResults : Int
    ) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getRomanceBooks(startIndex, maxResults)))
        }
        catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occured!"))
        }
    }

}