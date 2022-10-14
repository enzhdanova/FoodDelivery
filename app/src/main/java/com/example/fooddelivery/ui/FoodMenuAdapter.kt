package com.example.fooddelivery.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.data.model.Food
import com.example.fooddelivery.databinding.ItemFoodBinding

class FoodMenuAdapter : ListAdapter<Food, RecyclerView.ViewHolder>(DIFF) {

    var foodsList = mutableListOf<Food>()

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<Food>() {

            override fun areItemsTheSame(oldItem: Food, newItem: Food) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Food, newItem: Food) = oldItem == newItem

        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: ItemFoodBinding = ItemFoodBinding.bind(view)

        fun bind(food: Food) {
            binding.titleFoodName.text = food.name
            binding.titleAbout.text = food.description
            val coast = "${food.cost}${itemView.context.getString(R.string.rub)}"
            binding.foodCoast.text = coast
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = foodsList.size

    fun setContent(foods: List<Food>) {
        foodsList.clear()
        foodsList.addAll(foods)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(foodsList[position])
        }
    }
}