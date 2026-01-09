package com.example.questionbank

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text

class DBMS_Q2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dbms_q2)

        val backBtn = findViewById<MaterialButton>(R.id.backBtn)

        backBtn.setOnClickListener {
            finish()
        }

        val checkBox1 = findViewById<CheckBox>(R.id.optn1)
        val checkBox2 = findViewById<CheckBox>(R.id.optn2)
        val checkBox3 = findViewById<CheckBox>(R.id.optn3)
        val checkBox4 = findViewById<CheckBox>(R.id.optn4)

        val themeTextColor = checkBox1.currentTextColor

        val optn1 = findViewById<TextView>(R.id.optn1Text)
        val optn2 = findViewById<TextView>(R.id.optn2Text)
        val optn3 = findViewById<TextView>(R.id.optn3Text)
        val optn4 = findViewById<TextView>(R.id.optn4Text)

        val explanationHeading = findViewById<TextView>(R.id.explanationHeading)
        val explanationText = findViewById<TextView>(R.id.explanationText)
        val previousBtn = findViewById<MaterialButton>(R.id.previousBtn)
        val sbmtBtn = findViewById<MaterialButton>(R.id.submitBtn)
        val bookmarkBtn = findViewById<MaterialButton>(R.id.bookmarkButton)

        val sharedPrefDbms2 = getSharedPreferences("bookmarkdbms2",MODE_PRIVATE)
        val editor = sharedPrefDbms2.edit()

        var isBookmarked = sharedPrefDbms2.contains("dbms2")

        if (isBookmarked){
            bookmarkBtn.setIconResource(R.drawable.baseline_bookmark_24)
        }
        else{
            bookmarkBtn.setIconResource(R.drawable.outline_bookmark_24)
        }

        bookmarkBtn.setOnClickListener {
            isBookmarked = !isBookmarked

            if (isBookmarked){
                bookmarkBtn.setIconResource(R.drawable.baseline_bookmark_24)
                Toast.makeText(this,"Question Bookmarked Successfully",Toast.LENGTH_SHORT).show()

                editor.putString("dbms2","Q.2")
                editor.apply()
            }
            else{
                bookmarkBtn.setIconResource(R.drawable.outline_bookmark_24)

                editor.remove("dbms2")
                editor.apply()
            }
        }

        previousBtn.setOnClickListener {
            finish()
        }

        fun resetState(){
            optn1.text = ""
            optn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            checkBox1.setTextColor(themeTextColor)
            optn2.text = ""
            optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            checkBox2.setTextColor(themeTextColor)
            optn3.text = ""
            optn3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            checkBox3.setTextColor(themeTextColor)
            optn4.text = ""
            optn4.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            checkBox4.setTextColor(themeTextColor)

            explanationHeading.text = ""
            explanationText.text = ""
        }

        checkBox1.setOnCheckedChangeListener { _,_ -> resetState() }
        checkBox2.setOnCheckedChangeListener { _,_ -> resetState() }
        checkBox3.setOnCheckedChangeListener { _,_ -> resetState() }
        checkBox4.setOnCheckedChangeListener { _,_ -> resetState() }

        sbmtBtn.setOnClickListener {

            if (!(checkBox1.isChecked || checkBox2.isChecked || checkBox3.isChecked || checkBox4.isChecked)){
                Toast.makeText(this,"Please select an option",Toast.LENGTH_SHORT).show()
                optn1.text = ""
                optn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                checkBox1.setTextColor(themeTextColor)
                optn2.text = ""
                optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                checkBox2.setTextColor(themeTextColor)
                optn3.text = ""
                optn3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                checkBox3.setTextColor(themeTextColor)
                optn4.text = ""
                optn4.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                checkBox4.setTextColor(themeTextColor)

                explanationHeading.text = ""
                explanationText.text = ""
            }
            else{
                if (checkBox2.isChecked && checkBox3.isChecked){
                    optn2.text = "Wrong"
                    checkBox2.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn2.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_cancel_red,0,0,0)
                    optn3.text = "Wrong"
                    checkBox3.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn3.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_cancel_red,0,0,0)
                }
                else if (checkBox2.isChecked){
                    optn2.text = "Wrong"
                    checkBox2.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn2.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_cancel_red,0,0,0)
                    optn3.text = ""
                    optn3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                    checkBox3.setTextColor(themeTextColor)
                }
                else if (checkBox3.isChecked){
                    optn3.text = "Wrong"
                    checkBox3.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn3.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    optn3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_cancel_red,0,0,0)
                    optn2.text = ""
                    optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                    checkBox2.setTextColor(themeTextColor)
                }
                else{
                    optn2.text = ""
                    optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                    checkBox2.setTextColor(themeTextColor)
                    optn3.text = ""
                    optn3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                    checkBox3.setTextColor(themeTextColor)
                }
                optn1.text = "Correct"
                checkBox1.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                optn1.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                optn1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_check_circle_green,0,0,0)
                optn4.text = "Correct"
                checkBox4.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                optn4.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                optn4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_check_circle_green,0,0,0)

                explanationHeading.text = "Explanation :"
                explanationText.text = "A Primary Key is used to uniquely identify each record in a table.\n" +
                        "It must contain unique values and cannot be NULL.\n" +
                        "This ensures that every record can be identified without ambiguity."
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}