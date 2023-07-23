package com.example.twoactivities

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.twoactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.sendButton.setOnClickListener {
            openSecondActivity()
        }

        intent.getStringExtra("reply_key").let {
            binding.mainTextView.text = it
        }
    }

    private fun openSecondActivity() {
        val secondActivityIntent = Intent(this, SecondActivity::class.java)
        val message = binding.mainEditText.text.toString()
        secondActivityIntent.putExtra("message_key", message)

        try {
            startActivity(secondActivityIntent)
        } catch (e: ActivityNotFoundException) {
            Log.d("TAG", "Can't open Second screen")
        }
    }
}