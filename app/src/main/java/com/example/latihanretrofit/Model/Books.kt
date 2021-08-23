package com.example.latihanretrofit.Model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("kind")
    @Expose
    val kind: String,
    @SerializedName("totalItems")
    @Expose
    val totalItems: Int,
    @SerializedName("items")
    @Expose
    val items: List<Item>
)