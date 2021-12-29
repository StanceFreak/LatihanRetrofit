package com.example.latihanretrofit.Api

import com.example.latihanretrofit.Utils.Constant.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    private val retrofit by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val hClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(hClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}