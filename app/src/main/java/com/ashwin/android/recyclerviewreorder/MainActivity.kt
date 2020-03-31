package com.ashwin.android.recyclerviewreorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reorder_recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val messages = arrayListOf("Hello there", "Hi there", "Best wishes", "Good morning", "Good afternoon", "Good evening", "Good night", "Have a nice day", "Wish you the same", "Best of Luck", "Good luck", "See you soon", "Talk to you later", "Have a great year ahead", "Best wishes", "Sweet dreams")
        val recyclerAdapter = RecyclerViewAdapter(messages)
        reorder_recyclerview.adapter = recyclerAdapter

        val simpleCallback: ItemTouchHelper.SimpleCallback = object: ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                val oldPosition = viewHolder.adapterPosition
                val newPosition = target.adapterPosition
                Collections.swap(messages, oldPosition, newPosition)
                recyclerAdapter.notifyItemMoved(oldPosition, newPosition)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // Not implementing any swipe action
            }
        }

        val itemTouchHelper = ItemTouchHelper(simpleCallback)

        itemTouchHelper.attachToRecyclerView(reorder_recyclerview)
    }
}
