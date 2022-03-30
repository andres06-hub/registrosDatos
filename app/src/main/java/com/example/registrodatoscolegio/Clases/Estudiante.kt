package com.example.registrodatoscolegio.Clases

import java.io.Serializable

class Estudiante : Person(documento = "", nombre = ""), ContenedorMaterias , Serializable{

    /**
     * Clase de estudiante que contendra la HERENCIA de 'Persona'
     * Interface de 'ContenedorMaterias' -> Que le asignamos como lo hara, pero ya sabemos que debe de tener
     * */

    var phoneNumber : String = ""
        get() = field
        set(value) {
            field = value
        }
    var direction : String = ""
        get() = field
        set(value) {
            field = value
        }


    override var materias : ArrayList<Materia> = ArrayList()

    override fun calcularPromedio() : Double {
        var suma:Double = 0.0
        for(materia in materias){
            //Se van sumando
            suma = suma + materia.nota
            println("Sumando nota: " + materia.nota)
        }
        //Sacamos el promedio
        var promedio : Double = suma / materias.size
        //println("PROMEDIO :: " + promedio)
        return promedio

    }

    override fun toString(): String {
        return "Estudiante(documento='$document', nombre='$name', edad=$age, phoneNumber='$phoneNumber', direction='$direction')"
    }


}