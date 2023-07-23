package com.example.movebetweenactivities

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

fun Context.showStackInfo(): String {
    val task = (getSystemService(AppCompatActivity.ACTIVITY_SERVICE) as ActivityManager)
        .getRunningTasks(10).filter {
            it.baseActivity!!.flattenToString().startsWith("com.example.movebetweenactivities")
        }[0]
    return """Num -> ${task.numActivities}
            | Top -> ${task.topActivity!!.shortClassName}
            | Bas -> ${task.topActivity!!.shortClassName}""".trimMargin()
}