package com.example.fooddelivery.network.entity

import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.utils.FoodCategory

data class FoodRequest(
    val id: Int,
    val image_title: String,
    val title: String,
    val description: String,
    val basic_price: Int,
    val food_type: String
) {
    fun toModel() = Food(
        id = id,
        name = title,
        description = description,
        image = image_title,
        category = FoodCategory.valueOf(food_type.uppercase()),
        cost = basic_price
    )
}
