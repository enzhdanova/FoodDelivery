package com.example.fooddelivery.data

import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.utils.FoodCategory

class FoodMenuRepository {

    fun getFoodMenu(): Result<List<Food>> {
        val foods = MockeFood.foods
        return Result.success(foods)
    }

    fun getCategory(): Result<List<FoodCategory>> {
        return Result.success(FoodCategory.values().toList())
    }
}