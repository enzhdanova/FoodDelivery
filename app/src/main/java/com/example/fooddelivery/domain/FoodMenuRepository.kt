package com.example.fooddelivery.domain

import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.utils.FoodCategory

interface FoodMenuRepository {
    suspend fun getFoodMenu(): Result<List<Food>>
    fun getCategory(): Result<List<FoodCategory>>
}