package com.example.latihanretrofit.model2


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SaleInfo(
    @SerializedName("country")
    val country: String,
    @SerializedName("saleability")
    val saleability: String,
    @SerializedName("isEbook")
    val isEbook: Boolean
) : Parcelable