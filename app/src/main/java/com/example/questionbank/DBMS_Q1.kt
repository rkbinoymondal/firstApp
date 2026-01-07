package com.example.questionbank

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text

class DBMS_Q1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dbms_q1)

        val backBtn = findViewById<MaterialButton>(R.id.backBtn)

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity_Constraint::class.java)
            startActivity(intent)
        }

        val radGrp = findViewById<RadioGroup>(R.id.radioGroup)

        val radBtn1 = findViewById<RadioButton>(R.id.optn1)
        val radBtn2 = findViewById<RadioButton>(R.id.optn2)
        val radBtn3 = findViewById<RadioButton>(R.id.optn3)
        val radBtn4 = findViewById<RadioButton>(R.id.optn4)

        val themeTextColor = radBtn1.currentTextColor

        val optn1 = findViewById<TextView>(R.id.optn1Text)
        val optn2 = findViewById<TextView>(R.id.optn2Text)
        val optn3 = findViewById<TextView>(R.id.optn3Text)
        val optn4 = findViewById<TextView>(R.id.optn4Text)

        val explanationHeading = findViewById<TextView>(R.id.explanationHeading)
        val explanationText = findViewById<TextView>(R.id.explanationText)
        val nextBtn = findViewById<MaterialButton>(R.id.nextBtn)
        val sbmtBtn = findViewById<MaterialButton>(R.id.submitBtn)

        nextBtn.setOnClickListener {
            val intent = Intent(this, DBMS_Q2::class.java)
            startActivity(intent)
        }

        fun resetState(){

            optn1.text = ""
            optn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            radBtn1.setTextColor(themeTextColor)
            optn4.text = ""
            optn4.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            radBtn4.setTextColor(themeTextColor)
            optn2.text = ""
            optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            radBtn2.setTextColor(themeTextColor)
            optn3.text = ""
            optn3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            radBtn3.setTextColor(themeTextColor)
            explanationHeading.text = ""
            explanationText.text = ""
        }

        radGrp.setOnCheckedChangeListener { _,_ -> resetState() }

        sbmtBtn.setOnClickListener {
            val selectedId = radGrp.checkedRadioButtonId

            if (selectedId==-1){
                Toast.makeText(this,"Please select an option",Toast.LENGTH_LONG).show()
            }
            else{
                if (radBtn3.isChecked){
                    optn1.text = ""
                    optn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                    radBtn1.setTextColor(themeTextColor)
                    optn4.text = ""
                    optn4.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                    radBtn4.setTextColor(themeTextColor)
                    optn2.text = ""
                    optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                    radBtn2.setTextColor(themeTextColor)
                    optn3.text = "Correct"
                    radBtn3.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                    optn3.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                    optn3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_check_circle_green,0,0,0)
                    explanationHeading.text = ""
                    explanationText.text = ""
                }
                else{
                    if (radBtn1.isChecked){
                        optn2.text = ""
                        optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                        radBtn2.setTextColor(themeTextColor)
                        optn4.text = ""
                        optn4.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                        radBtn4.setTextColor(themeTextColor)
                        optn1.text = "Wrong"
                        optn1.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                        optn1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_cancel_red,0,0,0)
                        radBtn1.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                        optn1.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    }
                    else if (radBtn2.isChecked){
                        optn1.text = ""
                        optn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                        radBtn1.setTextColor(themeTextColor)
                        optn4.text = ""
                        optn4.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                        radBtn4.setTextColor(themeTextColor)
                        optn2.text = "Wrong"
                        optn2.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                        optn2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_cancel_red,0,0,0)
                        radBtn2.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                        optn2.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    }
                    else{
                        optn1.text = ""
                        optn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                        radBtn1.setTextColor(themeTextColor)
                        optn2.text = ""
                        optn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                        radBtn2.setTextColor(themeTextColor)
                        optn4.text = "Wrong"
                        optn4.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                        optn4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_cancel_red,0,0,0)
                        radBtn4.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                        optn4.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    }
                    optn3.text = "Correct"
                    radBtn3.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                    optn3.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                    optn3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_check_circle_green,0,0,0)
                }

                explanationHeading.text = "Explanation :"
                explanationText.text = "A Primary Key is used to uniquely identify each record (row) in a table.\n" +
                        "It ensures that no two records have the same value and no value is NULL.\n" +
                        "\n" +
                        "Because of this, the primary key helps maintain data integrity and allows records to be accessed or referenced easily."
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}