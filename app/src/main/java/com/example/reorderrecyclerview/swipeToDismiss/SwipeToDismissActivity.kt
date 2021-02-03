package com.example.reorderrecyclerview.swipeToDismiss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.reorderrecyclerview.databinding.ActivityMainBinding
import com.example.reorderrecyclerview.reorder.ItemModel

class SwipeToDismissActivity : AppCompatActivity() {

    private var mItemTouchHelper: ItemTouchHelper? = null
    lateinit var swipeToDismissAdapter: SwipeToDismissAdapter
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        setUpRecyclerview()
        if (::swipeToDismissAdapter.isInitialized){
            swipeToDismissAdapter.setData(getList())
        }

    }

    private fun setUpRecyclerview() {
        swipeToDismissAdapter = SwipeToDismissAdapter(){

        }

        activityMainBinding.recyclerReorder.adapter = swipeToDismissAdapter
        val callback: ItemTouchHelper.Callback = SwipeHelperCallback(swipeToDismissAdapter)
        mItemTouchHelper = ItemTouchHelper(callback)
        mItemTouchHelper?.attachToRecyclerView(activityMainBinding.recyclerReorder)
    }

    fun getList() : ArrayList<ItemModel>{
        val array : ArrayList<ItemModel> = ArrayList()
        array.add(ItemModel(title = "Item 1"))
        array.add(ItemModel(title = "Item 2"))
        array.add(ItemModel(title = "Item 3"))
        array.add(ItemModel(title = "Item 4"))
        array.add(ItemModel(title = "Item 5"))
        array.add(ItemModel(title = "Item 6"))
        array.add(ItemModel(title = "Item 7"))
        array.add(ItemModel(title = "Item 8"))
        array.add(ItemModel(title = "Item 9"))
        array.add(ItemModel(title = "Item 10"))
        array.add(ItemModel(title = "Item 12"))
        array.add(ItemModel(title = "Item 13"))
        array.add(ItemModel(title = "Item 14"))
        array.add(ItemModel(title = "Item 15"))
        array.add(ItemModel(title = "Item 16"))
        array.add(ItemModel(title = "Item 17"))
        array.add(ItemModel(title = "Item 18"))
        array.add(ItemModel(title = "Item 19"))
        array.add(ItemModel(title = "Item 20"))
        return array
    }

}
