package com.example.latihanretrofit.Api

import com.example.latihanretrofit.Model.BookItem
import com.example.latihanretrofit.Model.Books
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {
    
//    @GET("/books/v1/volumes?q=novel")
//    fun getPost(): Call<Books>

    @GET("/books/v1/volumes?q=novel")
    fun getBooks(): Call<Books>
    
}