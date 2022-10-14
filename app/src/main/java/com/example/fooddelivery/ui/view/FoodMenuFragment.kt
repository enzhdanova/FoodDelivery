package com.example.fooddelivery.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.fooddelivery.databinding.FragmentFoodMenuBinding
import com.example.fooddelivery.ui.FoodMenuAdapter
import com.example.fooddelivery.ui.viewmodel.FoodMenuViewModel

class FoodMenuFragment : Fragment() {

    private val viewModel: FoodMenuViewModel by viewModels()
    private var binding : FragmentFoodMenuBinding? = null
    private val adapter = FoodMenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel.uiState.observe(this) {
            uiState ->
            uiState.foods?.let {
                adapter.setContent(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        val FOOD_MENU_TAG: String = FoodMenuFragment::class.java.simpleName

        fun newInstance() = FoodMenuFragment()
    }

    private fun initView() {

        binding?.recyclerFoodMenu?.adapter = adapter

        viewModel.uiState.value?.category?.forEach { category ->
            binding?.category?.apply {
                val newTab = this.newTab().setText(category)
                addTab(newTab)
            }
        }
    }
}