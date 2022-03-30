package com.example.registrodatoscolegio

//import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Thread.sleep(3000)
        Handler(Looper.getMainLooper()).postDelayed(
            {
            // Una vez llegue al splash
            startActivity(Intent(this, MainActivity::class.java))
            }, 4000)
    }
}