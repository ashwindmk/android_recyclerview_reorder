package com.ashwin.android.recyclerviewreorder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val messages: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageTextView = itemView.findViewById(R.id.message_textview) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.w("reorder-recyclerview", "on-create view-holder")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.w("reorder-recyclerview", "item-count: ${messages.size}")
        return messages.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.w("reorder-recyclerview", "on-bind view-holder: position: $position")
        (holder as ViewHolder).messageTextView.text = "$position : ${messages[position]}"
    }
}
