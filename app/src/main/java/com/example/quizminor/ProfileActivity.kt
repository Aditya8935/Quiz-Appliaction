package com.example.quizminor

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val logoutTextView: TextView = findViewById(R.id.logout_btn)
        logoutTextView.setOnClickListener {
            val intent = Intent(this@ProfileActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        val quizzesTextView: TextView = findViewById(R.id.quiz_btn)
        quizzesTextView.setOnClickListener {
            val intent = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val aboutusTextView: TextView = findViewById(R.id.abtus_btn)
        aboutusTextView.setOnClickListener {
            val intent = Intent(this@ProfileActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        val acklTextView: TextView = findViewById(R.id.ackl_btn)
        acklTextView.setOnClickListener {
            val intent = Intent(this@ProfileActivity, AcknowlegementActivity::class.java)
            startActivity(intent)
        }

        val aboutMitaoeTextView: TextView = findViewById(R.id.aboutmitaoe_btn)
        aboutMitaoeTextView.setOnClickListener {
            val intent = Intent(this@ProfileActivity, AboutMitaoeActivity::class.java)
            startActivity(intent)
        }

        val referenceBookTextView: TextView = findViewById(R.id.ref_btn)
        referenceBookTextView.setOnClickListener {
            val intent = Intent(this@ProfileActivity, ReferenceBookActivity::class.java)
            startActivity(intent)
        }
    }
}
