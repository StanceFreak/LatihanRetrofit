package com.example.latihanretrofit.model2


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pdf(
    @SerializedName("isAvailable")
    val isAvailable: Boolean
) : Parcelable