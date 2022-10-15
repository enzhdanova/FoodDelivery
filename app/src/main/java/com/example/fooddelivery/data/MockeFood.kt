package com.example.fooddelivery.data

import androidx.annotation.DrawableRes
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.utils.FoodCategory

object MockeFood {
    val foods = listOf<Food>(
        Food(id = 0, "Пицца с помидорами",
        "Очень вкусная пицца с помидорами",
        category = FoodCategory.PIZZA, image = "", cost = 300),
        Food(id = 1, "Пицца с сыром",
            "Очень вкусная пицца с помидорами и сыром",
            category = FoodCategory.PIZZA, image = "", cost = 310),
        Food(id = 2, "Пиперони",
            "Острая колбаса, оливки",
            category = FoodCategory.PIZZA, image = "", cost = 200),
        Food(id = 3, "4 сыра",
            "Несколько видов сыра",
            category = FoodCategory.PIZZA, image = "", cost = 150),
        Food(id = 4, "Пицца с ананасами",
            "В составе пиццы ананасы",
            category = FoodCategory.PIZZA, image = "", cost = 400),

        Food(id = 5, "Соус соевый",
            "Самый обычный соевый соус",
            category = FoodCategory.SAUCES, image = "", cost = 300),
        Food(id = 6, "Соус песто",
            "зелень песто",
            category = FoodCategory.SAUCES, image = "", cost = 300),
        Food(id = 7, "Острый сыр",
            "Сыр, чеснок, майонез",
            category = FoodCategory.SAUCES, image = "", cost = 300)
    )
}