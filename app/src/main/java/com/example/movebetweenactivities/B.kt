package com.example.movebetweenactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class B : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }

    private fun setListeners() {
        findViewById<TextView>(R.id.title).text = this::class.simpleName
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, C::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.path).text = showStackInfo()
    }
}
