package com.example.registrodatoscolegio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.registrodatoscolegio.Models.Model

class StatisticsActivity : AppCompatActivity() {

    /**
     * Se declara la clase model para la estructura de datos del aplicativo
     * */

    var model : Model? = null
    var miBundle:Bundle?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        iniciarComponentes()

    }
    private  fun iniciarComponentes(){
        // Se obtiene los datos
        miBundle = this.intent.extras
        //Se obtene el dato pasado desde 'ACtivity_main'
        model = miBundle?.getSerializable("model") as Model?

        iniciar()
    }
    fun iniciar(){
        var cantidadEstuden = findViewById<TextView>(R.id.txtCantEstuProce)
        var cantidadEstudenGanan = findViewById<TextView>(R.id.txtCantEstuGanan)
        var cantidadEstudenPierden = findViewById<TextView>(R.id.txtCantEstuPierden)
        var cantidadEstudenRecuperan = findViewById<TextView>(R.id.txtCantEstuRecuperan)

        //Cantidad estudiantes
        var cantidadEstu : Int? = model?.studentsRegisters()
        //Asignar dato
        cantidadEstuden.text = cantidadEstu.toString()

        //Cantidad estudiantes que ganan
        var cantidadEstuGanan : Int? = cantidadEstuGanan()
        cantidadEstudenGanan.text = cantidadEstuGanan.toString()

        //Cantidad estudiantes que pierden
        var cantiEstuPierden: Int? = cantidadEstuPierden()
        cantidadEstudenPierden.text = cantiEstuPierden.toString()

        //Cantidad estudiantes que recuperan
        var cantiEstuRecuperan: Int? = cantidadEstuRecuperan()
        cantidadEstudenRecuperan.text = cantiEstuRecuperan.toString()

    }
    /**Funciones que recuperamos las listas y obtenemos el tamaño de ellas*/
    fun cantidadEstuGanan(): Int?{
        //Lista de los estudiantes
        var listaEstuden = model?.listStudenWinner
         return listaEstuden?.size
    }
    fun cantidadEstuPierden(): Int?{
        //Lista de estudiantes que pierden
        var listStud = model?.listStudentLose
         return listStud?.size
    }
    fun cantidadEstuRecuperan(): Int?{
        //Lista de estudiantes que recuperan
        var listStud = model?.listStudentRecover
        return listStud?.size
    }


}