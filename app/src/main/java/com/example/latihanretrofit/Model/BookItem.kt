package com.example.latihanretrofit.Model

import com.google.gson.annotations.SerializedName

class BookItem(
        @SerializedName("title")
        val title: String,
        @SerializedName("authors")
        val authors: List<String>,
        @SerializedName("pageCount")
        val pageCount: Int,
        @SerializedName("imageLinks")
        val imageLinks: ImageLinks,
        @SerializedName("averageRating")
        val averageRating: Double,
        @SerializedName("ratingsCount")
        val ratingsCount: Int,
        @SerializedName("retailPrice")
        val retailPrice: RetailPrice
)

data class ImageLinks(
        @SerializedName("smallThumbnail")
        val smallThumbnail: String,
        @SerializedName("thumbnail")
        val thumbnail: String
)

data class RetailPrice(
        @SerializedName("amount")
        val amount: Int,
        @SerializedName("currencyCode")
        val currencyCode: String
)