package com.example.latihanretrofit.Model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RetailPrice(
    @SerializedName("amount")
    val amount: Int?,
    @SerializedName("currencyCode")
    val currencyCode: String
)