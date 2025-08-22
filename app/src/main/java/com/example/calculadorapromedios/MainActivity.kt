package com.example.calculadorapromedios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlin.getValue
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val etCalificacion1 = findViewById<EditText>(R.id.etCalificacion1)
        val etCalificacion2 = findViewById<EditText>(R.id.etCalificacion2)
        val etCalificacion3 = findViewById<EditText>(R.id.etCalificacion3)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvresultado = findViewById<TextView>(R.id.tvresultado)


        //observa ek promedio calculado
        viewModel.promedio.observe(this, Observer { promedio ->
            tvresultado.text ="Resultado: ${String.format("%.2f", promedio)}"
        })

        //observa el mensaje de guardado

        viewModel.guardarMensaje.observe(this, Observer{message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        btnCalcular.setOnClickListener {
            try {
                val n1= etCalificacion1.text.toString().toDouble()
                val n2= etCalificacion2.text.toString().toDouble()
                val n3= etCalificacion3.text.toString().toDouble()

                viewModel.calcularPromedio(n1,n2,n3)
            } catch (Exception) {
            Toast.makeText(this,"Ingrese valores validos", Toast.LENGTH_SHORT).show()
        }


        }
    }
