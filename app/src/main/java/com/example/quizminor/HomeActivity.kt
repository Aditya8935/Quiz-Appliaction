package com.example.quizminor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeButton = findViewById<Button>(R.id.home_btn)
        homeButton.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        if (view.id == R.id.home_btn) {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}
