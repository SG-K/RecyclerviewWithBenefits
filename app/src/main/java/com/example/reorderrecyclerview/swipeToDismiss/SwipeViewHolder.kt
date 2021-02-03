package com.example.reorderrecyclerview.swipeToDismiss

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reorderrecyclerview.databinding.AdapterReorderBinding
import com.example.reorderrecyclerview.reorder.ItemModel

class SwipeViewHolder(val binding: AdapterReorderBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun setData(data: ItemModel) {
        itemView.apply {
            binding.tvAdapter.text = data.title
            binding.imReorder.visibility = View.GONE
        }
    }

}