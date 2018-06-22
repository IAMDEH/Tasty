package com.example.titouche.tasty

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitService {
    val baseUrl = "http://192.168.43.14:8088/"

    val endpoint:EndPoint by lazy {
        Retrofit.Builder().baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).build().create(EndPoint::class.java)

    }

}
