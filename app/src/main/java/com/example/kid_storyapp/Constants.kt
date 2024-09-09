package com.example.kid_storyapp

object Constants {

    fun getStoryList():ArrayList<Story>{
        val storyList = ArrayList<Story>()

        val story1 = Story(
            R.string.title1,
            listOf(R.drawable.b1, R.drawable.b2, R.drawable.b3), // List of images
            listOf(R.raw.audio1, R.raw.audio2)
        )
        storyList.add(story1)

        val story2 = Story(
            R.string.title2,
            listOf(R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.yy), // Different number of images
            listOf(R.raw.audio1, R.raw.audio2)
        )
        storyList.add(story2)

        val story3 = Story(
            R.string.title3,
            listOf(R.drawable.s4, R.drawable.s3pic2, R.drawable.s3pic3), // 3 images
            listOf(R.raw.audio1, R.raw.audio2)
        )
        storyList.add(story3)



        return storyList
    }

}