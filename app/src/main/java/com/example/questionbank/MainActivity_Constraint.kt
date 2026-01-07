package com.example.questionbank

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity_Constraint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_constraint)

        val sharedPref = getSharedPreferences("userdata",MODE_PRIVATE)
        val fullName = sharedPref.getString("name","N/A") ?: ""

        val wlcmTxt = findViewById<TextView>(R.id.wlcmTxt)
        val profileBtn = findViewById<MaterialButton>(R.id.profileButton)
        val dbmsBtn = findViewById<MaterialButton>(R.id.dbmsBtn)
        val cttpBtn = findViewById<MaterialButton>(R.id.cttpBtn)

        val firstName = fullName.substringBefore(" ")
        wlcmTxt.text = "Welcome\n$firstName"

        profileBtn.setOnClickListener {
            val intent = Intent(this, Profile_Page::class.java)
            startActivity(intent)
        }

        dbmsBtn.setOnClickListener {
            val intent = Intent(this, DBMS_Q1::class.java)
            startActivity(intent)
        }

        cttpBtn.setOnClickListener {
            val intent = Intent(this, CTTP_Q1::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}