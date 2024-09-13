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
            cvImg = R.drawable.s1_cv,
            listOf(R.drawable.s1_0,R.drawable.s1_1, R.drawable.s1_2, R.drawable.s1_3,R.drawable.s1_4,R.drawable.s1_5,
                R.drawable.s1_6,R.drawable.s1_7,R.drawable.s1_8,R.drawable.s1_9,R.drawable.s1_10,
                R.drawable.s1_11,R.drawable.s1_12,R.drawable.s1_13,R.drawable.s1_14,R.drawable.s1_15,
                R.drawable.s1_16,R.drawable.s1_17,R.drawable.s1_18,R.drawable.s1_19,R.drawable.s1_20,
                R.drawable.s1_21,R.drawable.s1_22,R.drawable.s1_23,R.drawable.s1_24,R.drawable.s1_25,
                R.drawable.s1_26,R.drawable.s1_27,R.drawable.s1_28,R.drawable.s1_29,R.drawable.s1_30,
                R.drawable.s1_31,R.drawable.s1_32,R.drawable.s1_33,R.drawable.s1_34), // List of images

            listOf(R.raw.s1_0,R.raw.s1_1, R.raw.s1_2,R.raw.s1_3,R.raw.s1_4,R.raw.s1_5,R.raw.s1_6,R.raw.s1_7,
                R.raw.s1_8,R.raw.s1_9,R.raw.s1_10,R.raw.s1_11,R.raw.s1_12,R.raw.s1_13,R.raw.s1_14,
                R.raw.s1_15,R.raw.s1_16,R.raw.s1_17,R.raw.s1_18,R.raw.s1_19,R.raw.s1_20,R.raw.s1_21,
                R.raw.s1_22,R.raw.s1_23,R.raw.s1_24,R.raw.s1_25,R.raw.s1_26,R.raw.s1_27,R.raw.s1_28,
                R.raw.s1_29,R.raw.s1_30,R.raw.s1_31,R.raw.s1_32,R.raw.s1_33,R.raw.s1_34),


            R.string.categoryTeen,
            R.string.moral1
        )
        storyList.add(story1)

        val story2 = Story(
            R.string.title2,
            cvImg = R.drawable.s2_1,
            listOf(R.drawable.comingsoon), // Different number of images
            audios = emptyList(),
            R.string.categoryToddler,
            R.string.moral2,
            isComingSoon = true
        )
        storyList.add(story2)

        val story3 = Story(
            R.string.title3,
            cvImg = R.drawable.s3_1,
            listOf(R.drawable.comingsoon), // Different number of images
            audios = emptyList(),
            R.string.categoryToddler,
            R.string.moral3,
            isComingSoon = true
        )
        storyList.add(story3)

        val story4 = Story(
            R.string.title4,
            cvImg = R.drawable.s4_1,
            listOf(R.drawable.comingsoon), // Different number of images
            audios = emptyList(),
            R.string.categoryChildren,
            R.string.moral4,
            isComingSoon = true
        )
        storyList.add(story4)



        return storyList
    }

}