package com.example.fooddelivery.ui

import com.example.fooddelivery.data.model.Food

interface FoodMenuUseCase {
    suspend fun getFoodMenu(category: String): Result<List<Food>>
    fun getCategory(): Result<List<String>>
}