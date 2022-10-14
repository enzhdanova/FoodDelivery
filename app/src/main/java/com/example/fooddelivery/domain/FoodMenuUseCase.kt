package com.example.fooddelivery.domain

import com.example.fooddelivery.data.FoodMenuRepository
import com.example.fooddelivery.data.model.Food

class FoodMenuUseCase {
    val foodMenuRepository = FoodMenuRepository()

    fun getBanners(): Result<List<Int>> {
        val bannersResult = foodMenuRepository.getBanners()
        bannersResult.onSuccess {
            return Result.success(it)
        }.onFailure {
            Result.failure<Throwable>(it)
        }
        return Result.failure(Throwable())
    }

    fun getFoodMenu(category: String): Result<List<Food>> {
        val foodsResult = foodMenuRepository.getFoodMenu()
        foodsResult.onSuccess { foods ->
            val foodWithCategory = foods.filter {
                it.category.food == category
            }
            return Result.success(foodWithCategory)
        }.onFailure {
            return Result.failure(it)
        }
        return Result.failure(Throwable())
    }

    fun getCategory(): Result<List<String>> {
        val resultCategory = foodMenuRepository.getCategory()
        resultCategory.onSuccess {
            category ->
            val categoriesName = category.map {
                    foodCategory ->
                foodCategory.food
            }
           return Result.success(categoriesName)
        }.onFailure {
            return Result.failure(it)
        }
        return Result.failure(Throwable())
    }
}