package com.example.questionbank

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text

class Profile_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_page)

        val sharedPref = getSharedPreferences("userdata",MODE_PRIVATE)
        val name = sharedPref.getString("name",null) ?: "Not Found"
        val email = sharedPref.getString("email",null) ?: "Not Found"
        val phone = sharedPref.getString("phone",null) ?: "Not Found"
        val age = sharedPref.getString("age",null) ?: "Not Found"
        val state = sharedPref.getString("state",null) ?: "Not Found"

        val nameText = findViewById<TextView>(R.id.nameText)
        val emailText = findViewById<TextView>(R.id.emailText)
        val phoneText = findViewById<TextView>(R.id.phoneText)
        val ageText = findViewById<TextView>(R.id.ageText)
        val stateText = findViewById<TextView>(R.id.stateText)
        val backBtn = findViewById<MaterialButton>(R.id.backBtn)

        nameText.text = name
        emailText.text = email
        phoneText.text = phone
        ageText.text = age
        stateText.text = state

        backBtn.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}