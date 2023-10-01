package com.github.felipealafy.learningcomposer.trintareceitas.data

import com.github.felipealafy.learningcomposer.trintareceitas.R
import com.github.felipealafy.learningcomposer.trintareceitas.model.Recipe

object Loader {
    fun recipeLoader() = listOf(
        Recipe(R.string.recipe1, R.drawable.recipe1, listOf(R.string.recipe1_ingredient_1, R.string.recipe1_ingredient_2, R.string.recipe1_ingredient_3, R.string.recipe1_ingredient_4, R.string.recipe1_ingredient_5, R.string.recipe1_ingredient_6, R.string.recipe1_ingredient_7, R.string.recipe1_ingredient_8, R.string.recipe1_ingredient_9, R.string.recipe1_ingredient_10, R.string.recipe1_ingredient_11), R.string.recipe1_preparation_method),
        Recipe(R.string.recipe2, R.drawable.recipe2, listOf(R.string.recipe2_ingredient_1, R.string.recipe2_ingredient_2, R.string.recipe2_ingredient_3, R.string.recipe2_ingredient_4, R.string.recipe2_ingredient_5, R.string.recipe2_ingredient_6, R.string.recipe2_ingredient_7, R.string.recipe2_ingredient_8, R.string.recipe2_ingredient_9, R.string.recipe2_ingredient_10, R.string.recipe2_ingredient_11), R.string.recipe2_preparation_method),
        Recipe(R.string.recipe3, R.drawable.recipe3, listOf(R.string.recipe3_ingredient_1, R.string.recipe3_ingredient_2, R.string.recipe3_ingredient_3), R.string.recipe3_preparation_method),
        Recipe(R.string.recipe4, R.drawable.recipe4, listOf(R.string.recipe4_ingredient_1, R.string.recipe4_ingredient_2, R.string.recipe4_ingredient_3, R.string.recipe4_ingredient_4, R.string.recipe4_ingredient_5, R.string.recipe4_ingredient_6, R.string.recipe4_ingredient_7, R.string.recipe4_ingredient_8, R.string.recipe4_ingredient_9, R.string.recipe4_ingredient_10), R.string.recipe4_preparation_method),
        Recipe(R.string.recipe5, R.drawable.recipe5, listOf(R.string.recipe5_ingredient_1, R.string.recipe5_ingredient_2, R.string.recipe5_ingredient_3, R.string.recipe5_ingredient_4, R.string.recipe5_ingredient_5, R.string.recipe5_ingredient_6, R.string.recipe5_ingredient_7, R.string.recipe5_ingredient_8, R.string.recipe5_ingredient_9), R.string.recipe5_preparation_method),
        Recipe(R.string.recipe6, R.drawable.recipe6, listOf(R.string.recipe6_ingredient_1, R.string.recipe6_ingredient_2, R.string.recipe6_ingredient_3, R.string.recipe6_ingredient_4, R.string.recipe6_ingredient_5, R.string.recipe6_ingredient_6, R.string.recipe6_ingredient_7, R.string.recipe6_ingredient_8), R.string.recipe6_preparation_method),
        Recipe(R.string.recipe7, R.drawable.recipe7, listOf(R.string.recipe7_ingredient_1, R.string.recipe7_ingredient_2, R.string.recipe7_ingredient_3, R.string.recipe7_ingredient_4, R.string.recipe7_ingredient_5, R.string.recipe7_ingredient_6, R.string.recipe7_ingredient_7), R.string.recipe7_preparation_method)
    )
}