package com.example.fooddelivery.ui

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R

class BannersItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val margin_horizintal = context.resources
        .getDimensionPixelSize(R.dimen.margin_banner_horizontal)
    private val margin_vertical = context.resources
        .getDimensionPixelSize(R.dimen.margin_banner_vertical)
    private val margin_start = context.resources
        .getDimensionPixelSize(R.dimen.margin_banner_start)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return

        val newRect = when (position) {
            0 ->
                Rect(margin_start, margin_vertical, margin_horizintal, margin_vertical)
            state.itemCount - 1 ->
                Rect(margin_horizintal, margin_vertical, margin_horizintal, margin_vertical)
            else ->
                Rect(margin_horizintal, margin_vertical, margin_start, margin_vertical)
        }

        outRect.apply {
            left = newRect.left
            right = newRect.right
            top = newRect.top
            bottom = newRect.bottom

        }
    }
}