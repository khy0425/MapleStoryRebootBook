package com.example.rebootBook.viewModel

import androidx.lifecycle.ViewModel
import com.example.rebootBook.R
import com.example.rebootBook.dataClass.RecipeDetailIngredient
import com.example.rebootBook.dataClass.Recipe

class RecipeViewModel : ViewModel() {
    val recipes = mutableListOf(
        Recipe(R.drawable.stir_fry, "앗볶음", listOf(RecipeDetailIngredient(R.drawable.green_skin, 5), RecipeDetailIngredient(R.drawable.green_sole,  10))),
        Recipe(R.drawable.omg_fried, "헉튀김", listOf(RecipeDetailIngredient(R.drawable.yellow_hoof,  5), RecipeDetailIngredient(R.drawable.yellow_mane,10))),
        Recipe(R.drawable.huhu_words, "허허말이", listOf(RecipeDetailIngredient(R.drawable.green_web,  5), RecipeDetailIngredient(R.drawable.yellow_mane,  5), RecipeDetailIngredient(R.drawable.black_feather, 10))),
        Recipe(R.drawable.this_nuddle, "이런면", listOf(RecipeDetailIngredient(R.drawable.yellow_hoof,  5), RecipeDetailIngredient(R.drawable.yellow_mane,  5), RecipeDetailIngredient(R.drawable.green_web, 10))),
        Recipe(R.drawable.that_steamed, "저런찜", listOf(RecipeDetailIngredient(R.drawable.green_skin,  5), RecipeDetailIngredient(R.drawable.green_sole,  5), RecipeDetailIngredient(R.drawable.green_carapace, 10))),
        Recipe(R.drawable.hoho_soup, "호호탕", listOf(RecipeDetailIngredient(R.drawable.green_web,  5), RecipeDetailIngredient(R.drawable.green_carapace,  5),  RecipeDetailIngredient(R.drawable.soft_nail, 10))),
        Recipe(R.drawable.wow_salad, "으악샐러드", listOf(RecipeDetailIngredient(R.drawable.material_fruit,  1), RecipeDetailIngredient(R.drawable.yellow_mane,  5), RecipeDetailIngredient(R.drawable.green_carapace, 5),  RecipeDetailIngredient(R.drawable.soft_nail, 10))),
        Recipe(R.drawable.hehe_roast, "크헉구이", listOf(RecipeDetailIngredient(R.drawable.material_fruit,  1), RecipeDetailIngredient(R.drawable.yellow_skin,  5), RecipeDetailIngredient(R.drawable.green_sole, 5),  RecipeDetailIngredient(R.drawable.black_feather, 10))),
        Recipe(R.drawable.dumplings, "깔깔만두", listOf(RecipeDetailIngredient(R.drawable.yellow_skin,  5), RecipeDetailIngredient(R.drawable.red_sole,  10))),
        Recipe(R.drawable.giggly_fried_rice, "낄낄볶음밥", listOf(RecipeDetailIngredient(R.drawable.green_hoof,  5), RecipeDetailIngredient(R.drawable.pupple_mane,  10))),
        Recipe(R.drawable.oing_pickle, "오잉피클", listOf(RecipeDetailIngredient(R.drawable.blue_web,  5), RecipeDetailIngredient(R.drawable.pupple_mane,  5),  RecipeDetailIngredient(R.drawable.blue_feather, 10))),
        Recipe(R.drawable.phew_pizza, "휴피자", listOf(RecipeDetailIngredient(R.drawable.green_hoof,  5), RecipeDetailIngredient(R.drawable.pupple_mane,  5),  RecipeDetailIngredient(R.drawable.blue_web, 10))),
        Recipe(R.drawable.ha_bread, "하빵", listOf(RecipeDetailIngredient(R.drawable.yellow_skin,  5), RecipeDetailIngredient(R.drawable.red_sole,  5),  RecipeDetailIngredient(R.drawable.purple_carapace, 10))),
        Recipe(R.drawable.lol_porridge, "큭큭죽", listOf(RecipeDetailIngredient(R.drawable.blue_web,  5), RecipeDetailIngredient(R.drawable.purple_carapace,  5),  RecipeDetailIngredient(R.drawable.dark_nail, 10))),
        Recipe(R.drawable.whoops_sundae, "엉엉순대", listOf(RecipeDetailIngredient(R.drawable.material_fruit,  1), RecipeDetailIngredient(R.drawable.pupple_mane,  5),  RecipeDetailIngredient(R.drawable.purple_carapace, 5),  RecipeDetailIngredient(R.drawable.dark_nail, 10))),
        Recipe(R.drawable.sobbing_hwachae, "흑흑화채", listOf(RecipeDetailIngredient(R.drawable.material_fruit,  1), RecipeDetailIngredient(R.drawable.yellow_skin,  5),  RecipeDetailIngredient(R.drawable.red_sole, 5),  RecipeDetailIngredient(R.drawable.blue_feather, 10))),
    )

    fun searchRecipe(query: String): List<Recipe> {
        return recipes.filter { it.name.contains(query, ignoreCase = true) }
    }
}