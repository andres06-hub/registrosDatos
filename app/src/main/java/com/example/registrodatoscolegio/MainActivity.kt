package com.example.registrodatoscolegio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.registrodatoscolegio.Clases.ContenedorMaterias
import com.example.registrodatoscolegio.Clases.Estudiante
import com.example.registrodatoscolegio.Clases.Materia

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ventana SIGN-UP
        var btnRegistrate = findViewById<Button>(R.id.btnRegistrate)
        btnRegistrate.setOnClickListener{
            //decimos a donde se va a ir
            val registrar : Intent = Intent(this, RegistroActivity::class.java)
            //Iniciamos la actividad
            startActivity(registrar)
        }

        // Ventana Statitics
        var btnStatitics = findViewById<Button>(R.id.btnStatitics)
        btnStatitics.setOnClickListener{
            //Indicamos a dode ira
            val statitics:Intent = Intent(this, StatisticsActivity::class.java)
            //Iniciamos la actividad
            startActivity(statitics)
        }

    }




}