package com.example.memesapp

import retrofit2.Call
import retrofit2.http.GET

interface MemeApi {

    @GET("/get_memes")

    fun getMemes(): Call<MemeModel>

}