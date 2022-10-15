package com.example.fooddelivery.ui.viewutils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R

class FoodsMenuDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val margin16 = context.resources
        .getDimensionPixelSize(R.dimen.margin_foodmenu16)
    private val margin8 = context.resources
        .getDimensionPixelSize(R.dimen.margin_foodmenu8)


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
            0 -> Rect(margin16, margin16, margin16, margin8)
            state.itemCount - 1 -> Rect(margin16, margin8, margin16, margin8)
            else -> Rect(margin16, margin8, margin16, margin16)
        }

        outRect.apply {
            left = newRect.left
            right = newRect.right
            top = newRect.top
            bottom = newRect.bottom
        }
    }
}