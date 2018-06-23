package com.example.titouche.tasty

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface EndPoint {

    @GET("restaurants")
    fun getRestaurants():Call<ArrayList<Restaurant>>

    @GET("plats/{id_res}")
    fun getRestaurantPlats(@Path("id_res") id_res:Int):Call<ArrayList<Plat>>

    @GET("desserts/{id_res}")
    fun getRestaurantDesserts(@Path("id_res") id_res:Int):Call<ArrayList<Dessert>>

    @GET("entrees/{id_res}")
    fun getRestaurantEntrees(@Path("id_res") id_res:Int):Call<ArrayList<Entree>>

    @GET("diabetiques/{id_res}")
    fun getRestaurantDiabetiques(@Path("id_res") id_res:Int):Call<ArrayList<Diabetique>>

    @GET("vegetariens/{id_res}")
    fun getRestaurantVegetariens(@Path("id_res") id_res:Int):Call<ArrayList<Vegetarien>>
}