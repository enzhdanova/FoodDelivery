package com.example.fooddelivery.data

import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.domain.FoodMenuRepository
import com.example.fooddelivery.network.FoodMenuApi
import com.example.fooddelivery.network.entity.FoodRequest
import com.example.fooddelivery.utils.FoodCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FoodMenuRepositoryImpl @Inject constructor(
    private val foodMenuApi: FoodMenuApi
) : FoodMenuRepository {

    override suspend fun getFoodMenu(): Result<List<Food>> {
        return withContext(Dispatchers.IO) {
            try {
                val foodRequests: List<FoodRequest> = foodMenuApi.getFoods().body() ?: emptyList()
                val foods: List<Food> = foodRequests.map {
                    it.toModel()
                }
                print("-------------------------------")
                print(foodRequests)
                Result.success(foods)
            } catch (ioe: Exception) {
                print("-------------------------------")
                print(ioe)
                Result.failure(ioe)
            }
        }
    }


    override fun getCategory(): Result<List<FoodCategory>> {
        return Result.success(FoodCategory.values().toList())
    }
}