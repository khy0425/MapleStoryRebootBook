package com.leaf.rebootBook.dataClass

data class Recipe(
    val imageRes: Int,
    val name: String,
    val ingredients: List<RecipeDetailIngredient>
)