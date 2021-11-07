package com.example.applicationlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d("Elisha", "onCreate in MainActivity ${this.isChangingConfigurations}")
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}