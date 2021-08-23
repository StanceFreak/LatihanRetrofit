//package com.example.latihanretrofit.Factory
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.latihanretrofit.Repo.Repository
//import com.example.latihanretrofit.ViewModel.MainViewModel
//
//class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return MainViewModel(repository) as T
//    }
//
//
//}