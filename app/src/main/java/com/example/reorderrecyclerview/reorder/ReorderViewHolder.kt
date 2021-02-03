package com.example.reorderrecyclerview.reorder

import android.view.MotionEvent
import android.view.View
import androidx.core.view.MotionEventCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.reorderrecyclerview.databinding.AdapterReorderBinding
import com.example.reorderrecyclerview.utils.ItemTouchHelperViewHolder
import com.example.reorderrecyclerview.utils.OnStartDragListener


class ReorderViewHolder(val binding: AdapterReorderBinding, val reordered : () -> Unit,
                        val dragStartListener : OnStartDragListener? = null)
    : RecyclerView.ViewHolder(binding.root), ItemTouchHelperViewHolder {

    fun setData(data: ItemModel) {
        itemView.apply {
            binding.tvAdapter.text = data.title

            binding.imReorder?.setOnTouchListener(View.OnTouchListener { v, event ->
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    dragStartListener?.onStartDrag(this@ReorderViewHolder)
                }
                false
            })

        }
    }

    override fun onItemSelected() {
    }

    override fun onItemClear() {
        reordered()
    }

}