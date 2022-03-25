package com.example.registrodatoscolegio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.registrodatoscolegio.Clases.ContenedorMaterias
import com.example.registrodatoscolegio.Clases.Estudiante
import com.example.registrodatoscolegio.Clases.Materia

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Iniciamos
        iniciar()
    }

    private fun iniciar() {
        //Creamos el objeto
        var newEstudiante: Estudiante = Estudiante()
        var materia : Materia = Materia()
        materia.nombre = "Mate"
        materia.nota = 5.0
        newEstudiante.materias.add(materia)
        newEstudiante.calcularPromedio()

        //datos
        var documento:String = "001"
        var nombre:String = "Andres"
        var edad:Int = 5

        newEstudiante.documento="001"
        newEstudiante.nombre="Andres"

        if (edad > 0){
            newEstudiante.edad=edad
        }
        print(newEstudiante.toString())
        var txtView = findViewById<TextView>(R.id.txtView)
        txtView.text = newEstudiante.toString()
    }


}