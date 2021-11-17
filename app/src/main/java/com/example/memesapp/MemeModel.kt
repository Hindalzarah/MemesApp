package com.example.memesapp


import com.google.gson.annotations.SerializedName

data class MemeModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)