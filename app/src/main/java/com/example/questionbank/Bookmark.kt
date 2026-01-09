package com.example.questionbank

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class Bookmark : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bookmark)

        val backBtn = findViewById<MaterialButton>(R.id.backBtn)

        backBtn.setOnClickListener {
            finish()
        }

        val dbms1 = findViewById<TextView>(R.id.dbms1)
        val dbms2 = findViewById<TextView>(R.id.dbms2)
        val noBookmark = findViewById<TextView>(R.id.noBookmark)

        val sharedPrefDbms1 = getSharedPreferences("bookmarkdbms1",MODE_PRIVATE)
        val sharedPrefDbms2 = getSharedPreferences("bookmarkdbms2",MODE_PRIVATE)

        val dbmsq1 = sharedPrefDbms1.contains("dbms1")
        val dbmsq2 = sharedPrefDbms2.contains("dbms2")

        if (dbmsq1 && dbmsq2){
            val bookmarkdbmsq1 = sharedPrefDbms1.getString("dbms1",null) ?: "No Bookmark"
            val bookmarkdbmsq2 = sharedPrefDbms2.getString("dbms2",null) ?: "No Bookmark"
            dbms1.text = bookmarkdbmsq1
            dbms2.text = bookmarkdbmsq2
        }
        else if (dbmsq1){
            val bookmarkdbmsq1 = sharedPrefDbms1.getString("dbms1",null) ?: "No Bookmark"
            dbms1.text = bookmarkdbmsq1
        }
        else if (dbmsq2){
            val bookmarkdbmsq2 = sharedPrefDbms2.getString("dbms2",null) ?: "No Bookmark"
            dbms1.text = bookmarkdbmsq2
        }
        if (dbms1.text=="" && dbms2.text==""){
            noBookmark.text = "No Bookmarks Yet"
        }

        val cttp1 = findViewById<TextView>(R.id.cttp1)
        val cttp2 = findViewById<TextView>(R.id.cttp2)
        val noBookmark1 = findViewById<TextView>(R.id.noBookmark1)

        val sharedPrefCttp1 = getSharedPreferences("bookmarkcttp1",MODE_PRIVATE)
        val sharedPrefCttp2 = getSharedPreferences("bookmarkcttp2",MODE_PRIVATE)

        val cttpq1 = sharedPrefCttp1.contains("cttp1")
        val cttpq2 = sharedPrefCttp2.contains("cttp2")

        if (cttpq1 && cttpq2){
            val bookmarkcttpq1 = sharedPrefCttp1.getString("cttp1",null) ?: "No Bookmark"
            val bookmarkcttpq2 = sharedPrefCttp2.getString("cttp2",null) ?: "No Bookmark"
            cttp1.text = bookmarkcttpq1
            cttp2.text = bookmarkcttpq2
        }
        else if (cttpq1){
            val bookmarkcttpq1 = sharedPrefCttp1.getString("cttp1",null) ?: "No Bookmark"
            cttp1.text = bookmarkcttpq1
        }
        else if (cttpq2){
            val bookmarkcttpq2 = sharedPrefCttp2.getString("cttp2",null) ?: "No Bookmark"
            cttp1.text = bookmarkcttpq2
        }
        if (cttp1.text=="" && cttp2.text==""){
            noBookmark1.text = "No Bookmarks Yet"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}