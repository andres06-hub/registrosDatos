package com.example.registrodatoscolegio.Models

import com.example.registrodatoscolegio.Clases.Estudiante
import java.io.Serializable

class Model : Serializable{
    // Clase encargada de almacenar el onjeto estudiante

    var listStudent : MutableList<Estudiante> = mutableListOf()

    //Obtener studiante creado y guardarlo
    fun saveStudent(student : Estudiante) : Boolean{

        if ((listStudent.size > 0)){
            //PAsamos por cada objeto guardado en la lista
            for ( user in listStudent){
                //Verificamos si el estudiante existe
                if (!(student.document.equals(user.document))){
                    //User not exists!
                    //Como es con negación, entonces se asigna proque el user no existe
                    // Lo guardamos
                    listStudent.add(student)
                    return true
                }
                //User exists!
                return false
            }
        }
        listStudent.add(student)
        return true
    }

    // funcion encargada de mostrarme los estudiantes registrados
    fun getEstudiantes() : String{
        // Creamos una cadena
        var cadena : String = ""
        //Validamos que la lista contenga datos
        if (listStudent.size > 0){
            //Pasamos por cada objeto registrado
            for (student in listStudent){

                cadena += "Document: " + student.document + "\n"
                cadena += "Name: " + student.name + "\n"
                cadena += "Age: " + student.age + "\n"
                cadena += "Phone Number: " + student.phoneNumber + "\n"
                cadena += "Direction: " + student.direction + "\n"
            }
        }
        return cadena
    }

    //Funcion encargada de obtenerme UN SOLO estudiante en ESPECIFICO
    fun getEstudiante(document : String) : String{

        //Se crea una cadena
        var cadena : String = ""

        //Validamos que estado esta la lista
        if(listStudent.size > 0){
            //Validamos si el documento del estudiante NO esta vacio
            if(document.length > 0){
                //Si se cumple
                //Se pasa por cada objeto validando
                for (student in listStudent){
                    //Se valida si el documento es valido, es igual
                    if (document.equals(student.document)){

                        //Si el docuemento se obtiene
                        //se muestra
                        cadena += "Document: " + student.document + "\n"
                        cadena += "Name: " + student.name + "\n"
                        cadena += "Age: " + student.age + "\n"
                        cadena += "Phone Number: " + student.phoneNumber + "\n"
                        cadena += "Direction: " + student.direction + "\n"
                        //rompemos el ciclo cuando encuentre al paciente
                        break
                    }
                }
                //Si la cadena es difente de vacia, entonces se retorna
                if(!cadena.equals("")){
                    return cadena
                }else{
                    return "Paciente NO existe"
                }
            }
            return "Por favor ingrese un dato!"
        }
        return "No hay pacientes Registrados!"
    }

    //Cantidad de Estudiantes registrados
    fun studentsRegisters() : Int{
        return listStudent.size
    }

}