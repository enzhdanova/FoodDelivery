package com.example.fooddelivery.ui.viewmodel.model

import com.example.fooddelivery.utils.FoodCategory

data class Food(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val cost: Int,
    val category: FoodCategory,
    val image: String
)