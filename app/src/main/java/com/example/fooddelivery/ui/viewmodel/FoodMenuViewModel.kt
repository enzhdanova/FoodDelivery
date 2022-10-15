package com.example.fooddelivery.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.ui.FoodMenuUseCase
import com.example.fooddelivery.utils.BannerEnum
import com.example.fooddelivery.utils.FoodCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodMenuViewModel @Inject constructor(
    private val foodMenuUseCase: FoodMenuUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData(FoodMenuUIState())
    val uiState: LiveData<FoodMenuUIState> = _uiState

    private val _uiStateBanner = MutableLiveData<List<Int>>()
    val uiStateBanner: LiveData<List<Int>> = _uiStateBanner


    init {
        getCategory()
        getFoodMenu(FoodCategory.PIZZA.food)
        getBanners()
    }

    private fun getCategory() {
        viewModelScope.launch {
            val resultFoodCategory = foodMenuUseCase.getCategory()
            resultFoodCategory.onSuccess { category ->
                _uiState.value = _uiState.value?.copy(category = category)
            }
        }
    }

    fun getFoodMenu(category: String) {
        viewModelScope.launch {
            val resultFoods = foodMenuUseCase.getFoodMenu(category)
            resultFoods.onSuccess { foodWithCategory ->
                _uiState.value = _uiState.value?.copy(foods = foodWithCategory)
            }
        }
    }

    private fun getBanners() {
        _uiStateBanner.value = BannerEnum.values().map { bannerEnum ->
            bannerEnum.id
        }
    }
}