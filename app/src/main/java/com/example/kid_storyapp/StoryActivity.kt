package com.example.kid_storyapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kid_storyapp.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    private var binding:ActivityStoryBinding? = null
    private var position = 0
    private lateinit var storyList: ArrayList<Story>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //geting the story list and position
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        position = intent.getIntExtra("position", 0)
        storyList = Constants.getStoryList()
        setStoryView()

        //btn next
        binding?.btnNext?.setOnClickListener{
            if (position < storyList.size-1){
                position++
                setStoryView()
            }else{
                Toast.makeText(this, "No more stories available", Toast.LENGTH_SHORT).show()
            }
        }

        //btn Previous
        binding?.btnPrevious?.setOnClickListener{
            if (position > 0){
                position--
                setStoryView()
            }else{
                Toast.makeText(this, "No more stories available", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun setStoryView()
    {
        val story = storyList[position]
        binding?.storyImage?.setImageResource(story.image2)
        binding?.tvStoryTitle?.setText(story.title)
        binding?.tvStory?.setText(story.story)
        binding?.tvMoral?.setText(story.moral)

    }

    // Handle back button press using OnBackPressedDispatcher
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}