package com.example.movebetweenactivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class A : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

        val prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        prefs.edit()
            .putString(SHARED_DATA_LABEL, SHARED_DATA)
            .apply()
    }

    private fun setListeners() {
        findViewById<TextView>(R.id.title).text = this::class.simpleName
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, B::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.path).text = showStackInfo()
    }

    companion object {
        const val SHARED_DATA_LABEL = "A-ACTIVITY"
        const val SHARED_DATA = "screen A"
        const val APP_PREFERENCES = "TestPreferences"
    }
}
