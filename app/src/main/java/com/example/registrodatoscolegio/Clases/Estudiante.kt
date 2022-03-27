package com.example.registrodatoscolegio.Clases

class Estudiante : Persona(documento = "", nombre = ""), ContenedorMaterias {

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

    override fun calcularPromedio(): Double {
        return 0.0
    }

}