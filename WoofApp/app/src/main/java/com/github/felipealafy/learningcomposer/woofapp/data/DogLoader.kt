package com.github.felipealafy.learningcomposer.woofapp.data

import com.github.felipealafy.learningcomposer.woofapp.R
import com.github.felipealafy.learningcomposer.woofapp.model.Dog

class DogLoader {
    fun loadDogs() = listOf(
        Dog(R.string.koda, R.drawable.koda, 2),
        Dog(R.string.lola, R.drawable.lola, 16),
        Dog(R.string.frankie, R.drawable.frankie, 2),
        Dog(R.string.nox, R.drawable.nox, 8),
        Dog(R.string.faye, R.drawable.faye, 8),
        Dog(R.string.bella, R.drawable.bella, 14),
        Dog(R.string.Moana, R.drawable.moana, 2),
        Dog(R.string.tzeitel, R.drawable.tzeitel, 7),
        Dog(R.string.leroy, R.drawable.leroy, 4)
    )
}