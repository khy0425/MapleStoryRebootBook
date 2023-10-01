package com.leaf.rebootBook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leaf.rebootBook.dataClass.DropItem
import com.leaf.rebootBook.databinding.DropItemBinding
import com.bumptech.glide.Glide

class DropItemAdapter(
    private val dropItems: List<DropItem>
) : RecyclerView.Adapter<DropItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DropItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dropItems[position])
    }

    override fun getItemCount() = dropItems.size

    inner class ViewHolder(private val binding: DropItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dropItem: DropItem) {
            Glide.with(binding.root)
                .load(dropItem.imageResId)
                .into(binding.dropItemImage)
            binding.dropItemName.text = dropItem.name
        }
    }
}
