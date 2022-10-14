package com.example.fooddelivery.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.utils.FoodCategory

class FoodMenuViewModel : ViewModel() {

    private val _uiState = MutableLiveData(FoodMenuUIState())
    val uiState: LiveData<FoodMenuUIState> = _uiState

    init {
        getCategory()
    }

    private fun getCategory() {

        val foodCategory = FoodCategory.values().map {
            foodCategory -> foodCategory.food
        }.toList()

        _uiState.value = _uiState.value?.copy(category = foodCategory)
    }
}