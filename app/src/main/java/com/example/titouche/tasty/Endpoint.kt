package com.example.titouche.tasty

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface EndPoint {

    @GET("restaurants")
    fun getRestaurants():Call<ArrayList<Restaurant>>


}