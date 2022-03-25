package com.example.registrodatoscolegio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Una ves llegue al splash
        startActivity(Intent(this, MainActivity::class.java))

    }
}