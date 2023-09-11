package com.example.rebootBook.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("adapter")
        fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            recyclerView.adapter = adapter
        }
    }
}
