package com.example.kid_storyapp

object Constants {

    fun getStoryList():ArrayList<Story>{
        val storyList = ArrayList<Story>()

        val story1 = Story(
            R.string.title1,
            R.string.story1,
            R.string.moral1,
            R.drawable.rv_image1,
            R.drawable.image1
        )
        storyList.add(story1)

        val story2 = Story(
            R.string.title2,
            R.string.story2,
            R.string.moral2,
            R.drawable.rv_image2,
            R.drawable.image2
        )
        storyList.add(story2)

        val story3 = Story(
            R.string.title3,
            R.string.story3,
            R.string.moral3,
            R.drawable.rv_image3,
            R.drawable.image3
        )
        storyList.add(story3)

        val story4 = Story(
            R.string.title4,
            R.string.story4,
            R.string.moral4,
            R.drawable.rv_image4,
            R.drawable.image4
        )
        storyList.add(story4)


        return storyList
    }

}