package com.example.registrodatoscolegio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.registrodatoscolegio.Clases.ContenedorMaterias
import com.example.registrodatoscolegio.Clases.Estudiante
import com.example.registrodatoscolegio.Clases.Materia
import com.example.registrodatoscolegio.Models.Model

class MainActivity : AppCompatActivity() {

    //Se declara la clase model para la estructura(DATA) sistema

    //
    var model : Model?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // se instancia la clase models
        model = Model()
        //Se inicia
        iniciarComponentes()

    }

    //Inicaiamos componenetes y los serializamos
    fun iniciarComponentes(){
        //Ventana SIGN-UP
        var btnRegistrate = findViewById<Button>(R.id.btnRegistrate)
        // Ventana Statitics
        var btnStatitics = findViewById<Button>(R.id.btnStatitics)
        //Ventana de ayuda
        var btnAHelp = findViewById<Button>(R.id.btnAyuda)

        btnRegistrate.setOnClickListener{ onClick(1) }
        btnStatitics.setOnClickListener{ onClick(2) }
        btnAHelp.setOnClickListener{ onClick(3) }

    }

    //Iniciamos para pasar entre actividades
    fun onClick(boton : Int){

        when(boton){
            1->{

                //decimos a donde se va a ir
                val registrar : Intent = Intent(this, RegistroActivity::class.java)
                var miBundle:Bundle = Bundle()
                miBundle.putSerializable("model",model)
                //Le pasamos la info al intent para que sea enviada
                registrar.putExtras(miBundle)
                registrar.putExtra("objeto",model)
                //Iniciamos la actividad
                //startActivity(registrar)
                response.launch(registrar)
            }
            2->{
                //Indicamos a dode ira
                val statitics:Intent = Intent(this, StatisticsActivity::class.java)
                var miBundle:Bundle = Bundle()
                miBundle.putSerializable("model",model)
                //le pasamos la informacion al intent para que sea enviada
                statitics.putExtras(miBundle)
                statitics.putExtra("objeto",model)
                response.launch(statitics)


            }
            3->{
                //Indicamos donde ir
                val help: Intent = Intent(this, HelpActivity::class.java)
                //Iniciamos la actividad
                startActivity(help)
            }
        }

    }
    //TODO -> ORGANIZAR EL PASO DE DATOS
    //Funcion para obtener los datos pasados de la otra actividad
    private val response = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ valor ->

        if (valor.resultCode == RESULT_OK){
            //resp y resp 2 almacenan el mismo dato, solo se muestran 2 formas como podria capturarse el dato
            val resp = valor?.data?.extras?.get("resultado") as String
            val resp2 = valor?.data?.getStringExtra("resultado")
            println("Valor respuesta=$resp y la resps2=$resp2")
            //capturamos el objeto nuevo y lo asignamos a operaciones
            model = valor?.data?.extras?.get("objetoOperaciones") as Model?
            model?.getEstudiantes()
        }
    }





}