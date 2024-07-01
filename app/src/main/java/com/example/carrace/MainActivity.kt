package com.example.carrace

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val raceButton = findViewById<Button>(R.id.raceButton)
        var resultsTextView = findViewById<TextView>(R.id.resultTextView)

        raceButton.setOnClickListener {
            val numberOfCars = editTextNumber.text.toString().toIntOrNull()
            if (numberOfCars != null) {
                val automobiles = List(numberOfCars) { createRandomAutomobile() }
                organizeRaces(automobiles, resultsTextView)
            }
        }
    }
}