package com.example.kid_storyapp

object Constants {

    /**
     * این تابع یک لیست از اشیاء Story تولید کرده و برمی‌گرداند.
     * هر داستان شامل موارد زیر است:
     * - یک عنوان (شناسه منابع از فایل strings.xml)
     * - یک تصویر کاور (در اینجا به صورت پیش‌فرض یک تصویر قرار داده شده است)
     * - یک لیست از تصاویر (منابع drawable)
     * - یک لیست از فایل‌های صوتی (منابع raw)
     * - یک دسته‌بندی (شناسه منابع از فایل strings.xml)
     * - یک پیام اخلاقی (شناسه منابع از فایل strings.xml)
     */

    fun getStoryList():ArrayList<Story>{
        // ایجاد یک ArrayList خالی از اشیاء Story

        val storyList = ArrayList<Story>()

        val story1 = Story(
            R.string.title1,
            cvImg = R.drawable.logo,
            listOf(R.drawable.b1, R.drawable.b2, R.drawable.b3), // List of images
            listOf(R.raw.audio1, R.raw.audio2),
            R.string.categoryTeen,
            R.string.moral1
        )
        storyList.add(story1)

        val story2 = Story(
            R.string.title2,
            cvImg = R.drawable.logo,
            listOf(R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.yy), // Different number of images
            listOf(R.raw.audio1, R.raw.audio2),
            R.string.categoryChildren,
            R.string.moral2
        )
        storyList.add(story2)

        val story3 = Story(
            R.string.title3,
            cvImg = R.drawable.logo,
            listOf(R.drawable.s4, R.drawable.s3pic2, R.drawable.s3pic3), // 3 images
            listOf(R.raw.audio1, R.raw.audio2),
            R.string.categoryToddler,
            R.string.moral3
        )
        storyList.add(story3)

        val story4 = Story(
            R.string.title4,
            cvImg = R.drawable.logo,
            listOf(R.drawable.s4, R.drawable.s3pic2, R.drawable.s3pic3), // 3 images
            listOf(R.raw.audio1, R.raw.audio2),
            R.string.categoryToddler,
            R.string.moral4
        )
        storyList.add(story4)

        val story5 = Story(
            R.string.title5,
            cvImg = R.drawable.logo,
            listOf(R.drawable.s4, R.drawable.s3pic2, R.drawable.s3pic3), // 3 images
            listOf(R.raw.audio1, R.raw.audio2),
            R.string.categoryToddler,
            R.string.moral5
        )
        storyList.add(story5)

        val story6 = Story(
            R.string.title6,
            cvImg = R.drawable.logo,
            listOf(R.drawable.s4, R.drawable.s3pic2, R.drawable.s3pic3), // 3 images
            listOf(R.raw.audio1, R.raw.audio2),
            R.string.categoryToddler,
            R.string.moral6
        )
        storyList.add(story6)



        return storyList
    }

}