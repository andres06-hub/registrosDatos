package com.example.registrodatoscolegio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.registrodatoscolegio.Clases.Estudiante
import com.example.registrodatoscolegio.Clases.Materia


class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        var btnEnviar = findViewById<Button>(R.id.btnEnviar)
        btnEnviar.setOnClickListener { onclick() }


    }

    private fun onclick() {

    }

    private fun iniciar() {
        //obtenemos los datos
        getData()

    }



    // Se obtiene los datos ingresadops por el usuario
    private fun getData(){
        /**
         * Obtenemos datos personales
         * */
        var document : String = findViewById<EditText>(R.id.txtDocument).text.toString()
        var name : String = findViewById<EditText>(R.id.txtName).text.toString()
        var txtAge : String = findViewById<EditText>(R.id.txtAge).text.toString()
        var phoneNumber : String = findViewById<EditText>(R.id.txtPhoneNumber).text.toString()
        var direction : String = findViewById<EditText>(R.id.txtDirection).text.toString()
        /**
         * Obtenemos los datos de las materias
         * */
        var nameMatter : String = findViewById<EditText>(R.id.txtNameMatter).text.toString()
        var valueMatter : String =findViewById<EditText>(R.id.txtValue).text.toString()

        // se crea mapa
        var data : HashMap<String, String> = HashMap()
        //Pasamos los valores
        data.put("document", document)
        data.put("name", name)
        data.put("txtAge", txtAge)
        data.put("phoneNumber", phoneNumber)
        data.put("direction", direction)
        data.put("nameMatter", nameMatter)
        data.put("valueMatter", valueMatter)

        //llamamos la funcion y le pasamos el mapa
        createStudent(data)
    }

    private fun createStudent(data : HashMap<String, String>){
        //Pasamos los datos obtenidos del mapa

        //Creamos el objeto estudiante
        var newEstudiante: Estudiante = Estudiante()
        // Se crea el objeto materia
        var materia : Materia = Materia()


        //Asignamos los datos al usuario creado
        newEstudiante.documento = data.get("document").toString()
        newEstudiante.nombre = data.get("name").toString()
        newEstudiante.phoneNumber = data.get("phoneNumber").toString()
        newEstudiante.direction = data.get("direction").toString()
        //obtenemos el valor de 'Age'
        var txtAge : String = data.get("txtAge").toString()
        //Hacemos casting
        var age = txtAge.toInt()
        //Validamos que la edad sea una edad valida
        if (age > 0 && age < 120){
            newEstudiante.edad=age
        }
        //Asignamos la mateira
        materia.nombre = data.get("nameMatter").toString()
        //Obtenemos el valor
        var valueMatter = data.get("valueMatter").toString()
        //Se hace casting al valor
        var value = valueMatter.toDouble()
        materia.nota = value
        //Agregamos la materia creada al la estructura (GUARDAMOS)
        newEstudiante.materias.add(materia)
        // se calcula el promedio de las materias ingresadas
        newEstudiante.calcularPromedio()

        // Guardamos el estudiante creado
        //saveStudent(newEstudiante)

        print(newEstudiante.toString())

        var txtView = findViewById<TextView>(R.id.txtView)
        txtView.text = newEstudiante.toString()
    }
}