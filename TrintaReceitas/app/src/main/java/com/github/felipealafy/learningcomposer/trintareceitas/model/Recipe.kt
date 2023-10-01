package com.github.felipealafy.learningcomposer.trintareceitas.model

import androidx.annotation.StringRes

data class Recipe(@StringRes val Name: Int, val Image: Int, val Ingredients: List<Int>, @StringRes val Preparation: Int)
