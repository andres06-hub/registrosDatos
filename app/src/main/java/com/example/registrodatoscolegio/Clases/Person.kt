package com.example.registrodatoscolegio.Clases

import java.io.Serializable

/**
 * Para aplicar Herencia seria, en este caso esta es la clase que va a heredar
 * open -> Es la palabra reservada para indicar que no es una clase final, por defecto las clases son finales
 * Ya que la una clase con solo 'class' es una clase final
 * */
open class Person : Serializable{
    // Se inicializan
    var document : String = ""
        get() = field
        set(value) {
            field = value
        }
    var name : String = ""
        get() = field
        set(value) {
            field = value
        }
    var age : Int = 0
        get() = field
        set(value) {
            // validamos si el dato ingresado cumpla
            if(value>=0){
                //Asignamos valor
                field = value
            }
        }
    /**
     * Metodos Set y Get para trabajar
     * con las variables
     * */

    //Constructor explicito
    constructor(documento: String, nombre:String) {
        //Se asigna el documento y edad
        this.document = documento
        this.name = nombre
    }






}