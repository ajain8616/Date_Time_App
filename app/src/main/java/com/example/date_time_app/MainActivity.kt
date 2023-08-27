package com.example.date_time_app

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dateTextView: TextView
    private lateinit var timeTextView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateTextView = findViewById(R.id.dateTextView)
        timeTextView = findViewById(R.id.timeTextView)
        imageView = findViewById(R.id.imageView)

        // Update date and time every second
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                updateDateTime()
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun updateDateTime() {
        val dateFormat = SimpleDateFormat("EEE,d-MMM-yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())

        val currentDate = dateFormat.format(Date())
        val currentTime = timeFormat.format(Date())

        dateTextView.text = currentDate
        timeTextView.text = currentTime

        val amPm = currentTime.substring(currentTime.length - 2)

        if (amPm == "AM") {
            imageView.setImageResource(R.drawable.day_image)
        } else {
            imageView.setImageResource(R.drawable.night_image)
        }
    }
}
