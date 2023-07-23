package com.example.twoactivities

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.twoactivities.databinding.ActivityMainBinding
import com.example.twoactivities.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("message_key").let {
            binding.secondTextView.text = it
        }

        binding.replyButton.setOnClickListener {
            val replyIntent = Intent(this, MainActivity::class.java)
            val reply = binding.replyEditText.text.toString()
            replyIntent.putExtra("reply_key", reply)
            setResult(RESULT_OK, replyIntent);
            finish();
            try {
                startActivity(replyIntent)
            } catch (e: ActivityNotFoundException) {
                Log.d("TAG", "Can't go back to Main screen")
            }
        }
    }
}