package com.example.questionbank

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler

class Splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("userdata",MODE_PRIVATE)
            val name = sharedPref.getString("name",null)

            if (name.isNullOrEmpty()){
                val intent = Intent(this, Login_Page::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, MainActivity_Constraint::class.java)
                startActivity(intent)
            }
            finish()
        },0)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}