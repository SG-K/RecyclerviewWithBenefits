package com.example.reorderrecyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reorderrecyclerview.databinding.ActivityHomeBinding
import com.example.reorderrecyclerview.reorder.ReorderActivity
import com.example.reorderrecyclerview.swipeToDismiss.SwipeToDismissActivity

class MainActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        setUpListeners()
    }

    private fun setUpListeners() {

        activityHomeBinding.btnReorder.setOnClickListener {
            val intent = Intent(this@MainActivity, ReorderActivity::class.java)
            startActivity(intent)
        }

        activityHomeBinding.btnSwipe.setOnClickListener {
            val intent = Intent(this@MainActivity, SwipeToDismissActivity::class.java)
            startActivity(intent)
        }

    }

}