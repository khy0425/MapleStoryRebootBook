package com.leaf.rebootBook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leaf.rebootBook.dataClass.Acquisition
import com.leaf.rebootBook.dataClass.ItemRecipe
import com.leaf.rebootBook.databinding.ItemDropRecipeBinding

class DropItemRecipeAdapter : ListAdapter<ItemRecipe, DropItemRecipeAdapter.ItemRecipeViewHolder>(ItemDiffCallback) {

    object ItemDiffCallback : DiffUtil.ItemCallback<ItemRecipe>() {
        override fun areItemsTheSame(oldItem: ItemRecipe, newItem: ItemRecipe): Boolean {
            // Assuming each item is unique for this example
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemRecipe, newItem: ItemRecipe): Boolean {
            return oldItem == newItem
        }
    }

    class ItemRecipeViewHolder(private val binding: ItemDropRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemRecipe: ItemRecipe) {
            Glide.with(binding.root)
                .load(itemRecipe.category.imageRes)
                .into(binding.recipeImageView)

            binding.recipeNameTextView.text = itemRecipe.name
            binding.recipeUsageTextView.text = itemRecipe.usageDuration.getDisPlay()

            binding.recipeSourceNameTextView.text = getCombinedSources(itemRecipe)
            binding.recipeSourceLevelTextView.text = ""
        }

        private fun getCombinedSources(itemRecipe: ItemRecipe): String {
            val combinedSources = StringBuilder()
            itemRecipe.acquisition.forEach {
                combinedSources.append(when (it) {
                    is Acquisition.Monster -> "${it.name} | Lv. ${it.level} | "
                    is Acquisition.NPC -> "${it.name} (NPC) | "
                    else -> "정보 없음 | "
                })
            }

            // Remove the trailing separator
            if (combinedSources.isNotEmpty()) {
                combinedSources.setLength(combinedSources.length - 3)
            }

            return combinedSources.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRecipeViewHolder {
        val binding = ItemDropRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemRecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemRecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}