package com.example.reorderrecyclerview.reorder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reorderrecyclerview.databinding.AdapterReorderBinding
import com.example.reorderrecyclerview.utils.ItemTouchHelperAdapter
import com.example.reorderrecyclerview.utils.OnStartDragListener
import java.util.*
import kotlin.collections.ArrayList

class ReorderAdapter (val dragStartListener : OnStartDragListener , val reorderd : () -> Unit) :
    RecyclerView.Adapter<ReorderViewHolder>(), ItemTouchHelperAdapter  {

    var arrayItems : ArrayList<ItemModel> = ArrayList()

    fun setData(array : ArrayList<ItemModel>){
        arrayItems = array
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReorderViewHolder {
        val binding = AdapterReorderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ReorderViewHolder(binding,reorderd,dragStartListener)
    }

    override fun getItemCount(): Int {
        return arrayItems.size
    }

    override fun onBindViewHolder(holder: ReorderViewHolder, position: Int) {
        holder.setData(arrayItems[position])
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(arrayItems, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        TODO("Not yet implemented")
    }
}