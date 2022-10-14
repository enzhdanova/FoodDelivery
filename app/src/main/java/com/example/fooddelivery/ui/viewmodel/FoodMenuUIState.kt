package com.example.fooddelivery.ui.viewmodel

import com.example.fooddelivery.data.model.Food

data class FoodMenuUIState(
    val category: List<String>? = null,
    val foods: List<Food>? = null
)
