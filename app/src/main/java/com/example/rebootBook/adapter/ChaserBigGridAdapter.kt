package com.example.rebootBook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.rebootBook.dataClass.MidnightChaser
import com.example.rebootBook.databinding.ItemMidnightChaserBinding

class ChaserBigGridAdapter(
    private val glide: RequestManager,
    private val onChaserClicked: (Int, Int) -> Unit
) : RecyclerView.Adapter<ChaserBigGridAdapter.ViewHolder>() {

    private var bigGridItems: List<List<MidnightChaser>> = listOf()

    fun updateBigGridItems(newItems: List<List<MidnightChaser>>) {
        this.bigGridItems = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMidnightChaserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val smallGridItems = bigGridItems[position]
        holder.bind(smallGridItems, position)
    }

    override fun getItemCount() = bigGridItems.size

    inner class ViewHolder(private val binding: ItemMidnightChaserBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.smallGrid.layoutManager = GridLayoutManager(binding.root.context, 3)
        }

        fun bind(smallGridItems: List<MidnightChaser>, bigIndex: Int) {
            val smallGridAdapter = ChaserSmallGridAdapter(glide) { smallIndex ->
                onChaserClicked(bigIndex, smallIndex)
            }
            binding.smallGrid.adapter = smallGridAdapter
            smallGridAdapter.updateChasers(smallGridItems)
        }
    }
}