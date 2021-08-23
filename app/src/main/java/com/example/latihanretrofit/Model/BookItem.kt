package com.example.latihanretrofit.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class BookItem(
        @SerializedName("title")
        @Expose
        val title: String,
        @SerializedName("authors")
        @Expose
        val authors: List<String>,
        @SerializedName("pageCount")
        @Expose
        val pageCount: Int,
        @SerializedName("imageLinks")
        @Expose
        val imageLinks: ImageLinks,
        @SerializedName("averageRating")
        @Expose
        val averageRating: Double,
        @SerializedName("ratingsCount")
        @Expose
        val ratingsCount: Int,
        @SerializedName("retailPrice")
        @Expose
        val retailPrice: RetailPrice
)


