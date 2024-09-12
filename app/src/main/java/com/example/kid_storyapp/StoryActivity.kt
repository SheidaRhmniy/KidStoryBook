package com.example.kid_storyapp

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kid_storyapp.databinding.ActivityStoryBinding
import java.util.concurrent.TimeUnit

class StoryActivity : AppCompatActivity() {
    private var binding:ActivityStoryBinding? = null
    private var position = 0
    private var imagePosition = 0 // Variable to track the current image
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false  // Track play/pause state
    private lateinit var storyList: ArrayList<Story>
    private val handler = Handler()
    private lateinit var updateSeekBarRunnable: Runnable
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
                Toast.makeText(this, "به پایان داستان رسیده اید!", Toast.LENGTH_SHORT).show()
            }

        }

        //btn Previous
        binding?.btnPrevious?.setOnClickListener{
            if (imagePosition > 0) {
                imagePosition--
                setStoryView()
            } else {
                Toast.makeText(this, "صفحه قبل دیگری وجود ندارد!", Toast.LENGTH_SHORT).show()
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

        binding?.seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    updateCurrentTimeText(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Pause the audio when the user starts dragging the SeekBar
                if (isPlaying) {
                    pauseAudio()
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Seek to the new position and resume playback if it was paused
                mediaPlayer?.seekTo(binding?.seekBar?.progress ?: 0)
                if (!isPlaying) {
                    playAudio()
                }
            }
        })


    }

    private fun setStoryView() {
        try {
            val story = storyList[position]
            // تلاش برای بارگذاری تصویر
            binding?.storyImage?.setImageResource(story.images.getOrNull(imagePosition) ?: R.drawable.logo)
            binding?.tvStoryTitle?.setText(story.title)

            // تلاش برای بارگذاری فایل صوتی
            val audioResId = story.audios.getOrNull(imagePosition) ?: R.raw.audio1 // فایل صوتی پیش‌فرض
            mediaPlayer?.release() // آزاد کردن MediaPlayer قدیمی (اگر وجود دارد)
            mediaPlayer = MediaPlayer.create(this, audioResId)

            // بررسی موفقیت در بارگذاری فایل صوتی
            if (mediaPlayer == null) {
                throw Exception("MediaPlayer could not be initialized")
            }

            // تنظیمات مربوط به SeekBar و زمان‌ها
            val duration = mediaPlayer?.duration ?: 0
            binding?.seekBar?.max = duration
            updateTotalTimeText(duration)

            // تنظیم دکمه Play/Pause
            isPlaying = false
            binding?.btnPlay?.setImageResource(R.drawable.play)

            // Listener برای اتمام پخش صدا
            mediaPlayer?.setOnCompletionListener {
                isPlaying = false
                binding?.btnPlay?.setImageResource(R.drawable.play)
                binding?.seekBar?.progress = 0
                updateCurrentTimeText(0)
            }

            // به‌روزرسانی SeekBar هر ۱ ثانیه
            updateSeekBarRunnable = object : Runnable {
                override fun run() {
                    try {
                        val currentPosition = mediaPlayer?.currentPosition ?: 0
                        binding?.seekBar?.progress = currentPosition
                        updateCurrentTimeText(currentPosition)
                        handler.postDelayed(this, 1000)
                    } catch (e: Exception) {
                        Toast.makeText(this@StoryActivity, "خطا در به‌روزرسانی SeekBar", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                }
            }
            handler.post(updateSeekBarRunnable)

        } catch (e: Exception) {
            Toast.makeText(this, "خطا در بارگذاری داستان یا منابع صوتی", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun playAudio() {
        try {
            mediaPlayer?.start()
            isPlaying = true
            binding?.btnPlay?.setImageResource(R.drawable.pause)
        } catch (e: Exception) {
            Toast.makeText(this, "خطا در پخش فایل صوتی", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun pauseAudio() {
        try {
            mediaPlayer?.pause()
            isPlaying = false
            binding?.btnPlay?.setImageResource(R.drawable.play)
        } catch (e: Exception) {
            Toast.makeText(this, "خطا در توقف فایل صوتی", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun updateCurrentTimeText(currentPosition: Int) {
        try {
            val minutes = TimeUnit.MILLISECONDS.toMinutes(currentPosition.toLong())
            val seconds = TimeUnit.MILLISECONDS.toSeconds(currentPosition.toLong()) % 60
            binding?.tvCurrentTime?.text = String.format("%02d:%02d", minutes, seconds)
        } catch (e: Exception) {
            Toast.makeText(this, "خطا در به‌روزرسانی زمان پخش", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    private fun updateTotalTimeText(duration: Int) {
        try {
            val minutes = TimeUnit.MILLISECONDS.toMinutes(duration.toLong())
            val seconds = TimeUnit.MILLISECONDS.toSeconds(duration.toLong()) % 60
            binding?.tvTotalTime?.text = String.format("%02d:%02d", minutes, seconds)
        } catch (e: Exception) {
            Toast.makeText(this, "خطا در به‌روزرسانی زمان کل", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

}