package com.example.fooddelivery.network

import com.example.fooddelivery.network.entity.FoodRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface FoodMenuApi {
    @Headers("Prefer: code=200, example=success")
    @GET("/")
    suspend fun getFoods(): Response<List<FoodRequest>>
}