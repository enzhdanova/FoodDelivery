package com.example.fooddelivery.ui

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.data.model.MockeFood
import com.example.fooddelivery.databinding.ItemFoodBinding

class FoodMenuAdapter : RecyclerView.Adapter<FoodMenuAdapter.ViewHolder>() {

    val foods = MockeFood.foods

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: ItemFoodBinding = ItemFoodBinding.bind(view)

        fun bind(food: Food) {
            binding.titleFoodName.text = food.name
            binding.titleAbout.text = food.description
            binding.foodCoast.text = "${food.cost}${itemView.context.getString(R.string.rub)}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foods[position])
    }

    override fun getItemCount() = foods.size
}