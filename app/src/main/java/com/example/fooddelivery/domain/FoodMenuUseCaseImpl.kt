package com.example.fooddelivery.domain

import com.example.fooddelivery.data.FoodMenuRepositoryImpl
import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.ui.FoodMenuUseCase
import javax.inject.Inject

class FoodMenuUseCaseImpl @Inject constructor(
    private val foodMenuRepository: FoodMenuRepositoryImpl
) : FoodMenuUseCase {

    override suspend fun getFoodMenu(category: String): Result<List<Food>> {
        val foodsResult = foodMenuRepository.getFoodMenu()
        foodsResult.onSuccess { foods ->
            val foodWithCategory = foods.filter {
                it.category.food == category
            }
            return Result.success(foodWithCategory)
        }.onFailure {
            return Result.failure(Exception())
        }
        return Result.failure(Exception())
    }

    override fun getCategory(): Result<List<String>> {
        val resultCategory = foodMenuRepository.getCategory()
        resultCategory.onSuccess { category ->
            val categoriesName = category.map { foodCategory ->
                foodCategory.food
            }
            return Result.success(categoriesName)
        }.onFailure {
            return Result.failure(it)
        }
        return Result.failure(Throwable())
    }
}