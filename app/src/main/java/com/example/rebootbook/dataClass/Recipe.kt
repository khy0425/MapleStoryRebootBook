package com.example.rebootBook.dataClass

data class Recipe(
    val imageRes: Int,
    val name: String,
    val ingredients: List<RecipeDetailIngredient>
)