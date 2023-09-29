package com.github.felipealafy.learningcomposer.superheroes.model

import androidx.annotation.StringRes

data class Hero(@StringRes val Name: Int, @StringRes val About: Int, val SelfPhoto: Int)
