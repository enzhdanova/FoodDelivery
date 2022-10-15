package com.example.fooddelivery.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.fooddelivery.databinding.FragmentFoodMenuBinding
import com.example.fooddelivery.ui.BannerAdapter
import com.example.fooddelivery.ui.BannersItemDecoration
import com.example.fooddelivery.ui.FoodMenuAdapter
import com.example.fooddelivery.ui.FoodsMenuDecoration
import com.example.fooddelivery.ui.viewmodel.FoodMenuViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class FoodMenuFragment : Fragment() {

    private val viewModel: FoodMenuViewModel by viewModels()
    private var binding: FragmentFoodMenuBinding? = null
    private val foodMenuAdapter = FoodMenuAdapter()
    private val bannerAdapter = BannerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.uiState.observe(this) { uiState ->
            uiState.foods?.apply {
                foodMenuAdapter.submitList(this)
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
        binding?.recyclerFoodMenu?.apply {
            adapter = foodMenuAdapter
            addItemDecoration(FoodsMenuDecoration(requireContext()))

        }
        binding?.banner?.apply {
            adapter = bannerAdapter
            addItemDecoration(BannersItemDecoration(requireContext()))
        }

        bannerAdapter.submitList(viewModel.uiStateBanner.value)

        viewModel.uiState.value?.category?.forEach { category ->
            binding?.category?.apply {
                val newTab = this.newTab().setText(category)
                addTab(newTab)
            }
        }

        binding?.category?.addOnTabSelectedListener(tabListener)
    }

    private val tabListener = object : OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            val category = tab?.text.toString()

            viewModel.getFoodMenu(category)
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) = Unit

        override fun onTabReselected(tab: TabLayout.Tab?) = Unit
    }
}