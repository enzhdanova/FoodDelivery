package com.example.fooddelivery.domain

import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.utils.FoodCategory
import javax.inject.Inject

interface FoodMenuRepository {
    suspend fun getFoodMenu(): Result<List<Food>>
    fun getCategory(): Result<List<FoodCategory>>
}