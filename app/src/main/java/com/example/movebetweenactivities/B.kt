package com.example.movebetweenactivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class B : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val strFromC = intent.getStringExtra(KEY_B_CLASS) ?: ""
        val data = strFromC.ifEmpty {
            val prefs = getSharedPreferences(A.APP_PREFERENCES, Context.MODE_PRIVATE)
            prefs.getString(A.SHARED_DATA_LABEL, "")!!
        }
        setListeners(data)
    }

    private fun setListeners(data: String?) {
        findViewById<TextView>(R.id.title).text = data!!.plus(" -> ${this::class.simpleName}")
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, C::class.java)
            intent.putExtra(KEY_B_CLASS, "screen B")
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.path).text = showStackInfo()
    }

    companion object {
        const val KEY_B_CLASS = "B::class"
    }
}
