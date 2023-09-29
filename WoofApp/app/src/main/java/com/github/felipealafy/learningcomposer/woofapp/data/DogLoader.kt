package com.github.felipealafy.learningcomposer.woofapp.data

import com.github.felipealafy.learningcomposer.woofapp.R
import com.github.felipealafy.learningcomposer.woofapp.model.Dog

class DogLoader {
    fun loadDogs() = listOf(
        Dog(R.string.koda, R.drawable.koda, 2, R.string.dog_description_1),
        Dog(R.string.lola, R.drawable.lola, 16, R.string.dog_description_2),
        Dog(R.string.frankie, R.drawable.frankie, 2, R.string.dog_description_3),
        Dog(R.string.nox, R.drawable.nox, 8, R.string.dog_description_4),
        Dog(R.string.faye, R.drawable.faye, 8, R.string.dog_description_5),
        Dog(R.string.bella, R.drawable.bella, 14, R.string.dog_description_6),
        Dog(R.string.Moana, R.drawable.moana, 2, R.string.dog_description_7),
        Dog(R.string.tzeitel, R.drawable.tzeitel, 7, R.string.dog_description_8),
        Dog(R.string.leroy, R.drawable.leroy, 4, R.string.dog_description_9)
    )
}