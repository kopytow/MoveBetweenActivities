package com.example.movebetweenactivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class C : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = intent.getStringExtra(B.KEY_B_CLASS) ?: ""
        setListeners(data)
    }

    private fun setListeners(data: String) {
        findViewById<TextView>(R.id.title).text = data.plus(" -> ${this::class.simpleName}")
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, B::class.java)
            intent.putExtra(B.KEY_B_CLASS, "screen C")
            startActivity(intent)
        }
        findViewById<TextView>(R.id.path).text = showStackInfo()
    }

}