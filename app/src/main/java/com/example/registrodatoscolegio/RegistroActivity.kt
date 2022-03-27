package com.example.registrodatoscolegio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.registrodatoscolegio.Clases.Estudiante
import com.example.registrodatoscolegio.Clases.Materia
import com.example.registrodatoscolegio.Models.Model


class RegistroActivity : AppCompatActivity() {

    //Lista de estudiantes
    var lista : MutableList<Estudiante> = mutableListOf()

    /**
     * Se declara la clase model para la estructura de datos del aplicativo
     * */

    var model : Model? = null
    var miBundle:Bundle?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        var btnEnviar = findViewById<Button>(R.id.btnEnviar)
        btnEnviar.setOnClickListener { onclick() }

        iniciarComponentes()

        miBundle=this.intent.extras
        model

    }

    private fun iniciarComponentes(){

        model = Model()
    }

    private fun onclick() {
        iniciar()

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

        //////////////////////////////////////////////////////////
        // Se crean las MATERIAS
        var materia1 : Materia = Materia()
        var materia2 : Materia = Materia()
        var materia3 : Materia = Materia()
        var materia4 : Materia = Materia()
        var materia5 : Materia = Materia()
        /////////////////////////////////////////////////////////

        //Asignamos los datos al usuario creado
        newEstudiante.document = data.get("document").toString()
        newEstudiante.name = data.get("name").toString()
        newEstudiante.phoneNumber = data.get("phoneNumber").toString()
        newEstudiante.direction = data.get("direction").toString()
        //obtenemos el valor de 'Age'
        var txtAge : String = data.get("txtAge").toString()
        //Hacemos casting
        var age = txtAge.toInt()

        //Validamos que la edad sea una edad valida
        if (!(age > 0 && age < 120)){
            //Hubo un error
                //Dato incorrecto
        }

        newEstudiante.age=age

        /**
         * Asignamos las materias
         * */
        // == NOMBRES
        materia1.nombre = data.get("nameMatter").toString()
        materia2.nombre = ""
        materia3.nombre = ""
        materia4.nombre = ""
        materia5.nombre = ""


        //Obtenemos el valor
        var valueMatter1 = data.get("valueMatter").toString()
        //Se hace casting al valor
        var value = valueMatter1.toDouble()

        // VAlidamos que la notas este en este rango
        if (!(value >= 0 && value <= 5.0)){
            //HUbo un error
                //Dato incorrecto
            //return "Error"
        }
        materia1.nota = value
        //Agregamos la materia creada al la estructura (GUARDAMOS)
        newEstudiante.materias.add(materia1)
        // se calcula el promedio de las materias ingresadas
        newEstudiante.calcularPromedio()

        // Guardamos el estudiante creado
        //saveStudent(newEstudiante)

        lista.add(newEstudiante)

        println("Datos :: " + lista)
        println("Cantidad registros = " + lista.size)

        //print(newEstudiante.toString())
    }
}