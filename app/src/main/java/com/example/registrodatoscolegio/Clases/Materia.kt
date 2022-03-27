package com.example.registrodatoscolegio.Clases

class Materia {

    /**
     * Clase para definir la materia lo que tiene una materia
     * Atributos
     *
     * */
    // Encapsulación
    var nombre : String = ""
        get() = field
        set(value){
            field = value
        }
    var nota : Double = 0.0
        get() = field
        set(value) {
            // Si se cumple
            if (value > 0.0 && value < 5.0){
                // Se asigan el valor
                field = value
            }
            field = 0.0
        }
}