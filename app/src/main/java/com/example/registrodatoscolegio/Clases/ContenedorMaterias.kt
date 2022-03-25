package com.example.registrodatoscolegio.Clases

interface ContenedorMaterias {

    /**
     * Se crea una interface para decir que DEBE de tener
     * */
    //-----------------------------
    var materias : ArrayList<Materia>
    fun calcularPromedio(): Double
}