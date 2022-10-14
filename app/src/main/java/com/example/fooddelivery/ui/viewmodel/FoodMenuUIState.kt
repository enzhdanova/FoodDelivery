package com.example.fooddelivery.ui.viewmodel

import com.example.fooddelivery.ui.viewmodel.model.Food
import com.example.fooddelivery.utils.FoodCategory

data class FoodMenuUIState(
    val category: List<String>? = null,
    val foods: List<Food>? = null
)
