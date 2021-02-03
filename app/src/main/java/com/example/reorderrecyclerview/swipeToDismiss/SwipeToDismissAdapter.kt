package com.example.reorderrecyclerview.swipeToDismiss

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reorderrecyclerview.databinding.AdapterReorderBinding
import com.example.reorderrecyclerview.reorder.ItemModel
import com.example.reorderrecyclerview.utils.ItemTouchHelperAdapter
import kotlin.collections.ArrayList

class SwipeToDismissAdapter ( val onSwiped : () -> Unit) :
    RecyclerView.Adapter<SwipeViewHolder>(), ItemTouchHelperAdapter {

    var arrayItems : ArrayList<ItemModel> = ArrayList()

    fun setData(array : ArrayList<ItemModel>){
        arrayItems = array
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeViewHolder {
        val binding = AdapterReorderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SwipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayItems.size
    }

    override fun onBindViewHolder(holder: SwipeViewHolder, position: Int) {
        holder.setData(arrayItems[position])
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        return false
    }

    override fun onItemDismiss(position: Int) {
        arrayItems.removeAt(position);
        notifyItemRemoved(position);
        onSwiped()
    }
}