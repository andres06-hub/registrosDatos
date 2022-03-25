package com.example.registrodatoscolegio
/**
 * Para aplicar Herencia seria, en este caso esta es la clase que va a heredar
 * open -> Es la palabra reservada para indicar que no es una clase final,
 * Ya que la una clase con solo 'class' es una clase final
 * */
open class Persona() {
    // Se inicializan
    var documento : String = ""
        get() = field
        set(value) {
            field = value
        }
    var nombre : String = ""
        get() = field
        set(value) {
            field = value
        }
    var edad : Int = 0
        get() = field
        set(value) {
            // validamos si el dato ingresado cumpla
            if(value>=0){
                //Asignamos valor
                field = value
            }
        }

    //Constructor explicito
    constructor(documento: String, nombre:String) : this() {
        //Se asigna el documento y edad
        this.documento = documento
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Persona(documento='$documento', nombre='$nombre', edad=$edad)"
    }

    /**
     * Metodos Set y Get para trabajar
     * con las variables
     * */



}