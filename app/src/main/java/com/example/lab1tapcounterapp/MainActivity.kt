package com.example.lab1tapcounterapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var tapCount = 0
    private lateinit var tapCountTextView: TextView
    private lateinit var tapButton: Button
    private lateinit var exchangeButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapCountTextView = findViewById(R.id.tapCountTextView)
        tapButton = findViewById(R.id.tapButton)
        exchangeButton = findViewById(R.id.exchangeButton)
        resetButton = findViewById(R.id.resetButton)

        tapButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                incrementTapCount(1) // Increment tap count by 1
            }
        })

        exchangeButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                exchangeTapsForUpgrade()
            }
        })

        resetButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                resetTapCount()
            }
        })
    }

    private fun incrementTapCount(increment: Int) {
        tapCount += increment
        tapCountTextView.text = "Taps: $tapCount"
    }

    private fun exchangeTapsForUpgrade() {
        val upgradeCost = 100
        if (tapCount >= upgradeCost) {
            // Deduct the cost of the upgrade
            tapCount -= upgradeCost
            // Double the taps
            incrementTapCount(upgradeCost * 2)
            // Update the UI
            tapCountTextView.text = "Taps: $tapCount"
        } else {
            // Notify the user that they don't have enough taps
            tapCountTextView.text = "Not enough taps for the upgrade!"
        }
    }

    private fun resetTapCount() {
        tapCount = 0
        tapCountTextView.text = "Effects on door: $tapCount"
    }
}

