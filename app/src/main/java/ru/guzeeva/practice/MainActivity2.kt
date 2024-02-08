package ru.guzeeva.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private lateinit var nameResult: TextView
    private lateinit var ageResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2)

        nameResult = findViewById(R.id.name_result)
        ageResult = findViewById(R.id.age_result)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val receivedGender = intent.getStringExtra("gender")

        nameResult.text = name
        ageResult.text = age

        val gender = findViewById<TextView>(R.id.gender_result)
        gender.text = receivedGender

        val backgroundButton = findViewById<Button>(R.id.background)

        backgroundButton.setOnClickListener {
            val randomColor = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            findViewById<View>(android.R.id.content).setBackgroundColor(randomColor)
        }
    }
}