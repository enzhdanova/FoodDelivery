package com.example.fooddelivery.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.menu?.setOnItemSelectedListener(menuListener)
        binding?.menu?.selectedItemId = R.id.menu_food
    }

    private val menuListener =
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_food -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragment, FoodMenuFragment.newInstance())
                        addToBackStack(FoodMenuFragment.FOOD_MENU_TAG)
                    }
                }
                R.id.menu_basket -> {
                }
                R.id.menu_profile -> {
                }
            }
            return@OnItemSelectedListener true
        }

}