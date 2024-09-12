package com.example.kid_storyapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // دریافت لیست داستان‌ها از کلاس Constants
        val data = Constants.getStoryList()
        setAdapterRecyclerView(data)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    /**
     * این تابع آداپتور مربوط به RecyclerView را تنظیم می‌کند و یک لیست از داستان‌ها به آن می‌دهد.
     * همچنین، رویداد کلیک روی هر داستان را مدیریت می‌کند تا کاربر را به StoryActivity هدایت کند.
     */
    private fun setAdapterRecyclerView(data:ArrayList<Story>)
    {
        val recyclerView = findViewById<RecyclerView>(R.id.rvStoryList)
        recyclerView.layoutManager = LinearLayoutManager(this  )
        val adapter = StoryAdapter(data)
        recyclerView.adapter = adapter

        //open story activity when clicked + sending the position of story
        adapter.setOnClickListener(object : StoryAdapter.OnClickListener{
            override fun onClick(position: Int) {
                val intent = Intent(this@MainActivity,StoryActivity::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
                println("position is:"+ position)

            }

        })
    }
}