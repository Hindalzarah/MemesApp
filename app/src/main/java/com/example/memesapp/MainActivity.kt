package com.example.memesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import androidx.recyclerview.widget.RecyclerView
import com.example.memesappimport.MemeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

lateinit var recyclerview: RecyclerView

private val memes = mutableListOf<Meme>()


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MemesApp)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        recyclerview = findViewById(R.id.meme_recyclerView)
        val adapter = MemeAdapter(memes)

        recyclerview.adapter = adapter



        var retrofit = Retrofit.Builder().baseUrl("https://api.imgflip.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        var memeApi = retrofit.create(MemeApi:: class.java)


        memeApi.getMemes().enqueue(object: Callback<MemeModel>{
            override fun onResponse(call: Call<MemeModel>, response: Response<MemeModel>) {
                response.body()?.run {
                    memes.addAll(this.data.memes )
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MemeModel>, t: Throwable) {

            }


        })

}




}