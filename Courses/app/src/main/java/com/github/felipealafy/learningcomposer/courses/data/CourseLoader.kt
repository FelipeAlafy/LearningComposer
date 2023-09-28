package com.github.felipealafy.learningcomposer.courses.data

import com.github.felipealafy.learningcomposer.courses.R
import com.github.felipealafy.learningcomposer.courses.model.Course

class CourseLoader {
    fun loadCourses() = listOf(
        Course(R.string.architecture, R.drawable.architecture, 58),
        Course(R.string.crafts, R.drawable.crafts, 121),
        Course(R.string.business, R.drawable.business, 78),
        Course(R.string.culinary, R.drawable.culinary, 118),
        Course(R.string.design, R.drawable.design, 423),
        Course(R.string.fashion, R.drawable.fashion, 92),
        Course(R.string.film, R.drawable.film, 165),
        Course(R.string.gaming, R.drawable.gaming, 164),
        Course(R.string.drawing, R.drawable.drawing, 326),
        Course(R.string.lifestyle, R.drawable.lifestyle, 305),
        Course(R.string.music, R.drawable.music, 212),
        Course(R.string.painting, R.drawable.painting, 172),
        Course(R.string.photography, R.drawable.photography, 321),
        Course(R.string.tech, R.drawable.tech, 118)
    )
}