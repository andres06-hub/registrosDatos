package com.example.registrodatoscolegio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Iniciamos
        iniciar()
    }

    private fun iniciar(){
        //Creamos el objeto
        var persona1:Persona =Persona()

        //datos
        var documento:String = "001"
        var nombre:String = "Andres"
        var edad:Int = 5

        persona1.documento="001"
        persona1.nombre="Andres"

        if (edad > 0){
            persona1.edad=edad
        }
        print(persona1.toString())
        var txtView = findViewById<TextView>(R.id.txtView)
        txtView.text = persona1.toString()

    }
}