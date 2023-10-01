package com.leaf.rebootBook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leaf.rebootBook.dataClass.RecipeDetailIngredient
import com.leaf.rebootBook.databinding.ItemIngredientBinding

class IngredientAdapter(private var ingredients: List<RecipeDetailIngredient>) : RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    class IngredientViewHolder(private val binding: ItemIngredientBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: RecipeDetailIngredient) {
            binding.ingredient = ingredient
            binding.executePendingBindings()

            Glide.with(binding.root.context)
                .load(ingredient.icon)
                .into(binding.ivIngredientImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemIngredientBinding.inflate(layoutInflater, parent, false)
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    fun setIngredients(ingredients: List<RecipeDetailIngredient>) {
        this.ingredients = ingredients
        notifyDataSetChanged()
    }
}