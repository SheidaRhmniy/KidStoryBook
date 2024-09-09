package com.example.kid_storyapp

import android.media.MediaPlayer
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
    private var imagePosition = 0 // Variable to track the current image
    //private var audioPosition = 0 // Variable to track the current image
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false  // Track play/pause state
    private lateinit var storyList: ArrayList<Story>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //geting the story list and position
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        position = intent.getIntExtra("position", 0)
        storyList = Constants.getStoryList()
        setStoryView()

        // Set up the back button
        binding?.btnBack?.setOnClickListener {
            // Go back to the previous activity (MainActivity)
            finish()  // Finish the current activity and go back
        }


        //btn next
        binding?.btnNext?.setOnClickListener{
            val currentStory = storyList[position]

            if (imagePosition < currentStory.images.size - 1) {
                imagePosition++
                setStoryView()
            } else {
                Toast.makeText(this, "No more images available", Toast.LENGTH_SHORT).show()
            }

        }

        //btn Previous
        binding?.btnPrevious?.setOnClickListener{
            if (imagePosition > 0) {
                imagePosition--
                setStoryView()
            } else {
                Toast.makeText(this, "No previous images available", Toast.LENGTH_SHORT).show()
            }
        }

        // Button for Play/Pause
        binding?.btnPlay?.setOnClickListener {
            if (isPlaying) {
                pauseAudio()
            } else {
                playAudio()
            }
        }


    }

    private fun setStoryView()
    {
        val story = storyList[position]
        // Set the appropriate image based on the current imagePosition
        binding?.storyImage?.setImageResource(story.images[imagePosition])


         // Stop any currently playing audio
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, story.audios[imagePosition])

        // Reset play/pause state
        isPlaying = false
        binding?.btnPlay?.setImageResource(R.drawable.play)  // Assuming play is default

    }

    private fun playAudio() {
        mediaPlayer?.start()
        isPlaying = true
        binding?.btnPlay?.setImageResource(R.drawable.pause)  // Change to pause icon
    }

    private fun pauseAudio() {
        mediaPlayer?.pause()
        isPlaying = false
        binding?.btnPlay?.setImageResource(R.drawable.play)  // Change to play icon
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()  // Release media player resources
    }

    // Handle back button press using OnBackPressedDispatcher
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}