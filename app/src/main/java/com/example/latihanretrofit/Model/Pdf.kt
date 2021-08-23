package com.example.latihanretrofit.Model


import com.google.gson.annotations.SerializedName

data class Pdf(
    @SerializedName("isAvailable")
    val isAvailable: Boolean,
    @SerializedName("acsTokenLink")
    val acsTokenLink: String
)