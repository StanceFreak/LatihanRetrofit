//package com.example.latihanretrofit.ViewModel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.latihanretrofit.Model.Books
//import com.example.latihanretrofit.Model.VolumeInfo
//import com.example.latihanretrofit.Repo.Repository
//import kotlinx.coroutines.launch
//import retrofit2.Call
//
//class MainViewModel(private val repository: Repository): ViewModel() {
//
//    val myResponse: MutableLiveData<Books> = MutableLiveData()
//
//    fun getPost() {
//        viewModelScope.launch {
//            val response = repository.getPost()
//            myResponse.value = response
//        }
//    }
//
//}