package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf("None", "Top", "Bottom"))
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        positionSpinner.adapter = adapter

        Log.i("MainActivity", "onCreate Called")
    }
}
