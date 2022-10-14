package com.example.fooddelivery.data.model

import com.example.fooddelivery.utils.FoodCategory

object MockeFood {
    val foods = listOf<Food>(
        Food(id = 0, "Пицца с помидорами",
        "Очень вкусная пицца с помидорами",
        category = FoodCategory.PIZZA, image = "", cost = 300),
        Food(id = 0, "Пицца с сыром",
            "Очень вкусная пицца с помидорами и сыром",
            category = FoodCategory.PIZZA, image = "", cost = 310),
        Food(id = 0, "Пиперони",
            "Острая колбаса, оливки",
            category = FoodCategory.PIZZA, image = "", cost = 200),
        Food(id = 0, "4 сыра",
            "Несколько видов сыра",
            category = FoodCategory.PIZZA, image = "", cost = 150),
        Food(id = 0, "Пицца с ананасами",
            "В составе пиццы ананасы",
            category = FoodCategory.PIZZA, image = "", cost = 400),

        Food(id = 0, "Соус соевый",
            "Самый обычный соевый соус",
            category = FoodCategory.PIZZA, image = "", cost = 300),
        Food(id = 0, "Соус песто",
            "зелень песто",
            category = FoodCategory.PIZZA, image = "", cost = 300),
        Food(id = 0, "Острый сыр",
            "Сыр, чеснок, майонез",
            category = FoodCategory.PIZZA, image = "", cost = 300)
    )
}