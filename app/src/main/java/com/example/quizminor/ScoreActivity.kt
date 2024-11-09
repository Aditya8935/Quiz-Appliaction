package com.example.quizminor

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.quizminor.databinding.ActivityScoreBinding

// ScoreActivity.kt

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("SCORE", 0)
        binding.scoreSubtitle.text = "Your Score: $score"

        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)
        val percentage = (score.toFloat() / totalQuestions.toFloat() * 100).toInt()

        binding.scoreProgressIndicator.progress = percentage
        binding.scoreProgressText.text = "$percentage %"

        if (percentage >= 40) {
            binding.resultText.text = "Congratulations! You Passed!"

        } else {
            binding.resultText.text = "Sorry! You Failed!"

        }

        binding.scoreSubtitle.text = "$score out of $totalQuestions are correct"

        binding.finishBtn.setOnClickListener {
            finish()
        }

        }
    }



