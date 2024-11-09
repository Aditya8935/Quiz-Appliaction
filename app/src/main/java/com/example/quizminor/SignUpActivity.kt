package com.example.quizminor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.quizminor.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var userName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase . auth

        database = Firebase.database.reference

        binding.loginredirect.setOnClickListener {
            val intent = Intent(this@SignUpActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.signUpBtn.setOnClickListener {
            userName = binding.signUpName.text.toString().trim()
            email = binding.signUpEmail.text.toString().trim()
            password = binding.signUpPassword.text.toString().trim()

            if (userName.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please Fill All the Details", Toast.LENGTH_SHORT).show()
            } else {
                createAccount(email, password)
            }
        }


    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                saveUserData()
                val intent = Intent(this@SignUpActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show()
                Log.d("Account", "createAccount: Failure", task.exception)
            }
        }
    }


    private fun saveUserData() {
        userName = binding.signUpName.text.toString().trim()
        email = binding.signUpEmail.text.toString().trim()
        password = binding.signUpPassword.text.toString().trim()

        val user = UserInformation(userName, email, password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("user").child(userId).setValue(user)


    }
}