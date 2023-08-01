package com.github.felipealafy.learningcomposer.artgallery

import androidx.compose.ui.res.stringResource

data class CircularQueue (
    val ImageResourceID: Int,
    val ContentDescriptionID: Int,
    val ArtWorkTitle: Int,
    val ArtistName: Int,
    val ArtYear: Int,
    var Next: CircularQueue?,
    var Previous: CircularQueue?
) {

}