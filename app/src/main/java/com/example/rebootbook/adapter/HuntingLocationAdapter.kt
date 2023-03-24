package com.example.rebootBook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rebootBook.dataClass.HuntingLocation
import com.example.rebootBook.databinding.HuntingItemBinding

class HuntingLocationAdapter :
    ListAdapter<HuntingLocation, HuntingLocationAdapter.HuntingLocationViewHolder>(HuntingLocationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HuntingLocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HuntingItemBinding.inflate(inflater, parent, false)
        return HuntingLocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HuntingLocationViewHolder, position: Int) {
        val huntingLocation = getItem(position)
        holder.bind(huntingLocation)
    }

    inner class HuntingLocationViewHolder(
        private val binding: HuntingItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HuntingLocation) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    class HuntingLocationDiffCallback : DiffUtil.ItemCallback<HuntingLocation>() {
        override fun areItemsTheSame(oldItem: HuntingLocation, newItem: HuntingLocation): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: HuntingLocation, newItem: HuntingLocation): Boolean {
            return oldItem == newItem
        }
    }
}
