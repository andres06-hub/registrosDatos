package com.example.registrodatoscolegio

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registrodatoscolegio.Clases.Estudiante
import com.example.registrodatoscolegio.Clases.Materia
import com.example.registrodatoscolegio.Models.Model


class RegistroActivity : AppCompatActivity() {

    //Lista de estudiantes
    //var lista : MutableList<Estudiante> = mutableListOf()

    /**
     * Se declara la clase model para la estructura de datos del aplicativo
     * */

    var model : Model? = null
    var miBundle:Bundle?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        iniciarComponentes()

    }
    //TODO ORGANIZAR EL PASO DE DATOS
    override fun onKeyDown(keyCode: Int, event: KeyEvent?) : Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "Se cierra el registro Activity", Toast.LENGTH_SHORT).show()
            devolverResultados()
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }

    //Funcion del boton 'Return'
    private fun devolverResultados(){
        var miIntent: Intent = Intent()
        miIntent.putExtra("resultado","Registro exitoso")
        var miBundle:Bundle= Bundle()
        miBundle.putSerializable("objetoOperaciones",model)
        miIntent.putExtras(miBundle)
        //miIntent.putExtra("obj",model)
        setResult(RESULT_OK,miIntent)
    }

    private fun iniciarComponentes(){
        // Se obtiene los datos
        miBundle = this.intent.extras
        //Se obtene el dato pasado desde 'Activity_main'
        model = miBundle?.getSerializable("model") as Model?

        // iniciamos
        var btnEnviar = findViewById<Button>(R.id.btnEnviar)
        btnEnviar.setOnClickListener { onclick() }
    }

    private fun onclick() {
        iniciar()

    }

    private fun iniciar() {
        //obtenemos los datos
        // Se almacenan en un mapa
        var dataStudent : HashMap<String, String> = getData()

        /**
         * Creamos el usuario
         * */
        //llamamos la funcion y le pasamos el mapa
        var newStudent : Estudiante = createStudent(dataStudent)
        //Sacamos el promedio
        var promedio : Double = newStudent.calcularPromedio()
        print("PROMEDIO ::: " + promedio)

        /**
         * Guardamos el usuario
         * */
        var resultsStudent : Boolean = saveStudent(newStudent)

        if (resultsStudent){
            var toast = Toast(this).apply { setText("Succesful registration") }
            toast.show()
        }else{
            var toast = Toast(this).apply { setText("User Exists!") }
            toast.show()
        }
        //Cantidad de estudiantes registrados
        var catidadStudents = model?.studentsRegisters()
        println(catidadStudents)

    }

    // Se obtiene los datos ingresadops por el usuario
    private fun getData() : HashMap<String,String>{
        // se crea mapa, para almacenar los datos
        var data : HashMap<String, String> = HashMap()
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
        var nameMatter1 : String = findViewById<EditText>(R.id.txtNameMatter1).text.toString()
        var valueMatter1 : String =findViewById<EditText>(R.id.txtValue1).text.toString()
        var nameMatter2 : String = findViewById<EditText>(R.id.txtNameMatter2).text.toString()
        var valueMatter2 : String =findViewById<EditText>(R.id.txtValue2).text.toString()
        var nameMatter3 : String = findViewById<EditText>(R.id.txtNameMatter3).text.toString()
        var valueMatter3 : String =findViewById<EditText>(R.id.txtValue3).text.toString()
        var nameMatter4 : String = findViewById<EditText>(R.id.txtNameMatter4).text.toString()
        var valueMatter4 : String =findViewById<EditText>(R.id.txtValue4).text.toString()
        var nameMatter5 : String = findViewById<EditText>(R.id.txtNameMatter5).text.toString()
        var valueMatter5 : String =findViewById<EditText>(R.id.txtValue5).text.toString()

        //Pasamos los valores
        data.put("document", document)
        data.put("name", name)
        data.put("txtAge", txtAge)
        data.put("phoneNumber", phoneNumber)
        data.put("direction", direction)
        data.put("nameMatter1", nameMatter1)
        data.put("valueMatter1", valueMatter1)
        data.put("nameMatter2", nameMatter2)
        data.put("valueMatter2", valueMatter2)
        data.put("nameMatter3", nameMatter3)
        data.put("valueMatter3", valueMatter3)
        data.put("nameMatter4", nameMatter4)
        data.put("valueMatter4", valueMatter4)
        data.put("nameMatter5", nameMatter5)
        data.put("valueMatter5", valueMatter5)
        //retornamos el mapa
        return data
    }

    private fun createStudent(data : HashMap<String, String>) : Estudiante{
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
        materia1.nombre = data.get("nameMatter1").toString()
        materia2.nombre = data.get("nameMatter2").toString()
        materia3.nombre = data.get("nameMatter3").toString()
        materia4.nombre = data.get("nameMatter4").toString()
        materia5.nombre = data.get("nameMatter5").toString()


        //Obtenemos el valor de la materia
        // == VALORES
        var valueMatter1 = data.get("valueMatter1").toString()
        var valueMatter2 = data.get("valueMatter2").toString()
        var valueMatter3 = data.get("valueMatter3").toString()
        var valueMatter4 = data.get("valueMatter4").toString()
        var valueMatter5 = data.get("valueMatter5").toString()
        //Se hace casting al valor
        var value1 = valueMatter1.toDouble()
        var value2 = valueMatter2.toDouble()
        var value3 = valueMatter3.toDouble()
        var value4 = valueMatter4.toDouble()
        var value5 = valueMatter5.toDouble()


        // VAlidamos que la notas este en este rango
        if (!(value1 >= 0 && value1 <= 5.0) && (value2 >= 0 && value2 <= 5.0) && (value3 >= 0 && value3 <= 5.0) && (value4 >= 0 && value4 <= 5.0) && (value5 >= 0 && value5 <= 5.0)){
            //HUbo un error
                //Dato incorrecto
            //return "Error"
        }
        materia1.nota = value1
        materia2.nota = value2
        materia3.nota = value3
        materia4.nota = value4
        materia5.nota = value5
        /**
         * Agregamos la materia creada al la estructura (GUARDAMOS)
         * */
        newEstudiante.materias.add(materia1)
        newEstudiante.materias.add(materia2)
        newEstudiante.materias.add(materia3)
        newEstudiante.materias.add(materia4)
        newEstudiante.materias.add(materia5)
        // se calcula el promedio de las materias ingresadas
        //newEstudiante.calcularPromedio()

        //lista.add(newEstudiante)

        //println("Datos :: " + lista)
        //println("Cantidad registros = " + lista.size)
        return newEstudiante
    }
    /**Funcion que controla guardar el estudiante credo*/
    fun saveStudent(student : Estudiante) : Boolean  {
        //Guardamos el estudiante
        var saveStudent = model?.saveStudent(student)
        println(saveStudent)
        // Validamos
        //false -> User Exists
        if(!(saveStudent == true)){ return false }
        //Es true -> successful registration
        return true
    }
}