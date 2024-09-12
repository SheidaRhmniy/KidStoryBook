package com.example.kid_storyapp

// کلاس داده‌ای که ویژگی‌های یک داستان را نمایش می‌دهد
data class Story(

    val title: Int,
    val cvImg: Int,
    val images: List<Int> ,// Store images as a list
    val audios: List<Int> , // Store images as a list
    val category: Int,
    val moral: Int

)
